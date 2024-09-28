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
    private StorageAdapter storageAdapter;

    public List<String> getAllBuckets() throws Exception {
        return storageAdapter.getAllBuckets();
    }

    public void createBucket(String bucketName) throws Exception {
        storageAdapter.createBucket(bucketName);
    }
}
