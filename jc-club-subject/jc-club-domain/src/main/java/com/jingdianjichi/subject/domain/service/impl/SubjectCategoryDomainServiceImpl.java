package com.jingdianjichi.subject.domain.service.impl;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.bo.SubjectLabelBO;
import com.jingdianjichi.subject.domain.convert.SubjectCategoryBOConverter;
import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.convert.SubjectLabelBOConverter;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: SubjectCategoryDomainServiceImpl
 * Package: com.jingdianjichi.subject.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 11:35
 * @Version 1.0
 */
@Service("subjectCategoryDomainService")
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryByCondition(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryList);
        subjectCategoryBOList.forEach(item -> {
            SubjectMapping subjectMapping = new SubjectMapping();
            subjectMapping.setCategoryId(item.getId());
            subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            long count = subjectMappingService.querySubjectCount(subjectMapping);
            item.setCount(count);
        });
        return subjectCategoryBOList;
    }

    @Override
    public List<SubjectCategoryBO> queryCategoryByPrimary(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        return SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryService.queryByCondition(subjectCategory));
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryBO);

        return subjectCategoryService.update(subjectCategory) > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        return subjectCategoryService.update(subjectCategory) > 0;
    }

    @Override
    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(subjectCategoryBO.getId());
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryByCondition(subjectCategory);

        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryBOConverter.INSTANCE.convert(subjectCategoryList);
        subjectCategoryBOList.forEach(item -> {
            SubjectMapping subjectMapping = new SubjectMapping();
            subjectMapping.setCategoryId(item.getId());
            subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
            if (CollectionUtils.isEmpty(subjectMappingList)) {
                return;
            }
            List<Long> idList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
            List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryByIds(idList);
            List<SubjectLabelBO> subjectLabelBOList = SubjectLabelBOConverter.INSTANCE.convert(subjectLabelList);

            item.setSubjectLabelBOList(subjectLabelBOList);
        });
        return subjectCategoryBOList;
    }
}
