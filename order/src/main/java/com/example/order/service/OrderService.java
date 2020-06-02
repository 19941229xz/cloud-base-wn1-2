package com.example.order.service;

import com.example.commonresource.entity.Order;
import com.github.pagehelper.PageInfo;

public interface OrderService {


    public PageInfo<Order> getByPage();


}
