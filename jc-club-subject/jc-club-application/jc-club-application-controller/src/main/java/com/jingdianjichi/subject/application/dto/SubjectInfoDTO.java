package com.jingdianjichi.subject.application.dto;

import com.jingdianjichi.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)实体类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
    private static final long serialVersionUID = 157005607877386791L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 简答题答案
     */
    private String subjectAnswer;
    /**
     * 单选。多选，判断选项列表
     */
    private List<OptionDTO> optionList;
    /**
     * 插入时所属类目
     */
    private List<Long> categoryIds;
    /**
     * 插入入时所属标签
     */
    private List<Long> labelIds;
    /**
     * 查询时所属类目
     */
    private Long categoryId;
    /**
     * 查询时所属标签
     */
    private Long labelId;

    private List<String> labelName;
}

