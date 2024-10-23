package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.mapper.AuthRolePermissionMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;
import java.util.List;


import javax.annotation.Resource;

/**
 * 角色权限关联表(AuthRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2024-10-20 20:51:59
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
     * 通过ID列表查询多条数据
     *
     * @param idList 主键列表
     * @return 实例对象列表
     */
    @Override
    public List<AuthRolePermission> queryByIdList(List<Long> idList) {
        return this.authRolePermissionMapper.queryByIdList(idList);
    }

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 影响行数
     */
    @Override
    public Integer insert(AuthRolePermission authRolePermission) {
        return this.authRolePermissionMapper.insert(authRolePermission);
    }
    
    /**
     * 批量新增数据
     *
     * @param authRolePermissionList 实例对象列表
     * @return 影响行数
     */
    @Override
    public Integer insertBatch(List<AuthRolePermission> authRolePermissionList) {
        return this.authRolePermissionMapper.insertBatch(authRolePermissionList);
    }

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthRolePermission authRolePermission) {
        return this.authRolePermissionMapper.update(authRolePermission);
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
    
    /**
     * 条件查询
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission) {
        return this.authRolePermissionMapper.queryByCondition(authRolePermission);
    }
}
