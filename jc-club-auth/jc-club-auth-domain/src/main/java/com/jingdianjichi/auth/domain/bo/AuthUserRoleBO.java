package com.jingdianjichi.auth.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色表(AuthUserRole)实体类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Data
public class AuthUserRoleBO implements Serializable {
    private static final long serialVersionUID = -20022440659946685L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;
}
