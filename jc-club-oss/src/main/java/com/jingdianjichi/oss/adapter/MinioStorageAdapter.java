package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import com.jingdianjichi.oss.util.MinioUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: MinioStorageServiceImpl
 * Package: com.jingdianjichi.oss.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 15:35
 * @Version 1.0
 */
public class MinioStorageAdapter implements StorageAdapter {

    @Resource
    private MinioUtil minioUtil;

    @Override
    public void createBucket(String bucketName) throws Exception {
        minioUtil.createBucket(bucketName);
    }

    @Override
    public void deleteBucket(String bucketName) throws Exception {
        minioUtil.deleteBucket(bucketName);
    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) throws Exception {
        minioUtil.createBucket(bucketName);
        if (objectName != null) {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucketName, objectName + "/" + uploadFile.getName());
        } else {
            minioUtil.uploadFile(uploadFile.getInputStream(), bucketName, uploadFile.getName());
        }
    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) throws Exception {
        return minioUtil.downloadFile(bucketName, objectName);
    }

    @Override
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioUtil.deleteObject(bucketName, objectName);
    }

    @Override
    public List<String> getAllBuckets() throws Exception {
        return minioUtil.getAllBuckets();
    }

    @Override
    public List<FileInfo> getAllObjects(String bucketName) throws Exception {
        return minioUtil.getAllObjects(bucketName);
    }
}
