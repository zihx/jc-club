package com.jingdianjichi.wx.handler;

import com.jingdianjichi.wx.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * ClassName: ReceiveTextMsgHandler
 * Package: com.jingdianjichi.wx.handler
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 16:50
 * @Version 1.0
 */
@Component
@Slf4j
public class ReceiveTextMsgHandler implements WxChatMsgHandler {

    private static final String KEY_WORD = "验证码";
    private static final String LOGIN_PREFIX = "loginCode";

    @Resource
    private RedisUtil redisUtil;


    @Override
    public WxChatMsgTypeEnum getMsgType() {
        return WxChatMsgTypeEnum.TEXT_MSG;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("接收到文本消息事件");

        String content = messageMap.get("Content");
        if (!KEY_WORD.equals(content)) {
            return "";
        }

        String fromUserName = messageMap.get("FromUserName");
        String toUserName = messageMap.get("ToUserName");

        Random random = new Random();
        int num = 100000 + random.nextInt(900000);

        String numKey = redisUtil.buildKey(LOGIN_PREFIX, String.valueOf(num));
        redisUtil.setNx(numKey, fromUserName, 5L, TimeUnit.MINUTES);

        String numContent = "您当前的验证码是：" + num + "！ 5分钟内有效";
        String replyContent = "<xml>\n" +
                "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[" + numContent + "]]></Content>\n" +
                "</xml>";

        return replyContent;
    }

}