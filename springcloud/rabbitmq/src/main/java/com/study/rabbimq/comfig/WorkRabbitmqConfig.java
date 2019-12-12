package com.study.rabbimq.comfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : WorkRabbitmqConfig
 * @description work 工作模式
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Configuration
public class WorkRabbitmqConfig {

    @Bean
    public Queue workQueue() {
        return new Queue("work-queue",true);
    }


}
