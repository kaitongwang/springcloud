package com.study.location.domain.po;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ClassName : AreaVoPo
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Entity
@Data
@Table(name = "area")
public class AreaPo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 简称
     */
    @Column(name = "name")
    private String name;

    /**
     * 全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 拼音
     */
    @Column(name = "pinyin")
    private String pinyin;

    /**
     * 维度
     */
    @Column(name = "lat")
    private BigDecimal lat;

    /**
     * 精度
     */
    @Column(name = "lng")
    private BigDecimal lng;


    /**
     * 父级编码
     */
    @Column(name = "parent_code")
    private String parentCode;

}
