package com.imooc.mall.util;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MD5UtilsTest {

    @Test
    void getMD5Str() {
        try {
            String md5 = MD5Utils.getMD5Str("1234");
            System.out.println(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}