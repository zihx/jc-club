package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.AuthUserBO;
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
}
