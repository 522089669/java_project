package com.iweb.service;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 8:45
 */
public class UserService {
    private int id;
    private String username;
    private int phone;
    private double money;
    //一个用户对应多个地址
    private AddressService address;
    //一个用户对应多个订单
    private OrderService order;
    //一个用户对应多个订单详情
    private OrderDetailService orderDetail;
}
