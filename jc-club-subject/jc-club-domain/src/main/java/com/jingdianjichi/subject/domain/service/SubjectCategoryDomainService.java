package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SubjectCategoryDomainService
 * Package: com.jingdianjichi.subject.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 11:34
 * @Version 1.0
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
