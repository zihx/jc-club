package com.jingdianjichi.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jingdianjichi.oss.config.StorageConfig;
import com.jingdianjichi.oss.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: FileController
 * Package: com.jingdianjichi.oss.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 15:21
 * @Version 1.0
 */
@RestController
public class FileController {

    @Resource
    private FileService fileService;


    @GetMapping
    public List<String> getAllBuckets() throws Exception {
        return fileService.getAllBuckets();
    }

    @PostMapping
    public void createBucket(@RequestParam("bucketName") String bucketName) throws Exception {
        System.out.println(bucketName);
        fileService.createBucket(bucketName);
    }
}
