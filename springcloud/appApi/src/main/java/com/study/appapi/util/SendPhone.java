package com.study.appapi.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.rmi.ServerException;

/**
 * @ClassName : SendPhone
 * @description :
 * @Author : wangkaitong
 * @Date : 2020/1/3
 * @Version : 1.0
 * @Since : 1.0
 * @Copyright : 四川去哪游科技有限公司
 */
public class SendPhone {

    public static Boolean sendRegistereCode(String  phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIOhuGwfpXp9J2", "Fib7e89aT3a88O4sr241gPhhr7q3MG");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "兰尚家政平台");
        request.putQueryParameter("TemplateCode", "SMS_166655398");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (com.aliyuncs.exceptions.ServerException e) {
            e.printStackTrace();
            return  false;
        } catch (ClientException e) {
            e.printStackTrace();
            return  false;
        }

    }
    public static Boolean sendLoginCode(String  phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIOhuGwfpXp9J2", "Fib7e89aT3a88O4sr241gPhhr7q3MG");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "兰尚家政平台");
        request.putQueryParameter("TemplateCode", "SMS_166655370");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (com.aliyuncs.exceptions.ServerException e) {
            e.printStackTrace();
            return  false;
        } catch (ClientException e) {
            e.printStackTrace();
            return  false;
        }

    }
}
