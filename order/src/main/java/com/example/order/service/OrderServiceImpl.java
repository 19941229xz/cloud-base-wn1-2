package com.example.order.service;

import com.example.commonresource.entity.Order;
import com.example.order.dao.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo<Order> getByPage() {




        PageHelper.startPage(1, 10);

        PageHelper.orderBy("createDate desc");



        List<Order> orderList= orderMapper.getAll();


        return new PageInfo<>(orderList);
    }
}
