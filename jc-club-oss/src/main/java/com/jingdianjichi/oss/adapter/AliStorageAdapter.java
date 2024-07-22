package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import com.jingdianjichi.oss.util.MinioUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: AliStorageServiceImpl
 * Package: com.jingdianjichi.oss.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 15:36
 * @Version 1.0
 */
public class AliStorageAdapter implements StorageAdapter {

    @Resource
    private MinioUtil minioUtil;

    @Override
    public void createBucket(String bucketName) throws Exception {

    }

    @Override
    public void deleteBucket(String bucketName) throws Exception {

    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) throws Exception {

    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) throws Exception {
        return null;
    }

    @Override
    public void deleteObject(String bucketName, String objectName) throws Exception {

    }

    @Override
    public List<String> getAllBuckets() throws Exception {
        List<String> allBuckets = minioUtil.getAllBuckets();
        allBuckets.add("ali");
        return allBuckets;
    }

    @Override
    public List<FileInfo> getAllObjects(String bucketName) throws Exception {
        return Collections.emptyList();
    }
}
