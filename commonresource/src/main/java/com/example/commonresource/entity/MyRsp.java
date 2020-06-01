package com.example.commonresource.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRsp {



    private int code; // success 20000


    private String msg;


    private Object content;








    public static MyRsp success(Object content){

        MyRsp rsp =  new MyRsp();

        rsp.setMsg("请求成功");
        rsp.setCode(20000);

        rsp.setContent(content);

        return rsp;

    }



    public MyRsp msg(String msg){


        this.setMsg(msg);

        return this;
    }


    public static MyRsp fail(){


        MyRsp rsp = new MyRsp();

        rsp.setMsg("访问失败");

        rsp.setCode(50000);

        rsp.setContent(null);

        return rsp;

    }

}
