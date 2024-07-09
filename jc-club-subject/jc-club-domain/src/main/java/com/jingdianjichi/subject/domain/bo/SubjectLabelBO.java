package com.jingdianjichi.subject.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Data
public class SubjectLabelBO implements Serializable {
    private static final long serialVersionUID = -24269121153202095L;
/**
     * 主键
     */
    private Long id;
/**
     * 标签分类
     */
    private String labelName;
/**
     * 排序
     */
    private Integer sortNum;

    private Long categoryId;

}

