package com.boray.config;

import org.apache.http.impl.client.CloseableHttpClient;

import lombok.Data;


@Data
public class TestConfig {

    //登陆接口url
    public static String loginUrl;
    
    //更新用户信息接口url
    public static String updateUserInfoUrl;
    
    //获取所有用户列表接口url
    public static String getUserListUrl;
    
    //获取用户信息接口url
    public static String getUserInfoUrl;
    
    //添加用户接口url
    public static String addUserUrl;


    //用来存储token的变量
    public static String store;
    
    //声明http客户端
    public static CloseableHttpClient defaultHttpClient;

}
