package com.jingdianjichi.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectJudge;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MultipleHandler
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:49
 * @Version 1.0
 */
@Component
public class MultipleHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectTypeEnum getHandlerType() {
        return SubjectTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<OptionBO> optionList = subjectInfoBO.getOptionList();
        Preconditions.checkNotNull(optionList, "选项不能为空");
        List<SubjectMultiple> subjectRadioList = new ArrayList<>();
        Long id = subjectInfoBO.getId();
        optionList.forEach(option -> {
            SubjectMultiple subjectMultiple = new SubjectMultiple();
            subjectMultiple.setSubjectId(id);
            subjectMultiple.setOptionType(option.getOptionType());
            subjectMultiple.setOptionContent(option.getOptionContent());
            subjectMultiple.setIsCorrect(option.getIsCorrect());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode() );
            subjectRadioList.add(subjectMultiple);
        });
        subjectMultipleService.insertBatch(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId);
        subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMultiple> subjectMultipleList = subjectMultipleService.queryByCondition(subjectMultiple);

        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        List<OptionBO> optionList = new ArrayList<>();
        subjectMultipleList.forEach(sm -> {
            OptionBO optionBO = new OptionBO();
            optionBO.setOptionType(sm.getOptionType());
            optionBO.setOptionContent(sm.getOptionContent());
            optionBO.setIsCorrect(sm.getIsCorrect());
            optionList.add(optionBO);
        });
        subjectOptionBO.setOptionList(optionList);
        return subjectOptionBO;
    }
}
