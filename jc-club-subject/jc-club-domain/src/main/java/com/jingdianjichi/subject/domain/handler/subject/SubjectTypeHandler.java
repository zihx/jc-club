package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;

/**
 * ClassName: SubjectTypeHandler
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:42
 * @Version 1.0
 */
public interface SubjectTypeHandler {

    SubjectTypeEnum getHandlerType();

    void add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO query(Long subjectId);
}
