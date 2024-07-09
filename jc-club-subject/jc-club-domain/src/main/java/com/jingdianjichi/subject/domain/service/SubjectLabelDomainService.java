package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.bo.SubjectLabelBO;

import java.util.List;

/**
 * ClassName: SubjectLabelDomainService
 * Package: com.jingdianjichi.subject.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 21:48
 * @Version 1.0
 */
public interface SubjectLabelDomainService {
    Boolean add(SubjectLabelBO subjectLabelBO);

    Boolean update(SubjectLabelBO subjectLabelBO);

    Boolean delete(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
