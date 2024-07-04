package com.jingdianjichi.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: SubjectApplication
 * Package: com.jingdianjichi.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/3 18:50
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
@MapperScan("com.jingdianjichi.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }
}
