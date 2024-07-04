package com.jingdianjichi.subject.domain.service.impl;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectCategoryMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: SubjectCategoryDomainServiceImpl
 * Package: com.jingdianjichi.subject.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 11:35
 * @Version 1.0
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategoryBO.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategoryBO.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);

        return SubjectCategoryConverter.INSTANCE.convert(subjectCategoryList);
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convert(subjectCategoryBO);

        return subjectCategoryService.update(subjectCategory) > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convert(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());

        return subjectCategoryService.update(subjectCategory) > 0;
    }
}
