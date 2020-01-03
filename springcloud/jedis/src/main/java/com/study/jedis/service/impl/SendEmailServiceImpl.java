package com.study.jedis.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.study.common.base.Result;
import com.study.common.base.ResultStatus;
import com.study.common.util.DateUtils;
import com.study.common.util.HttpUtils;
import com.study.jedis.domain.vo.ListWechatVo;
import com.study.jedis.domain.vo.ShowapiResBodyWechatVo;
import com.study.jedis.domain.vo.Test;
import com.study.jedis.service.SendEmailService;
import com.study.jedis.util.KtwSimpleMailMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : SendEmailServiceImpl
 * @description :
 * @Author : wangkaitong
 * @Date : 2019/12/20
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result sendEmail() {
        try {


            String key = DateUtils.date2Str(new Date(), DateUtils.yyyyMMdd);

            Test test = new Test();
            Object o = redisTemplate.opsForValue().get(key);
            if (Objects.isNull(o)) {
                String host = "https://ali-todayhistory.showapi.com";
                String path = "/today-of-history";
                String method = "GET";
                String appcode = "7933933630d94131beb6fb3c99375e47";
                Map<String, String> headers = new HashMap<String, String>();
                //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
                headers.put("Authorization", "APPCODE " + appcode);
                Map<String, String> querys = new HashMap<String, String>();
                HttpResponse httpResponse = HttpUtils.doGet(host, path, method, headers, querys);

                String s = EntityUtils.toString(httpResponse.getEntity());
                log.info("返回为：{}", s);

                test = JSONObject.parseObject(s, Test.class);
                redisTemplate.opsForValue().set(key, test, 1, TimeUnit.DAYS);

            } else {

                test = (Test) o;

            }

            ShowapiResBodyWechatVo showapi_res_body = test.getShowapi_res_body();
            List<ListWechatVo> list = showapi_res_body.getList();
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

            if (!CollectionUtils.isEmpty(list)) {


                // String 设置发送内容

                String text = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=\n" +
                        "    , initial-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>Document</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    \n" +
                        "\n" +
                        "    <h3>\n" +
                        "\n" +
                        "         温馨提示，历史上的今天发生了什么 ？\n" +
                        "    </h3>\n" +
                        "\n";
                int i = 1;
                for (ListWechatVo listWechatVo : list) {
                    text = text + "<h4>事件" + i + "</h4>";
                    text = text +
                            "<div><h5>时间：";
                    text = text + listWechatVo.getYear() + "年" + listWechatVo.getMonth() + "月" + listWechatVo.getDay() + "号</h5>";
                    text = text + " <h5>";
                    text = text + listWechatVo.getTitle() + "</h5>";
                    text = text + "<div style=\"width: 30%; height: 20%;\">\n" +
                            "        <img src=\"" + listWechatVo.getImg() + "\"  style=\"max-width:100%\">\n" +
                            "\n" +
                            "    </div>\n" +
                            "    \n" +
                            "</div>";
                    i++;
                }


                messageHelper.setSentDate(new Date());
                messageHelper.setSubject("新的一天，也要美美的。温馨提示历史上的昨天");
                messageHelper.setFrom("1825793811@qq.com");

                messageHelper.setText(text, true);
                Object email = redisTemplate.opsForValue().get("email");
                List<String> strings = (List<String>) email;
                for (String listWechatVo : strings) {
                    messageHelper.setTo(listWechatVo);
                    javaMailSender.send(mimeMessage);

                }


                return Result.returnSuccess(text);

            } else {
                return Result.resultFail(ResultStatus.SUCCESS);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.resultFail(ResultStatus.SUCCESS);
    }


    @Override
    public Result addEmail(String userName) {
        Object email = redisTemplate.opsForValue().get("email");
        List<String> strings = (List<String>) email;
        if (!CollectionUtils.isEmpty(strings)) {
            if (strings.contains(userName)) {
                return Result.returnSuccess();
            } else {
                strings.add(userName);
                redisTemplate.opsForValue().set("email", strings);
                return Result.returnSuccess();
            }
        }else {
            strings = new ArrayList<>();
            strings.add(userName);
            redisTemplate.opsForValue().set("email", strings);
            return Result.returnSuccess();
        }

    }
}
