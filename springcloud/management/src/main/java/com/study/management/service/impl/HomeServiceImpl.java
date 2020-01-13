package com.study.management.service.impl;

import com.study.common.base.Result;
import com.study.management.feign.HomeFeignService;
import com.study.management.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : HomeServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/13
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
     private   HomeFeignService homeFeignService;
    /**
     * 获取登录页面的背景图片
     * @return
     */
    @Override
    public Result getLoginPicture() {
        return homeFeignService.getHomePicture();
    }
}
