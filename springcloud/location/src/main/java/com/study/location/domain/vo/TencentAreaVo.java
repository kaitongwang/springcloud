package com.study.location.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName : TencentAreaVo
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Data
public class TencentAreaVo {

    private String id;

    private  String name;

    private String fullname;

    private List<String> pinyin;

    private TencentAreaLocation location;

    private List<Integer> cidx;

}
