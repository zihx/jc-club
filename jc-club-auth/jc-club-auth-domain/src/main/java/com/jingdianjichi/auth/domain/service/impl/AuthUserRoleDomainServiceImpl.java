package com.jingdianjichi.auth.domain.service.impl;

import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.domain.service.AuthUserRoleDomainService;
import com.jingdianjichi.auth.infra.basic.service.AuthUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: AuthUserRoleDomainServiceImpl
 * Package: com.jingdianjichi.auth.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/15 15:59
 * @Version 1.0
 */
@Service("AuthUserRoleDomainService")
@Slf4j
public class AuthUserRoleDomainServiceImpl implements AuthUserRoleDomainService {

    @Resource
    private AuthUserRoleService authUserRoleService;
}
