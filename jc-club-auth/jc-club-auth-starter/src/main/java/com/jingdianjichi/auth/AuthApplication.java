package com.jingdianjichi.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: AuthApplication
 * Package: com.jingdianjichi.auth
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/23 14:33
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
