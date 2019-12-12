package com.study.rabbimq.web;

import com.alibaba.fastjson.JSON;
import com.study.common.base.Result;
import com.study.common.rabbitmq.Hello;
import com.study.rabbimq.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : SendMessage
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@RequestMapping("/text")
@RestController
public class SendMessage {


    @Autowired
    private SendMessageService sendMessageService;

    @PostMapping("/send")
    public Result send(@RequestBody Hello hello){
        log.info("发送消息为：{}", JSON.toJSONString(hello));
        Result send = sendMessageService.send(hello);
        return send;

    }



    @PostMapping("/send1")
    public Result send1(@RequestBody Hello hello){
        log.info("发送消息为：{}", JSON.toJSONString(hello));
        Result send1 = sendMessageService.send1(hello);
        return send1;

    }
    @PostMapping("/send2")
    public Result send2(@RequestBody Hello hello){
        log.info("发送消息为：{}", JSON.toJSONString(hello));
        Result send2 = sendMessageService.send2(hello);
        return send2;

    }


}
