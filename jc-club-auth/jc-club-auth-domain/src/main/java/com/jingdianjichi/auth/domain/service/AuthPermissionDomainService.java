package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.AuthPermissionBO;

/**
 * ClassName: AuthPermissionDomainService
 * Package: com.jingdianjichi.auth.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:11
 * @Version 1.0
 */
public interface AuthPermissionDomainService {
    Boolean add(AuthPermissionBO authPermissionBO);

    Boolean update(AuthPermissionBO authPermissionBO);

    Boolean delete(AuthPermissionBO authPermissionBO);
}
