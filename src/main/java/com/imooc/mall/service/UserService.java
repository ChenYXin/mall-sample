package com.imooc.mall.service;

import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.model.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User getUser();

    void register(String userName,String password,String emailAddress) throws ImoocMallException;

    User login(String userName, String password) throws ImoocMallException;

    void updateInformation(User user) throws ImoocMallException;

    boolean checkAdminRole(User user);

    boolean checkEmailRegister(String emailAddress);
}
