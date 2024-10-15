package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.jingdianjichi.auth.common.enums.AuthUserStatusEnum;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.convert.AuthUserBOConverter;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import com.jingdianjichi.auth.infra.basic.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    private static final String SALT = "zihuanxue";

    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convert(authUserBO);
        authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), SALT));
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        Integer count = authUserService.insert(authUser);
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
}
