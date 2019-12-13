package com.study.rabbitmqconsumer.consumer;

import com.alibaba.fastjson.JSON;
import com.study.common.rabbitmq.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : DirectReceiver
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Component
public class DirectReceiver {


    @RabbitListener(queues="TestDirectQueue")
    @RabbitHandler
    public  void   sonsumerTestDirectRouting(Hello hello){

      log.info("TestDirectQueue接收到消息:{}",hello);

    }

    @RabbitListener(queues="Hello")
    @RabbitHandler
    public  void   sonsumerHello(Hello hello){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        log.info("Hello:{}",hello);



    }

    @RabbitListener(queues="Fanout1")
    @RabbitHandler
    public  void  Fanout1(Hello hello){

        log.info("Fanout1:{}",hello);

    }


    @RabbitListener(queues="Fanout2")
    @RabbitHandler
    public  void   Fanout2(Hello hello){

        log.info("Fanout2:{}",hello);

    }

        // 通过注解自动创建 spring.work.queue 队列
        @RabbitListener(queues = "work-queue")
        public void listen(Hello hello) {
            System.out.println("work模式 接收到消息：" + hello.getMessage());
        }

        // 创建两个队列共同消费
        @RabbitListener(queues= "work-queue")
        public void listen2(Hello hello ) {
            System.out.println("work模式二 接收到消息：" + hello.getMessage());
        }








    @RabbitListener(queues="DealConsumer")
    @RabbitHandler
    public  void   DealConsumer(Hello hello){
        System.out.println("进入了死信队列");
        log.info("Hello:{}",hello);

    }

    @RabbitListener(queues = "topic.Queue2")
    @RabbitHandler
    public void topicQueue2(Hello hello){

        System.out.println("全量匹配,:"+JSON.toJSONString(hello));
    }

    @RabbitListener(queues = "topic.Queue1")
    @RabbitHandler
    public void topicQueue1(Hello hello){

        System.out.println("后面只允许与一个单词,:"+JSON.toJSONString(hello));
    }
}
