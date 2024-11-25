package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.filter.UserFilter;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CarController {
    @Autowired
    CartService cartService;

    @ApiOperation("购物车列表")
    @PostMapping("/list")
    public ApiRestResponse list() {
        //内部获取用户ID,防止横向越权
        List<CartVO> cartVOList = cartService.list(UserFilter.currentUser.getId());
        return ApiRestResponse.success(cartVOList);
    }

    @ApiOperation("添加商品到购物车")
    @PostMapping("/add")
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count) {
        List<CartVO> cartVOList = cartService.add(UserFilter.currentUser.getId(), productId, count);
        return ApiRestResponse.success(cartVOList);
    }
}
