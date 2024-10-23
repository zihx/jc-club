package com.jingdianjichi.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthUserDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.bo.AuthUserBO;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.domain.service.AuthUserRoleDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ClassName: UserController
 * Package: com.jingdianjichi.auth.application.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/9/28 21:27
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth/user/")
@Slf4j
public class AuthUserController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    @PostMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getUserName()), "用户名不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getEmail()), "邮箱不能为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getPassword()), "密码不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convert(authUserDTO);
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("AuthUserController.register.error:{}", e.getMessage());
            return Result.fail("注册用户失败");
        }
    }

    @PostMapping("update")
    public Result<Boolean> update(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Preconditions.checkNotNull(authUserDTO.getId(), "用户ID不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convert(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("AuthUserController.update.error:{}", e.getMessage());
            return Result.fail("更新用户失败");
        }
    }

    @PostMapping("changeStatus")
    public Result<Boolean> changeStatus(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Preconditions.checkNotNull(authUserDTO.getId(), "用户ID不能为空");
            Preconditions.checkNotNull(authUserDTO.getStatus(), "状态不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convert(authUserDTO);
            return Result.ok(authUserDomainService.changeStatus(authUserBO));
        } catch (Exception e) {
            log.error("AuthUserController.changeStatus.error:{}", e.getMessage());
            return Result.fail("更新用户状态失败");
        }
    }

    @PostMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Preconditions.checkNotNull(authUserDTO.getId(), "用户ID不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convert(authUserDTO);
            return Result.ok(authUserDomainService.delete(authUserBO));
        } catch (Exception e) {
            log.error("AuthUserController.delete.error:{}", e.getMessage());
            return Result.fail("删除用户失败");
        }
    }

    @RequestMapping("doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode) {
        try {
            Preconditions.checkArgument(!StringUtils.isBlank(validCode), "验证码不能为空!");

            return Result.ok(authUserDomainService.doLogin(validCode));
        } catch (Exception e) {
            log.error("AuthUserController.doLogin.error:{}", e.getMessage());
            return Result.fail("用户登录失败");
        }
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("getUserInfo")
    public Result<AuthUserDTO > getUserInfo(@RequestBody AuthUserDTO authUserDTO) {
        try {
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空!");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convert(authUserDTO);
            authUserBO = authUserDomainService.getUserInfo(authUserBO);
            authUserDTO = AuthUserDTOConverter.INSTANCE.convert(authUserBO);
            return Result.ok(authUserDTO);
        } catch (Exception e) {
            log.error("AuthUserController.getUserInfo.error:{}", e.getMessage());
            return Result.fail("获取用户信息失败");
        }
    }

    /**
     * 用户退出
     */
    @RequestMapping("logOut")
    public Result logOut(@RequestParam String userName) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(userName), "用户名不能为空");

            StpUtil.logout(userName);

            return Result.ok();
        } catch (Exception e) {
            log.error("AuthUserController.logOut.error:{}", e.getMessage());
            return Result.fail("用户登出失败");
        }
    }

}
