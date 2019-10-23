package com.study.location.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : TencentAreaLocation
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class TencentAreaLocation {

    /**
     * 维度
     */
    private BigDecimal lat;

    /**
     * 精度
     */
    private BigDecimal lng;
}
