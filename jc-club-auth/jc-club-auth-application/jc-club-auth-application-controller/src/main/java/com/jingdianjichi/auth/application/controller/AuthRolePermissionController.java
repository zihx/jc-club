package com.jingdianjichi.auth.application.controller;

import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthRolePermissionDTOConverter;
import com.jingdianjichi.auth.application.convert.AuthUserDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.bo.AuthRolePermissionBO;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: AuthUserPermissionController
 * Package: com.jingdianjichi.auth.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/16 16:17
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth/rolePermission/")
@Slf4j
public class AuthRolePermissionController {

    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;

    @PostMapping("add")
    public Result<Boolean> add(@RequestBody AuthRolePermissionDTO authRolePermissionDTO) {
        try {
            Preconditions.checkNotNull(authRolePermissionDTO.getRoleId(), "角色不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(authRolePermissionDTO.getPermissionIdList()), "权限不能为空");

            AuthRolePermissionBO authRolePermissionBO = AuthRolePermissionDTOConverter.INSTANCE.convert(authRolePermissionDTO);
            return Result.ok(authRolePermissionDomainService.add(authRolePermissionBO));
        } catch (Exception e) {
            log.error("AuthRolePermissionController.add.error:{}", e.getMessage());
            return Result.fail("添加角色权限失败");
        }
    }
}
