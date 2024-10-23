package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.mapper.AuthPermissionMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;
import java.util.List;


import javax.annotation.Resource;

/**
 * (AuthPermission)表服务实现类
 *
 * @author makejava
 * @since 2024-10-20 20:52:00
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionMapper authPermissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthPermission queryById(Long id) {
        return this.authPermissionMapper.queryById(id);
    }
    
    /**
     * 通过ID列表查询多条数据
     *
     * @param idList 主键列表
     * @return 实例对象列表
     */
    @Override
    public List<AuthPermission> queryByIdList(List<Long> idList) {
        return this.authPermissionMapper.queryByIdList(idList);
    }

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 影响行数
     */
    @Override
    public Integer insert(AuthPermission authPermission) {
        return this.authPermissionMapper.insert(authPermission);
    }
    
    /**
     * 批量新增数据
     *
     * @param authPermissionList 实例对象列表
     * @return 影响行数
     */
    @Override
    public Integer insertBatch(List<AuthPermission> authPermissionList) {
        return this.authPermissionMapper.insertBatch(authPermissionList);
    }

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthPermission authPermission) {
        return this.authPermissionMapper.update(authPermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authPermissionMapper.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public List<AuthPermission> queryByCondition(AuthPermission authPermission) {
        return this.authPermissionMapper.queryByCondition(authPermission);
    }
}
