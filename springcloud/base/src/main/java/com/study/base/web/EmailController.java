package com.study.base.web;

import com.study.base.domain.dto.entity.Email;
import com.study.base.domain.request.LeaderListReqVo;
import com.study.base.service.EmailService;
import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : EmailController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/16
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RestController
@RequestMapping("/email")
public class EmailController {


    @Autowired
    private EmailService emailService;


    @PostMapping("/add")
    public Result add(@RequestBody Email email){

       return emailService.add(email);
    }


    @PostMapping("/getList")
    public Result getList(@RequestBody EmailListReqVo emailListReqVo){

        return emailService.getList(emailListReqVo);

    }

}
