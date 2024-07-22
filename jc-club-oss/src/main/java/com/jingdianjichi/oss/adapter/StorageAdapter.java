package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName: StorageService
 * Package: com.jingdianjichi.oss.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 15:33
 * @Version 1.0
 */
public interface StorageAdapter {
    /**
     * 创建bucket
     * @param bucketName
     * @throws Exception
     */
    void createBucket(String bucketName) throws Exception;

    /**
     * 删除bucket
     * @param bucketName
     * @throws Exception
     */
    void deleteBucket(String bucketName) throws Exception;

    /**
     * 上传文件
     * @param uploadFile
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) throws Exception;

    /**
     * 下载文件
     * @param bucketName
     * @param objectName
     * @return InputStream
     * @throws Exception
     */
    InputStream downloadFile(String bucketName, String objectName) throws Exception;

    /**
     * 删除object
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    void deleteObject(String bucketName, String objectName) throws Exception;

    /**
     * 获取所有bucket
     * @return
     * @throws Exception
     */
    List<String> getAllBuckets() throws Exception;

    /**
     * 获取bucket中的所有object
     * @param bucketName
     * @return
     * @throws Exception
     */
    List<FileInfo> getAllObjects(String bucketName) throws Exception;
}
