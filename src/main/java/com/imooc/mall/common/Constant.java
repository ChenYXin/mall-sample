package com.imooc.mall.common;

import org.springframework.beans.factory.annotation.Value;

/**
 * 常量值
 */
public class Constant {
    //盐值
    public static final String SALT = "s0jx090a92IS]a.,qWc";

    public static final String IMOOC_MALL_USER = "imooc_mall_user";

    @Value("${file.upload.dir}")
    public static String FILE_UPLOAD_DIR;
}
