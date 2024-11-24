package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.model.request.AddCategoryReq;
import com.imooc.mall.model.vo.CategoryVO;
import com.imooc.mall.service.CategoryService;
import com.imooc.mall.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping("/admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(@Valid @RequestBody AddCategoryReq addCategoryReq) {
        //是管理员，执行新增操作
        categoryService.add(addCategoryReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台删除目录")
    @PostMapping("/admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @PostMapping("/admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @PostMapping("/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> list = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(list);
    }
}
