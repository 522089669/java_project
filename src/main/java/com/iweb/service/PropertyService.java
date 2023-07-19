package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cjl
 * @Description:  商品属性表
 * @Date 2023/7/18 10:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyService {
    //商品属性id
    private int id;

    //商品分类的cid
    private int cid;

    //商品名称
    private String name;


}
