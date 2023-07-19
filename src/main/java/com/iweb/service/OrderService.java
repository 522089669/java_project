package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 10:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderService {
    //订单id
    private int order_id;
    //绑定用户user_id
    private  int user_id;
    //绑定地址address_id
    private int address_id;
    //订单创建时间
    Date order_date;
    private String order_status;

}
