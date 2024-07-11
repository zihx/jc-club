package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: SubjectTypeHandlerFactory
 * Package: com.jingdianjichi.subject.domain.handler.subject
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/7/10 20:54
 * @Version 1.0
 */
@Component
public class SubjectTypeHandlerFactory {

    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    private final Map<SubjectTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectTypeEnum subjectTypeEnum = SubjectTypeEnum.getByCode(subjectType);
        return handlerMap.get(subjectTypeEnum);
    }

    @PostConstruct
    public void init() {
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
