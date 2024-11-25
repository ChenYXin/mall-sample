package com.imooc.mall.service;


import com.imooc.mall.model.request.CreateOrderReq;

public interface OrderService {
    String create(CreateOrderReq createOrderReq);
}
