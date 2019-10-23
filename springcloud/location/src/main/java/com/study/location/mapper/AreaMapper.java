package com.study.location.mapper;

import com.study.location.domain.po.AreaPo;
import com.study.location.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName : AreaVoMapper
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Repository
@Mapper
public interface AreaMapper extends BaseMapper<AreaPo> {


}
