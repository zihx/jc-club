package com.jingdianjichi.wx.controller;


import com.jingdianjichi.wx.handler.WxChatMsgHandler;
import com.jingdianjichi.wx.handler.WxChatMsgHandlerFactory;
import com.jingdianjichi.wx.util.MessageUtil;
import com.jingdianjichi.wx.util.SHA1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * ClassName: CallBackController
 * Package: com.jingdianjichi.wx.controller
 * Description:
 *
 * @Author Chao Fang
 * @Create 2024/10/22 13:16
 * @Version 1.0
 */
@RestController
@Slf4j
public class CallBackController {

    private static final String token = "aaaaaazihuanxue";

    @Resource
    private WxChatMsgHandlerFactory wxChatMsgHandlerFactory;

    /**
     * 回调消息校验
     */
    @GetMapping("callback")
    public String callback(@RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("echostr") String echostr) {
        log.info("get验签请求参数：signature:{}，timestamp:{}，nonce:{}，echostr:{}",
                signature, timestamp, nonce, echostr);

        String shaStr = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(shaStr)) {
            return echostr;
        }
        return "unknown";
    }

    @PostMapping(value = "callback", produces = "application/xml;charset=UTF-8")
    public String callback(
            @RequestBody String requestBody,
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam(value = "msg_signature", required = false) String msgSignature) {
        log.info("接收到微信消息：requestBody：{}", requestBody);

        Map<String, String> messageMap = MessageUtil.parseXml(requestBody);
        String msgType = messageMap.get("MsgType");
        String event = messageMap.get("Event") == null ? "" : messageMap.get("Event");
        log.info("msgType:{},event:{}", msgType, event);

        StringBuilder sb = new StringBuilder();
        sb.append(msgType);
        if (!StringUtils.isEmpty(event)) {
            sb.append(".");
            sb.append(event);
        }

        String msgTypeKey = sb.toString();
        WxChatMsgHandler wxChatMsgHandler = wxChatMsgHandlerFactory.getHandlerByMsgType(msgTypeKey);
        if (Objects.isNull(wxChatMsgHandler)) {
            return "unknown";
        }
        String replyContent = wxChatMsgHandler.dealMsg(messageMap);
        log.info("replyContent:{}", replyContent);
        return replyContent;
    }

}
