package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import java.util.List;


/**
 * (AuthPermission)表服务接口
 *
 * @author makejava
 * @since 2024-10-20 20:52:00
 */
public interface AuthPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthPermission queryById(Long id);
    
    /**
     * 通过ID列表查询多条数据
     *
     * @param idList 主键列表
     * @return 实例对象列表
     */
    List<AuthPermission> queryByIdList(List<Long> idList);

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 影响行数
     */
    Integer insert(AuthPermission authPermission);

    /**
     * 批量新增数据
     *
     * @param authPermissionList 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(List<AuthPermission> authPermissionList);
    
    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer update(AuthPermission authPermission);

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
     * @param authPermission 实例对象
     * @return 实例对象
     */
    List<AuthPermission> queryByCondition(AuthPermission authPermission);
}
