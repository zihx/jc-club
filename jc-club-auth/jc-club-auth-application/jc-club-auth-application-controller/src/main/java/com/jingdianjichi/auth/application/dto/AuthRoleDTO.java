package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Data
public class AuthRoleDTO implements Serializable {
    private static final long serialVersionUID = 734682541222057940L;

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色唯一标识
     */
    private String roleKey;

}
