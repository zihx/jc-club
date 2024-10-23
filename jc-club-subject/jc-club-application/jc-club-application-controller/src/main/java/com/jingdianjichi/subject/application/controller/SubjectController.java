package com.jingdianjichi.subject.application.controller;

import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.OptionDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectInfoDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.bo.OptionBO;
import com.jingdianjichi.subject.domain.bo.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.bo.SubjectInfoBO;
import com.jingdianjichi.subject.domain.service.SubjectDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: SubjectInfoController
 * Package: com.jingdianjichi.subject.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 14:31
 * @Version 1.0
 */
@RestController
@RequestMapping("subject")
@Slf4j
public class SubjectController {

    @Resource
    private SubjectDomainService subjectDomainService;

    @PostMapping("add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()), "所属类目不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "所属标签不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convert(subjectInfoDTO);
            List<OptionBO> optionBOList = OptionDTOConverter.INSTANCE.convert(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(optionBOList);
            subjectDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}", e.getMessage());
            return Result.fail("添加题目失败");
        }
    }

    @PostMapping("getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "所属类目不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "所属标签不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convert(subjectInfoDTO);
            PageResult<SubjectInfoBO> pageResult = subjectDomainService.getSubjectPage(subjectInfoBO);

            return Result.ok(pageResult);
        } catch (Exception e) {
            log.error("SubjectController.getSubjectPage.error:{}", e.getMessage());
            return Result.fail("查询题目列表失败");
        }
    }

    @PostMapping("querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "ID不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convert(subjectInfoDTO);

            subjectInfoBO = subjectDomainService.querySubjectInfo(subjectInfoBO);

            subjectInfoDTO = SubjectInfoDTOConverter.INSTANCE.convert(subjectInfoBO);
            return Result.ok(subjectInfoDTO);
        } catch (Exception e) {
            log.error("SubjectController.querySubjectInfo.error:{}", e.getMessage());
            return Result.fail("查询题目信息失败");
        }
    }
}
