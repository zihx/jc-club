package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.mapper.AuthRolePermissionMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 角色权限关联表(AuthRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl implements AuthRolePermissionService {
    @Resource
    private AuthRolePermissionMapper authRolePermissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRolePermission queryById(Long id) {
        return this.authRolePermissionMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRolePermission insert(AuthRolePermission authRolePermission) {
        this.authRolePermissionMapper.insert(authRolePermission);
        return authRolePermission;
    }

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRolePermission update(AuthRolePermission authRolePermission) {
        this.authRolePermissionMapper.update(authRolePermission);
        return this.queryById(authRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRolePermissionMapper.deleteById(id) > 0;
    }
}
