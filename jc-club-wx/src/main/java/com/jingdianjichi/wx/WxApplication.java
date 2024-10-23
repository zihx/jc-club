package com.jingdianjichi.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: WxApplication
 * Package: com.jingdianjichi.wx
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 13:06
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }
}
