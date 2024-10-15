package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.bo.AuthRoleBO;
import com.jingdianjichi.auth.domain.convert.AuthRoleBOConverter;
import com.jingdianjichi.auth.domain.service.AuthRoleDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.service.AuthRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: AuthRoleDomainServiceImpl
 * Package: com.jingdianjichi.auth.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:12
 * @Version 1.0
 */
@Service("AuthRoleDomainService")
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convert(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        int count = authRoleService.insert(authRole);
        return count > 0;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convert(authRoleBO);

        int count = authRoleService.update(authRole);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convert(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        int count = authRoleService.update(authRole);
        return count > 0;
    }
}
