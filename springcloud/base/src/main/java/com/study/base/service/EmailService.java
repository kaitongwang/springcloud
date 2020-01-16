package com.study.base.service;

import com.study.base.domain.dto.entity.Email;
import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;

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

    Result add(Email email);


    Result getList(EmailListReqVo emailListReqVo);
}
