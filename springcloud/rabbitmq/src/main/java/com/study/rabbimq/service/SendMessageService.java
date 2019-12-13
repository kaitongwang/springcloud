package com.study.rabbimq.service;

import com.study.common.base.Result;
import com.study.common.rabbitmq.Hello;

/**
 * @ClassName : SendMessageImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/12
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface SendMessageService {



    Result send(Hello hello);



    Result send1(Hello hello);



    Result send2(Hello hello);



    Result send3(Hello hello);

}
