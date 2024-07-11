package com.jingdianjichi.subject.domain.service.impl;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.bo.SubjectOptionBO;
import com.jingdianjichi.subject.domain.convert.SubjectInfoBOConverter;
import com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandler;
import com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.jingdianjichi.subject.domain.service.SubjectDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.service.SubjectInfoService;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: SubjectInfoDomainServiceImpl
 * Package: com.jingdianjichi.subject.domain.service.impl
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 14:31
 * @Version 1.0
 */
@Service("subjectInfoDomainService")
@Slf4j
public class SubjectDomainServiceImpl implements SubjectDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;
    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    @Transactional
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = SubjectInfoBOConverter.INSTANCE.convert(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        subjectInfoService.insert(subjectInfo);

        Long id = subjectInfo.getId();

        subjectInfoBO.setId(id);
        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectTypeHandler.add(subjectInfoBO);

        List<SubjectMapping> subjectMappingList = new ArrayList<>();
        subjectInfoBO.getCategoryIds().forEach(categoryId -> {
            subjectInfoBO.getLabelIds().forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(id);
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.insertBatch(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        int pageNo = subjectInfoBO.getPageNo(), pageSize = subjectInfoBO.getPageSize();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        int offset = (pageNo - 1) * pageSize;

        SubjectInfo subjectInfo = SubjectInfoBOConverter.INSTANCE.convert(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        Long categoryId = subjectInfoBO.getCategoryId(), labelId = subjectInfoBO.getLabelId();
        int count = subjectInfoService.countByCondition(subjectInfo, categoryId, labelId);
        if (count == 0) {
            return pageResult;
        }

        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, categoryId, labelId, offset, pageSize);

        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoBOConverter.INSTANCE.convert(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());

        SubjectTypeHandler subjectTypeHandler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO subjectOptionBO = subjectTypeHandler.query(subjectInfo.getId());

        subjectInfoBO = SubjectInfoBOConverter.INSTANCE.convert(subjectInfo, subjectOptionBO);

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIds = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        log.info("labelIds {}", labelIds);
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryByIds(labelIds);
        List<String> labelNameList = subjectLabelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        subjectInfoBO.setLabelName(labelNameList);
        return subjectInfoBO;
    }
}
