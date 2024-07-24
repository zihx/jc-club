package com.jingdianjichi.subject.domain.service.impl;

import com.jingdianjichi.subject.common.enums.CategoryTypeEnum;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.bo.SubjectLabelBO;
import com.jingdianjichi.subject.domain.convert.SubjectLabelBOConverter;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: SubjectLabelDomainServiceImpl
 * Package: com.jingdianjichi.subject.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 21:48
 * @Version 1.0
 */
@Service("subjectLabelDomainService")
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelBOConverter.INSTANCE.convert(subjectLabelBO);

        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        return subjectLabelService.insert(subjectLabel) > 0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelBOConverter.INSTANCE.convert(subjectLabelBO);

        return subjectLabelService.update(subjectLabel) > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelBOConverter.INSTANCE.convert(subjectLabelBO);

        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        return subjectLabelService.update(subjectLabel) > 0;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(subjectLabelBO.getCategoryId());
        if (subjectCategory != null && CategoryTypeEnum.Primary.getCode() == subjectCategory.getCategoryType()) {
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBO.getCategoryId());
            subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            List<SubjectLabel> subjectLabelList = subjectLabelService.queryByCondition(subjectLabel);
            return SubjectLabelBOConverter.INSTANCE.convert(subjectLabelList);
        }

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(subjectLabelBO.getCategoryId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(subjectMappingList)) {
            return Collections.emptyList();
        }

        List<Long> idList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryByIds(idList);
        return SubjectLabelBOConverter.INSTANCE.convert(subjectLabelList);
    }

}
