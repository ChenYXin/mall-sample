package com.imooc.mall.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QRCodeGeneratorTest {

    @Test
    void generateQRCodeImage() {
        QRCodeGenerator.generateQRCodeImage("Hello Word",350,350,"/Users/chenyuexin/Desktop/java/project/spring/project/mall/src/main/resources/static/qrText.png");
    }
}