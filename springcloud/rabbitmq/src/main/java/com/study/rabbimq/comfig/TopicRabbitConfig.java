package com.study.rabbimq.comfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName : TopicRabbitConfig
 * @description : 主题模式订单
 * @Author : wangkaitong
 * @Date : 2019/12/13
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Configuration
public class TopicRabbitConfig {


    /**
     * 主题模式消息队列1
     * @return
     */
    @Bean
    public Queue topicQueue1(){
    return  new Queue("topic.Queue1",true);
    }

    /**
     * 主题模式消息队列2
     * @return
     */
    @Bean
    public Queue topicQueue2(){
        return  new Queue("topic.Queue2",true);
    }

    /**
     * 主题模式的交换机
     * @return
     */
    @Bean
    public TopicExchange createTopicExchange(){
        return new TopicExchange("TopicExchange");

    }


    /**
     * 设置交换机与队列的路由匹配。*表示"."只能有一个词组。不能有后续的逗号
     * @return
     */
    @Bean
    public Binding bingTopicExchange1(){

        return BindingBuilder.bind(topicQueue1()).to(createTopicExchange()).with("topic.*");
    }


    /**
     * 设置交换机与队列的路由匹配。#表示"."后面不管有多少词组都会转发到此队列
     * @return
     */
    @Bean
    public Binding bingTopicExchange2(){

        return BindingBuilder.bind(topicQueue2()).to(createTopicExchange()).with("topic.#");
    }


}
