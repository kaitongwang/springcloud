package com.study.management.web;

import com.study.common.base.Result;
import com.study.common.vo.base.EmailListReqVo;
import com.study.common.vo.base.EmailVo;
import com.study.management.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
@RequestMapping("/wkt/email")
public class EmailController {


    @Autowired
    private EmailService emailService;


    @PostMapping("/add")
    public Result add(@RequestBody @Valid EmailVo emailVo) {
        return emailService.add(emailVo);
    }


    @PostMapping("/getList")
    public Result getList(@RequestBody @Valid EmailListReqVo emailListReqVo) {
        return emailService.getList(emailListReqVo);
    }

}
