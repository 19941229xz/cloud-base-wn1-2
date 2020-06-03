package com.example.commonresource.entity;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyParam<T> {


    private MyPage pageParam;  //分页参数


    private String[] orderParam; // 排序参数



    private T t;  //对象参数



}
