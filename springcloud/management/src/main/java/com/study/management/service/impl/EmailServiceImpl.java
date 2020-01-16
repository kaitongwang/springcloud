package com.study.management.service.impl;

import com.study.common.base.Result;
import com.study.common.vo.base.CurrentUser;
import com.study.common.vo.base.EmailListReqVo;
import com.study.common.vo.base.EmailVo;
import com.study.management.domain.vo.CurrentUserLocal;
import com.study.management.feign.EmailFeignService;
import com.study.management.service.EmailService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.MessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName : EmailServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailFeignService emailFeignService;

    @Override
    public Result add(EmailVo emailVo) {
        CurrentUser currentAuthToken = CurrentUserLocal.getCurrentAuthToken();
        emailVo.setCreateTime(new Date());
        emailVo.setCreateBy(currentAuthToken.getName());
        emailVo.setUpdateTime(new Date());
        emailVo.setUpdateBy(currentAuthToken.getName());
        return emailFeignService.add(emailVo);
    }

    @Override
    public Result getList(EmailListReqVo emailListReqVo) {
        return emailFeignService.getList(emailListReqVo);
    }
}
