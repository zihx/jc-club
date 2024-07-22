package com.jingdianjichi.oss.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MinioConfig
 * Package: com.jingdianjichi.oss.config
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 14:08
 * @Version 1.0
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String url;

    private String accessKey;

    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }
}
