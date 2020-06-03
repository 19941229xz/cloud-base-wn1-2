package com.example.commonresource.entity;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Digits;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {


    private int pageNum;

    private int pageSize;


}
