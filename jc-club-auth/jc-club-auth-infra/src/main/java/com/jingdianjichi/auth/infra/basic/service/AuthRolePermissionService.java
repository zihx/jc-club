package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import java.util.List;


/**
 * 角色权限关联表(AuthRolePermission)表服务接口
 *
 * @author makejava
 * @since 2024-10-20 20:51:59
 */
public interface AuthRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Long id);
    
    /**
     * 通过ID列表查询多条数据
     *
     * @param idList 主键列表
     * @return 实例对象列表
     */
    List<AuthRolePermission> queryByIdList(List<Long> idList);

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 影响行数
     */
    Integer insert(AuthRolePermission authRolePermission);

    /**
     * 批量新增数据
     *
     * @param authRolePermissionList 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(List<AuthRolePermission> authRolePermissionList);
    
    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    Integer update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 条件查询
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);
}
