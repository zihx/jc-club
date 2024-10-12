package com.jingdianjichi.gateway.auth;

/**
 * ClassName: StpInterfaceImpl
 * Package: com.jingdianjichi.gateway.auth
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/9/29 19:13
 * @Version 1.0
 */

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jingdianjichi.gateway.entity.AuthPermission;
import com.jingdianjichi.gateway.entity.AuthRole;
import com.jingdianjichi.gateway.redis.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private final String authPermissionPrefix = "auth.permission";

    private final String authRolePrefix = "auth.role";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return getAuth(authPermissionPrefix, loginId.toString());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuth(authRolePrefix, loginId.toString());
    }

    private List<String> getAuth(String prefix, String loginId) {
        String authKey = redisUtil.buildKey(prefix, loginId);
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)) {
            return Collections.emptyList();
        }
        List<String> authList = new ArrayList<>();
        if (authRolePrefix.equals(prefix)) {
            List<AuthRole> roleList = new Gson().fromJson(authValue, new TypeToken<List<AuthRole>>() {
            }.getType());
            authList = roleList.stream().map(AuthRole::getRoleKey).collect(Collectors.toList());
        } else if (authPermissionPrefix.equals(prefix)) {
            List<AuthPermission> permissionList = new Gson().fromJson(authValue, new TypeToken<List<AuthPermission>>() {
            }.getType());
            authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        }
        return authList;
    }

}
