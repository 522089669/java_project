package com.iweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValueService {
    private int id;
    //商品属性id
    private int pid;
    //商品id
    private int ptid;
    private String value;

}
