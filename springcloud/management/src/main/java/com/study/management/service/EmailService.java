package com.study.management.service;

import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;
import com.study.common.vo.base.EmailVo;

/**
 * @ClassName : EmailService
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface EmailService {

    Result add(EmailVo emailVo);


    Result getList(EmailListReqVo emailListReqVo);
}
