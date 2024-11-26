package com.imooc.mall.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailUtil {
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}