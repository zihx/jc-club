package com.jingdianjichi.wx.handler;

import java.util.Map;

/**
 * ClassName: WxChatMsgHandler
 * Package: com.jingdianjichi.wx.handler
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 16:44
 * @Version 1.0
 */
public interface WxChatMsgHandler {

    WxChatMsgTypeEnum getMsgType();

    String dealMsg(Map<String, String> messageMap);

}
