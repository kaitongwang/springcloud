package com.study.common.vo.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassName : User
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Builder
@Data
@ApiModel("用户交易实体")
public class User {


    @ApiModelProperty("用户编码")
    private int id;


    @ApiModelProperty("用户名")
    private String username;
}
