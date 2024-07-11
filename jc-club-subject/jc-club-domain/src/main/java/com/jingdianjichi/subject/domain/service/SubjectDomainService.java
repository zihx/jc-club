package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;

/**
 * ClassName: SubjectInfoDomainService
 * Package: com.jingdianjichi.subject.domain.service
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 14:31
 * @Version 1.0
 */
public interface SubjectDomainService {
    void add(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
