package com.jingdianjichi.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: AuthUserDomainService
 * Package: com.jingdianjichi.auth.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/12 20:31
 * @Version 1.0
 */
public interface AuthUserDomainService {

    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    Boolean delete(AuthUserBO authUserBO);

    Boolean changeStatus(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);
}
