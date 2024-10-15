package com.jingdianjichi.auth.infra.basic.service.impl;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.mapper.AuthRoleMapper;
import com.jingdianjichi.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2024-09-28 21:08:10
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleMapper authRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRole queryById(Long id) {
        return this.authRoleMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthRole authRole) {
        return this.authRoleMapper.insert(authRole);
    }

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthRole authRole) {
        return this.authRoleMapper.update(authRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRoleMapper.deleteById(id) > 0;
    }
}
