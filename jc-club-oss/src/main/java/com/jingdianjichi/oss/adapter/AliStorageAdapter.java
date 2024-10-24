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

    @Override
    public void createBucket(String bucket) {

    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucket, String objectName) {

    }

    @Override
    public List<String> getAllBucket() {
        return Collections.emptyList();
    }

    @Override
    public List<FileInfo> getAllFile(String bucket) {
        return Collections.emptyList();
    }

    @Override
    public InputStream downLoad(String bucket, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucket) {

    }

    @Override
    public void deleteObject(String bucket, String objectName) {

    }

    @Override
    public String getUrl(String bucket, String objectName) {
        return "";
    }
}
