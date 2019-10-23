package com.study.location.service;

import com.study.common.result.Result;

/**
 * @ClassName : AreaService
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface AreaService {


    Result getProvince(String parentCode);
}
