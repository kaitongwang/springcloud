package com.study.rabbimq.comfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName : DirectRabbitConfig
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Configuration
public class DirectRabbitConfig {


    /**
     * 队列名称
     * @return
     */
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("TestDirectQueue",true);
    }

    @Bean
    public  Queue Hello(){
        return  new Queue("Hello",true);
    }
    /**
     * 交换机名称
     * @return
     */
    @Bean
    public  DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange");
    }

    /**
     * 队列绑定交换机
     * @return
     */
    @Bean
    public   Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    public Binding bindingHello(){
        return BindingBuilder.bind(Hello()).to(TestDirectExchange()).with("Hello");
    }






}
