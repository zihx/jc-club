package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.bo.AuthRolePermissionBO;
import com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AuthUserPermissionDomainServiceImpl
 * Package: com.jingdianjichi.auth.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/16 16:18
 * @Version 1.0
 */
@Service("AuthUserPermissionDomainService")
@Slf4j
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        List<AuthRolePermission> authRolePermissionList = new ArrayList<>();

        Long roleId = authRolePermissionBO.getRoleId();
        authRolePermissionBO.getPermissionIdList().forEach(permissionId -> {
           AuthRolePermission authRolePermission = new AuthRolePermission();
           authRolePermission.setRoleId(roleId);
           authRolePermission.setPermissionId(permissionId);
           authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
           authRolePermissionList.add(authRolePermission);
        });

        int count = authRolePermissionService.insertBatch(authRolePermissionList);
        return count > 0;
    }
}