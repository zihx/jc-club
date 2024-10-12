package com.jingdianjichi.auth.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: PageInfo
 * Package: com.jingdianjichi.subject.common.entity
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 22:35
 * @Version 1.0
 */
@Data
public class PageInfo implements Serializable {

    private Integer pageNo;

    private Integer pageSize;
}
