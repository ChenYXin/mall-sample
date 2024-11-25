package com.imooc.mall.service;

import com.imooc.mall.model.vo.CartVO;

import java.util.List;

public interface CartService {
    List<CartVO> list(Integer userId);

    List<CartVO> add(Integer userId, Integer productId, Integer count);
}
