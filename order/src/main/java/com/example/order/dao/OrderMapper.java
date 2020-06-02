package com.example.order.dao;


import com.example.commonresource.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {




    @Select("select * from order_head")
    public List<Order> getAll();


}
