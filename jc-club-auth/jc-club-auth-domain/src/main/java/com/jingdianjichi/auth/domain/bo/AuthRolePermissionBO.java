package com.jingdianjichi.auth.domain.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Data
public class AuthRolePermissionBO implements Serializable {
    private static final long serialVersionUID = 682967946663758868L;

    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long permissionId;

    private List<Long> permissionIdList;
}
