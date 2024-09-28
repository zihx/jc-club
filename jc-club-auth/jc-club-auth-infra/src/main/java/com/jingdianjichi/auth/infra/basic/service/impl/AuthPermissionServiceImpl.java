package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.mapper.AuthPermissionMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (AuthPermission)表服务实现类
 *
 * @author makejava
 * @since 2024-09-28 21:08:09
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
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthPermission insert(AuthPermission authPermission) {
        this.authPermissionMapper.insert(authPermission);
        return authPermission;
    }

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthPermission update(AuthPermission authPermission) {
        this.authPermissionMapper.update(authPermission);
        return this.queryById(authPermission.getId());
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
}
