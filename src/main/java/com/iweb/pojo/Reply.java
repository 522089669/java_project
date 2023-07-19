package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 17:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private int id;
    private String message;
    private String response;
}
