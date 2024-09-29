package com.jingdianjichi.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: AuthApplication
 * Package: com.jindianjichi.auth
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/9/28 20:39
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
@MapperScan("com.jingdianjichi.**.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
