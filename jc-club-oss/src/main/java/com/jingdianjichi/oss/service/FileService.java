package com.jingdianjichi.oss.service;

import com.jingdianjichi.oss.adapter.StorageAdapter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: FileService
 * Package: com.jingdianjichi.oss.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 17:12
 * @Version 1.0
 */
@Service
public class FileService {

    @Resource
    private StorageAdapter storageService;

    public List<String> getAllBuckets() throws Exception {
        return storageService.getAllBuckets();
    }

    public void createBucket(String bucketName) throws Exception {
        storageService.createBucket(bucketName);
    }
}
