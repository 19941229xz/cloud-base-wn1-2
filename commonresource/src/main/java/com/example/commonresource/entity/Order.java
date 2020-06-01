package com.example.commonresource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 订单头信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {



    private String orderId;



    private String summary;


    private Date createDate;





}
