package com.jingdianjichi.subject.domain.handler.subject;

import com.baomidou.mybatisplus.extension.api.R;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.service.SubjectRadioService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: RadioHandler
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:49
 * @Version 1.0
 */
@Component
public class RadioHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectTypeEnum getHandlerType() {
        return SubjectTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<OptionBO> optionList = subjectInfoBO.getOptionList();
        Preconditions.checkNotNull(optionList, "选项不能为空");
        List<SubjectRadio> subjectRadioList = new ArrayList<>();
        Long id = subjectInfoBO.getId();
        optionList.forEach(option -> {
            SubjectRadio subjectRadio = new SubjectRadio();
            subjectRadio.setSubjectId(id);
            subjectRadio.setOptionType(option.getOptionType());
            subjectRadio.setOptionContent(option.getOptionContent());
            subjectRadio.setIsCorrect(option.getIsCorrect());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode() );
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.insertBatch(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(Long subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(subjectId);
        subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectRadio> subjectRadioList = subjectRadioService.queryByCondition(subjectRadio);

        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        List<OptionBO> optionList = new ArrayList<>();
        subjectRadioList.forEach(sm -> {
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
