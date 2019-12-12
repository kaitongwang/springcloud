package com.study.rabbimq.comfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : FanoutExchangeConfig
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Configuration
public class FanoutExchangeConfig {

    /**
     * 队列名称
     * @return
     */
    @Bean
    public Queue Fanout1() {
        return new Queue("Fanout1",true);
    }

    @Bean
    public  Queue Fanout2(){
        return  new Queue("Fanout2",true);
    }
    /**
     * 交换机名称
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange");
    }

    /**
     * 队列绑定交换机
     * @return
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(Fanout1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(Fanout2()).to(fanoutExchange());
    }
}
