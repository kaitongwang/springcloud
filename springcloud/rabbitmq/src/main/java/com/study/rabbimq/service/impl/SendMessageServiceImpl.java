package com.study.rabbimq.service.impl;

import com.study.common.base.Result;
import com.study.common.rabbitmq.Hello;
import com.study.rabbimq.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : SendMessageServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * diect
     * @param hello
     * @return
     */
    @Override
    public Result send(Hello hello) {
        log.info("往交换机发送消息");
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",hello);
        rabbitTemplate.convertAndSend("TestDirectExchange","Hello",hello);
        return Result.returnSuccess();
    }


    /**
     *  Fanout Exchange扇形(广播式)交换机
     * @param hello
     * @return
     */
    @Override
    public  Result send1(Hello hello){

        rabbitTemplate.convertAndSend("FanoutExchange","",hello);
        return Result.returnSuccess();


    }

    @Override
    public Result send2(Hello hello) {

        for (int i=0;i<50;i++){

            hello.setMessage(i+"");
            rabbitTemplate.convertAndSend("work-queue",hello);
        }

       return Result.returnSuccess();
    }


}
