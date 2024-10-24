package com.jingdianjichi.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jingdianjichi.oss.config.StorageConfig;
import com.jingdianjichi.oss.entity.Result;
import com.jingdianjichi.oss.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/oss")
public class FileController {

    @Resource
    private FileService fileService;

    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() throws Exception {
        List<String> allBucket = fileService.getAllBucket();
        return allBucket.get(0);
    }

    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName) throws Exception {
        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile uploadFile, String bucket, String objectName) throws Exception {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }

}
