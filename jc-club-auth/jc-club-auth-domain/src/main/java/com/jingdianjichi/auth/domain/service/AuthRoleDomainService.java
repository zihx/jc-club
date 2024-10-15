package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.AuthRoleBO;

/**
 * ClassName: AuthRoleDomainService
 * Package: com.jingdianjichi.auth.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:11
 * @Version 1.0
 */
public interface AuthRoleDomainService {
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}
