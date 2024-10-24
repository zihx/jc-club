package com.jingdianjichi.subject.application.controller;

import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectLabelDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.application.dto.SubjectLabelDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SubjectCategoryController
 * Package: com.jingdianjichi.subject.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/4 13:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "父级id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);

            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage());
            return Result.fail("添加分类失败");
        }
    }

    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);

            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryPrimaryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage());
            return Result.fail("查询主分类失败");
        }
    }

    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "父级id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);

            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategoryByPrimary(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error:{}", e.getMessage());
            return Result.fail("根据主分类查询子分类失败");
        }
    }

    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);

            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error:{}", e.getMessage());
            return Result.fail("更新分类失败");
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);

            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage());
            return Result.fail("删除分类失败");
        }
    }

    /**
     * 查询大类下分类及其标签
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/queryCategoryAndLabel")
    public Result<List<SubjectCategoryDTO>> queryCategoryAndLabel(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convert(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategoryAndLabel(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = new ArrayList<>();
            subjectCategoryBOList.forEach(item -> {
                SubjectCategoryDTO categoryDTO = SubjectCategoryDTOConverter.INSTANCE.convert(item);
                List<SubjectLabelDTO> subjectLabelDTOList = SubjectLabelDTOConverter.INSTANCE.convert(item.getSubjectLabelBOList());
                categoryDTO.setSubjectLabelDTOList(subjectLabelDTOList);
                subjectCategoryDTOList.add(categoryDTO);
            });
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryAndLabel.error:{}", e.getMessage());
            return Result.fail("查询分类和标签失败");
        }
    }
}
