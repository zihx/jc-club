package com.jingdianjichi.oss.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jingdianjichi.oss.adapter.AliStorageAdapter;
import com.jingdianjichi.oss.adapter.MinioStorageAdapter;
import com.jingdianjichi.oss.adapter.StorageAdapter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: Storage
 * Package: com.jingdianjichi.oss.config
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 19:09
 * @Version 1.0
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "storage.service")
public class StorageConfig {

    private String type;

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if("minio".equalsIgnoreCase(type)) {
            return new MinioStorageAdapter();
        } else if("ali".equalsIgnoreCase(type)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("Unsupported storage service type: " + type);
        }
    }
}
