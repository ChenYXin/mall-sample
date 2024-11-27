package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.model.vo.OrderStatisticsVO;
import com.imooc.mall.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/admin/order")
public class OrderAdminController {

    @Autowired
    OrderService orderService;

    @ApiOperation("管理员订单列表")
    @GetMapping("/list")
    public ApiRestResponse listForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = orderService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("管理员发货")
    @PostMapping("/delivered")
    public ApiRestResponse delivered(@RequestParam String orderNo) {
        orderService.deliver(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("管理员完结订单")
    @PostMapping("/finish")
    public ApiRestResponse finish(@RequestParam String orderNo) {
        orderService.finish(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("管理员完结订单")
    @PostMapping("/statistics")
    public ApiRestResponse statistics(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date startDate,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate) {
        List<OrderStatisticsVO> orderStatisticsVOList=orderService.statistics(startDate,endDate);
        return ApiRestResponse.success(orderStatisticsVOList);
    }
}
