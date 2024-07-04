package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectRadioMapper;
import com.jingdianjichi.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * 单选题信息表(SubjectRadio)表服务实现类
 *
 * @author makejava
 * @since 2024-07-03 21:47:27
 */
@Service("subjectRadioService")
public class SubjectRadioServiceImpl implements SubjectRadioService {
    @Resource
    private SubjectRadioMapper subjectRadioMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectRadio queryById(Long id) {
        return this.subjectRadioMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectRadio insert(SubjectRadio subjectRadio) {
        this.subjectRadioMapper.insert(subjectRadio);
        return subjectRadio;
    }

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectRadio update(SubjectRadio subjectRadio) {
        this.subjectRadioMapper.update(subjectRadio);
        return this.queryById(subjectRadio.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectRadioMapper.deleteById(id) > 0;
    }
}
