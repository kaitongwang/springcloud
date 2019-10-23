package com.study.location.mapper.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @ClassName : TencentAreaVo
 * @description : 集成通用mapper跟sqlmapper
 *
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>{

}