package com.jingdianjichi.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import com.jingdianjichi.subject.infra.basic.service.SubjectBriefService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * ClassName: BriefHandler
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:50
 * @Version 1.0
 */
@Component
public class BriefHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectTypeEnum getHandlerType() {
        return SubjectTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        String subjectAnswer = subjectInfoBO.getSubjectAnswer();
        Preconditions.checkArgument(StringUtils.isNotBlank(subjectAnswer), "答案不能为空");
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setSubjectAnswer(subjectAnswer);
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBrief = subjectBriefService.queryByCondition(subjectBrief);

        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return subjectOptionBO;
    }
}
