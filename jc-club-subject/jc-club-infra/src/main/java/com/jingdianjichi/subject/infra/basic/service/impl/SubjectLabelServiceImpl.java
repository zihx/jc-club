package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectLabelMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelMapper subjectLabelMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel insert(SubjectLabel subjectLabel) {
        this.subjectLabelMapper.insert(subjectLabel);
        return subjectLabel;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel update(SubjectLabel subjectLabel) {
        this.subjectLabelMapper.update(subjectLabel);
        return this.queryById(subjectLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelMapper.deleteById(id) > 0;
    }
}
