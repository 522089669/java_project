package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cjl
 * @Description: 订单详情
 * @Date 2023/7/18 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailService {
    //订单详情id
    private int detail_id;
    //绑定订单oid
    private int oid;
    //绑定商品
    private int pid;
    //商品数量
    private int quantity;
}
