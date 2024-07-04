package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectInfoMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {
    @Resource
    private SubjectInfoMapper subjectInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo insert(SubjectInfo subjectInfo) {
        this.subjectInfoMapper.insert(subjectInfo);
        return subjectInfo;
    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoMapper.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectInfoMapper.deleteById(id) > 0;
    }
}
