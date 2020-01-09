package com.study.base.web;

import com.study.common.base.Result;
import com.study.common.vo.base.LoginReqVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 * @ClassName : LoginController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/9
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */

@RestController
@RequestMapping("/login")
public class LoginController {


    @PostMapping("/login")
    public Result login(@RequestBody LoginReqVo LoginReqVo){


    }

}
