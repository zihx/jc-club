package com.jingdianjichi.oss.entity;

import lombok.Data;

/**
 * ClassName: FileInfo
 * Package: com.jingdianjichi.oss.entity
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/21 14:38
 * @Version 1.0
 */
@Data
public class FileInfo {
    /**
     * 文件名
     */
    private String fileName;

    private Boolean directoryFlag;

    private String etag;
}
