package com.imooc.mall.service.impl;

import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.model.dao.CartMapper;
import com.imooc.mall.model.dao.ProductMapper;
import com.imooc.mall.model.pojo.Cart;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.vo.CartVO;
import com.imooc.mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<CartVO> add(Integer userId, Integer productId, Integer count) {
        validProduct(productId, count);

        Cart cart = cartMapper.selectByUserIdAndProductId(userId, productId);
        if (cart == null) {
            //这个商品之前不在购物车里，需要新增一个记录
            cart=new Cart();
            cart.setProductId(productId);
            cart.setUserId(userId);
            cart.setQuantity(count);
            cart.setSelected(Constant.Cart.CHECKED);
            cartMapper.insertSelective(cart);
        }else{
            //这个商品已经在购物车里了，则数量相加
            count=cart.getQuantity()+count;
            Cart cartnew=new Cart();
            cartnew.setQuantity(count);
            cartnew.setId(cart.getId());
            cartnew.setProductId(cart.getProductId());
            cartnew.setUserId(cart.getUserId());
            cartnew.setSelected(Constant.Cart.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartnew);
        }
        return null;
    }

    private void validProduct(Integer productId, Integer count) {
        Product product = productMapper.selectByPrimaryKey(productId);
        //判断商品是否存在，商品是否上架
        if (product == null || product.getStatus().equals(Constant.SaleStatus.NOT_SALE)) {
            throw new ImoocMallException(ImoocMallExceptionEnum.NO_SALE);
        }
        //判断商品库存
        if (count>product.getStock()){
            throw new ImoocMallException(ImoocMallExceptionEnum.NO_ENOUGH);
        }
    }
}
