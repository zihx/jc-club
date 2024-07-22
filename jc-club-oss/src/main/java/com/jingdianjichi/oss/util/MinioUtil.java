package com.jingdianjichi.oss.util;

import com.jingdianjichi.oss.entity.FileInfo;
import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: MinioUtil
 * Package: com.jingdianjichi.oss.util
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 14:14
 * @Version 1.0
 */
@Component
public class MinioUtil {

    @Resource
    private MinioClient minioClient;

    /**
     * 创建bucket
     * @param bucketName
     * @throws Exception
     */
    public void createBucket(String bucketName) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 删除bucket
     * @param bucketName
     * @throws Exception
     */
    public void deleteBucket(String bucketName) throws Exception {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /**
     * 上传文件
     * @param inputStream
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    public void uploadFile(InputStream inputStream, String bucketName, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
                // -1 表示输入流的大小未知，而 Integer.MAX_VALUE 表示允许上传的最大长度
                .stream(inputStream, -1, Integer.MAX_VALUE).build());
    }

    /**
     * 下载文件
     * @param bucketName
     * @param objectName
     * @return InputStream
     * @throws Exception
     */
    public InputStream downloadFile(String bucketName, String objectName) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 删除object
     * @param bucketName
     * @param objectName
     * @throws Exception
     */
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    /**
     * 获取所有bucket
     * @return
     * @throws Exception
     */
    public List<String> getAllBuckets() throws Exception {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.stream().map(Bucket::name).collect(Collectors.toList());
    }

    /**
     * 获取bucket中的所有object
     * @param bucketName
     * @return
     * @throws Exception
     */
    public List<FileInfo> getAllObjects(String bucketName) throws Exception {
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (Result<Item> result : results) {
            Item item = result.get();
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(item.objectName());
            fileInfo.setDirectoryFlag(item.isDir());
            fileInfo.setEtag(item.etag());
            fileInfoList.add(fileInfo);
        }
        return fileInfoList;
    }
}
