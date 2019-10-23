package com.study.location.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ConfigValue
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Component
public class ConfigValue {
    /**
     * tencent:
     *      key: WKYBZ-UVBWK-2B4JZ-AAYRD-7AYOQ-C3BTU
     *      getList:
     *         url: https://apis.map.qq.com/ws/district/v1/list
     *      getChildren:
     *        url: https://apis.map.qq.com/ws/district/v1/getchildren
     */

    @Value("${tencent.key}")
    public String tencent_key;


    @Value("${tencent.getList.url}")
    public String tencent_getList_url;

    @Value("${tencent.getChildren.url}")
    public String tencent_getChildren_url;

}
