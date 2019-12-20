package com.study.jedis.service;


import com.study.common.base.Result;

/**
 * @ClassName : SendEmailService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/20
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface SendEmailService {

     Result sendEmail();


     Result  addEmail(String userName);
}
