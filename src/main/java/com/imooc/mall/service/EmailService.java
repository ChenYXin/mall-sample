package com.imooc.mall.service;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String content);
}
