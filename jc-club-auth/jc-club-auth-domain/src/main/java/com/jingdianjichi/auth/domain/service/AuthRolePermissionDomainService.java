package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.AuthRolePermissionBO;

/**
 * ClassName: AuthUserPermissionDomainService
 * Package: com.jingdianjichi.auth.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/16 16:18
 * @Version 1.0
 */
public interface AuthRolePermissionDomainService {
    Boolean add(AuthRolePermissionBO authRolePermissionBO);
}
