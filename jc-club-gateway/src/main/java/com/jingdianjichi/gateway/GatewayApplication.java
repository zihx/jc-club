package com.jingdianjichi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: GatewayApplication
 * Package: com.jingdianjichi.gateway
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/22 22:08
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
