package com.study.location.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName : TencentResult
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class TencentResult {

    private Integer status;

    private String message;

    private String data_version;

    private List<List<TencentAreaVo>> result;
}
