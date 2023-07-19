package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cjl
 * @Description: 商品分类表
 * @Date 2023/7/18 10:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryService {

    private int id;
    private String name;
}
