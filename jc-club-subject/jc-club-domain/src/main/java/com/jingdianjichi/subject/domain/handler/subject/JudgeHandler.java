package com.jingdianjichi.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import com.jingdianjichi.subject.infra.basic.entity.SubjectJudge;
import com.jingdianjichi.subject.infra.basic.service.SubjectJudgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: JudgeHandler
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:50
 * @Version 1.0
 */
@Component
@Slf4j
public class JudgeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectTypeEnum getHandlerType() {
        return SubjectTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<OptionBO> optionList = subjectInfoBO.getOptionList();
        Preconditions.checkNotNull(optionList, "选项不能为空");
        List<SubjectJudge> subjectJudgeList = new ArrayList<>();
        Long id = subjectInfoBO.getId();
        optionList.forEach(option -> {
            SubjectJudge subjectJudge = new SubjectJudge();
            subjectJudge.setSubjectId(id);
            subjectJudge.setIsCorrect(option.getIsCorrect());
            subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectJudgeList.add(subjectJudge);
        });
        subjectJudgeService.insertBatch(subjectJudgeList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(subjectId);
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectJudge> subjectJudgeList = subjectJudgeService.queryByCondition(subjectJudge);

        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        List<OptionBO> optionList = new ArrayList<>();
        subjectJudgeList.forEach(sj -> {
            OptionBO optionBO = new OptionBO();
            optionBO.setIsCorrect(sj.getIsCorrect());
            optionList.add(optionBO);
        });
        subjectOptionBO.setOptionList(optionList);
        return subjectOptionBO;
    }
}
