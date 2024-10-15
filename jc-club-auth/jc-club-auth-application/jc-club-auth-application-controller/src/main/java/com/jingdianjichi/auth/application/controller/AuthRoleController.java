package com.jingdianjichi.auth.application.controller;

import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthRoleDTOConverter;
import com.jingdianjichi.auth.application.convert.AuthUserDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.bo.AuthRoleBO;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.service.AuthRoleDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: AuthRoleController
 * Package: com.jingdianjichi.auth.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth/role/")
@Slf4j
public class AuthRoleController {

    @Resource
    private AuthRoleDomainService authRoleDomainService;

    @PostMapping("add")
    public Result<Boolean> add(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(authRoleDTO.getRoleName()), "角色名称不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(authRoleDTO.getRoleKey()), "角色键不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convert(authRoleDTO);

            return Result.ok(authRoleDomainService.add(authRoleBO));
        } catch (Exception e) {
            return Result.fail("添加角色失败");
        }
    }

    @PostMapping("update")
    public Result<Boolean> update(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            Preconditions.checkNotNull(authRoleDTO.getId(), "角色ID不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convert(authRoleDTO);

            return Result.ok(authRoleDomainService.update(authRoleBO));
        } catch (Exception e) {
            return Result.fail("更新角色失败");
        }
    }

    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            Preconditions.checkNotNull(authRoleDTO.getId(), "角色ID不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convert(authRoleDTO);

            return Result.ok(authRoleDomainService.delete(authRoleBO));
        } catch (Exception e) {
            return Result.fail("删除角色失败");
        }
    }
}
