package com.study.base.service.impl;

import com.study.base.domain.dto.HomePicture;
import com.study.base.mapper.HomePictureMapper;
import com.study.base.service.HomeService;
import com.study.common.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private HomePictureMapper homePictureMapper;


    @Override
    public Result getHomePicture() {
        List<HomePicture> homePictures = homePictureMapper.selectAll();
        return Result.returnSuccess(homePictures);
    }
}
