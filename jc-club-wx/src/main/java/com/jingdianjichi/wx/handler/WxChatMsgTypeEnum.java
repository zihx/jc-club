package com.jingdianjichi.wx.handler;

/**
 * ClassName: WxChatMsgTypeEnum
 * Package: com.jingdianjichi.wx.handler
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 16:41
 * @Version 1.0
 */
public enum WxChatMsgTypeEnum {

    SUBSCRIBE("event.subscribe", "用户关注事件"),
    TEXT_MSG("text", "接收用户文本消息");

    private String msgType;

    private String desc;

    WxChatMsgTypeEnum(String msgType, String desc) {
        this.msgType = msgType;
        this.desc = desc;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getDesc() {
        return desc;
    }
}
