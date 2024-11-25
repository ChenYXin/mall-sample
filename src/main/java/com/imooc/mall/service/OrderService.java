package com.imooc.mall.service;


import com.imooc.mall.model.request.CreateOrderReq;
import com.imooc.mall.model.vo.OrderVO;

public interface OrderService {
    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    void cancel(String orderNo);

    String qrcode(String orderNo);
}
