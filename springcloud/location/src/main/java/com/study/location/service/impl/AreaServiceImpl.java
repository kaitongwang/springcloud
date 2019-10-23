package com.study.location.service.impl;

import com.alibaba.fastjson.JSON;
import com.study.common.result.Result;
import com.study.common.result.ResultStatus;
import com.study.location.domain.config.ConfigValue;
import com.study.location.domain.po.AreaPo;
import com.study.location.domain.po.AreaVoPo;
import com.study.location.domain.vo.TencentAreaVo;
import com.study.location.domain.vo.TencentResult;
import com.study.location.mapper.AreaMapper;
import com.study.location.mapper.AreaVoMapper;
import com.study.location.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : AreaServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/10/23
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private ConfigValue configValue;
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private AreaMapper areaMapper;


    @Autowired
    private AreaVoMapper areaVoMapper;

    @Override
    public Result getProvince(String parentCode) {


//
//            StringBuffer stringBuffer = new StringBuffer(configValue.tencent_getChildren_url);
//
//            stringBuffer.append("?key=" + configValue.tencent_key);
//            System.out.println("请求地址为："+stringBuffer);
//            TencentResult forObject = restTemplate.getForObject(stringBuffer.toString(), TencentResult.class);
//
//            log.info("返回信息为：{}", JSON.toJSONString(forObject));
//
//
//
//
//            if (forObject.getStatus() == 0) {
//
//
//                log.info(" 返回省市区为：{}", forObject.getResult());
//
//                List<List<TencentAreaVo>> lists = forObject.getResult();
//                List<TencentAreaVo> tencentAreaVos = lists.get(0);
////                List<TencentAreaVo> tencentAreaVos1 = lists.get(1);
////                List<TencentAreaVo> tencentAreaVos2 = lists.get(2);
////                tencentAreaVos.addAll(tencentAreaVos1);
////                tencentAreaVos.addAll(tencentAreaVos2);
//                List<AreaVoPo> areaPos = new ArrayList<>();
//                for (TencentAreaVo tencentAreaVo : tencentAreaVos) {
//                    AreaVoPo areaPo = new AreaVoPo();
//                    areaPo.setCode(tencentAreaVo.getId());
//                    areaPo.setName(tencentAreaVo.getName());
//                    areaPo.setFullName(tencentAreaVo.getFullname());
//                    if (!CollectionUtils.isEmpty(tencentAreaVo.getPinyin())) {
//                        String pinyin = String.join(" ", tencentAreaVo.getPinyin());
//                        areaPo.setPinyin(pinyin);
//                    }
//
//                    areaPo.setLat(tencentAreaVo.getLocation().getLat());
//                    areaPo.setLng(tencentAreaVo.getLocation().getLng());
//                    areaPo.setParentCode("1");
//                    areaPos.add(areaPo);
//
//                }
//
//                areaVoMapper.insertList(areaPos);
//
//  return Result.returnSuccess(tencentAreaVos);
//            }





        List<AreaPo> areaPos1 = areaMapper.selectAll();

        for (AreaPo areaPo1 : areaPos1) {
            StringBuffer stringBuffer = new StringBuffer(configValue.tencent_getChildren_url);

            stringBuffer.append("?key=" + configValue.tencent_key+"&id="+areaPo1.getCode());
            System.out.println("请求地址为："+stringBuffer);
            TencentResult forObject = restTemplate.getForObject(stringBuffer.toString(), TencentResult.class);

            log.info("返回信息为：{}", JSON.toJSONString(forObject));


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (forObject.getStatus() == 0) {


                log.info(" 返回省市区为：{}", forObject.getResult());

                List<List<TencentAreaVo>> lists = forObject.getResult();
                List<TencentAreaVo> tencentAreaVos = lists.get(0);
                List<AreaVoPo> areaPos = new ArrayList<>();
                for (TencentAreaVo tencentAreaVo : tencentAreaVos) {
                    AreaVoPo areaPo = new AreaVoPo();
                    areaPo.setCode(tencentAreaVo.getId());
                    areaPo.setName(tencentAreaVo.getName());
                    areaPo.setFullName(tencentAreaVo.getFullname());
                    if (!CollectionUtils.isEmpty(tencentAreaVo.getPinyin())) {
                        String pinyin = String.join(" ", tencentAreaVo.getPinyin());
                        areaPo.setPinyin(pinyin);
                    }

                    areaPo.setLat(tencentAreaVo.getLocation().getLat());
                    areaPo.setLng(tencentAreaVo.getLocation().getLng());
                    areaPo.setParentCode(areaPo1.getCode());
                    areaPos.add(areaPo);

                }

                areaVoMapper.insertList(areaPos);
                log.info("返回实体为：{}", JSON.toJSONString(forObject));

            }else {
                log.error("当前地址无子级：{}",JSON.toJSONString(areaPos1));
            }
        }

     return Result.resultFail(ResultStatus.SYSTEM_OUTAGE);
    }
//
//
//        String s = HttpsUtil.httpsGet(stringBuffer.toString());
//
//        log.info(s);
//        Object parse = JSON.parse(s);
//        System.out.println(parse);
//
//        TencentResult<List<TencentAreaVo>> tencentResult = JSON.parseObject(s, new TypeReference<TencentResult<List<TencentAreaVo>>>() {
//        });


//        if (tencentResult.getStatus() == 0) {
//
//
//            log.info(" 返回省市区为：{}", tencentResult.getResult());
//
//            List<List<TencentAreaVo>> lists = tencentResult.getResult();
//            List<TencentAreaVo> tencentAreaVos = lists.get(0);
//            List<AreaVoPo> areaPos = new ArrayList<>();
//            for (TencentAreaVo tencentAreaVo : tencentAreaVos) {
//                AreaVoPo areaPo = new AreaVoPo();
//                areaPo.setCode(tencentAreaVo.getId());
//                areaPo.setName(tencentAreaVo.getName());
//                areaPo.setFullName(tencentAreaVo.getFullname());
//                String pinyin = String.join(" ", tencentAreaVo.getPinyin());
//                areaPo.setPinyin(pinyin);
//                areaPo.setLat(tencentAreaVo.getLocation().getLat());
//                areaPo.setLng(tencentAreaVo.getLocation().getLng());
//
//                areaPos.add(areaPo);
//
//            }
//
//            areaVoMapper.insertList(areaPos);
//        } else {
//            log.error("查询地理信息失败");
//        }
//
//
//        return Result.returnSuccess(configValue.tencent_getChildren_url);
//    }
}
