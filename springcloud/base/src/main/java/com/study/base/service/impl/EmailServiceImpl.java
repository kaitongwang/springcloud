package com.study.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.study.base.domain.dto.entity.Email;
import com.study.base.mapper.EmailMapper;
import com.study.base.service.EmailService;
import com.study.common.base.BasePage;
import com.study.common.base.PageUtil;
import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private EmailMapper emailMapper;

    @Override
    public Result add(Email email) {
        log.info("添加要发送的邮箱：{}", JSON.toJSONString(email));
        email.setStatus((byte) 1);
        emailMapper.insert(email);
        return Result.returnSuccess();
    }

    @Override
    public Result getList(EmailListReqVo emailListReqVo) {
        log.info("查看发送邮件的的实体：{}", JSON.toJSONString(emailListReqVo));

        PageHelper.startPage(emailListReqVo.getPage(), emailListReqVo.getLimit());
        List<Email> list = emailMapper.getList();
        BasePage pageList = PageUtil.getPageList(emailListReqVo.getPage(), list);

        return Result.returnSuccess(pageList);
    }
}
