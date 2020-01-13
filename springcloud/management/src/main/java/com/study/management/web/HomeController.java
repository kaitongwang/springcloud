package com.study.management.web;

import com.study.common.base.Result;
import com.study.management.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : HomeController
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/13
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@RestController
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private HomeService homeService;

    /**
     * 获取登录页面的背景图片
     * @return
     */
    @GetMapping("get")
    public Result getLoginPicture(){
        return homeService.getLoginPicture();
    }
}
