package com.jingdianjichi.wx.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ClassName: WxChatMsgHandlerFactory
 * Package: com.jingdianjichi.wx.handler
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 16:45
 * @Version 1.0
 */
@Component
public class WxChatMsgHandlerFactory{

    @Resource
    private List<WxChatMsgHandler> wxChatMsgHandlerList;

    private Map<String, WxChatMsgHandler> handlerMap = new HashMap<>();

    public WxChatMsgHandler getHandlerByMsgType(String msgType) {
        return handlerMap.get(msgType);
    }

    @PostConstruct
    public void initial() throws Exception {
        for (WxChatMsgHandler wxChatMsgHandler : wxChatMsgHandlerList) {
            handlerMap.put(wxChatMsgHandler.getMsgType().getMsgType(), wxChatMsgHandler);
        }
    }

}
