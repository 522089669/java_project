package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 10:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductService {
    //商品id
    private int id;
    //商品名称
    private String name;
    //商品原始价格
    private double origibakprice;
    //绑定商品分类的id
    private int cid;
    //剩余库存
    private int stock;
    //创建日期
    Date creatDate;
    //商品促销价格
    private double promoteprice;
    //商品评价
    private String subtitle;

}
