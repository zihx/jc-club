package com.jingdianjichi.auth.application.controller;

import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthPermissionDTOConverter;
import com.jingdianjichi.auth.application.convert.AuthUserDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.bo.AuthPermissionBO;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: AuthPermissionController
 * Package: com.jingdianjichi.auth.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/14 17:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth/permission/")
@Slf4j
public class AuthPermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    @PostMapping("add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(authPermissionDTO.getName()), "权限名称不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(authPermissionDTO.getPermissionKey()), "权限键不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "父权限ID不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getType(), "权限类型不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convert(authPermissionDTO);
            return Result.ok(authPermissionDomainService.add(authPermissionBO));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convert(authPermissionDTO);
            return Result.ok(authPermissionDomainService.update(authPermissionBO));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convert(authPermissionDTO);
            return Result.ok(authPermissionDomainService.delete(authPermissionBO));
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }
}
