package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.common.enums.StatusEnum;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.convert.AuthUserBOConverter;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.infra.basic.entity.*;
import com.jingdianjichi.auth.infra.basic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: AuthUserDomainServiceImpl
 * Package: com.jingdianjichi.auth.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/12 20:31
 * @Version 1.0
 */
@Service("AuthUserDomainService")
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;
    @Resource
    private AuthRoleService authRoleService;
    @Resource
    private AuthUserRoleService authUserRoleService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private AuthRolePermissionService authRolePermissionService;
    @Resource
    private AuthPermissionService authPermissionService;
    @Resource
    private AuthUserDomainService authUserDomainService;

    private static final String SALT = "zihuanxue";
    private static final String NORMAL_USER = "normal_user";
    private static final String AUTH_PERMISSION_PREFIX = "auth.permission";
    private static final String AUTH_ROLE_PREFIX = "auth.role";
    private static final String LOGIN_PREFIX = "loginCode";

    @Override
    @Transactional
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convert(authUserBO);
        if (StringUtils.isNotBlank(authUser.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), SALT));
        }
        authUser.setStatus(StatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.insert(authUser);

        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(NORMAL_USER);
        authRole = authRoleService.queryByCondition(authRole);

        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(authUser.getId());
        authUserRole.setRoleId(authRole.getId());
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);

        String roleKey = redisUtil.buildKey(AUTH_ROLE_PREFIX, authUser.getUserName());
        List<AuthRole> authRoleList = new ArrayList<>();
        authRoleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(authRoleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(authRole.getId());
        authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<AuthRolePermission> authRolePermissionList = authRolePermissionService.queryByCondition(authRolePermission);

        List<Long> permissionIdList = authRolePermissionList.stream().map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        List<AuthPermission> authPermissionList = authPermissionService.queryByIdList(permissionIdList);
        String permissionKey = redisUtil.buildKey(AUTH_PERMISSION_PREFIX, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(authPermissionList));

        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convert(authUserBO);

        Integer count = authUserService.update(authUser);
        return count > 0;
    }

    @Override
    public Boolean changeStatus(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convert(authUserBO);

        Integer count = authUserService.update(authUser);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convert(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        Integer count = authUserService.update(authUser);
        return count > 0;
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        authUserDomainService.register(authUserBO);
        StpUtil.login(openId);
        return StpUtil.getTokenInfo();
    }
}
