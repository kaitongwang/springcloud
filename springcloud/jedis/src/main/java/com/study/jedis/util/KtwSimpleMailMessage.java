package com.study.jedis.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

public class KtwSimpleMailMessage extends SimpleMailMessage {


    public KtwSimpleMailMessage() {

        this.setFrom("1825793811@qq.com");
    }
}