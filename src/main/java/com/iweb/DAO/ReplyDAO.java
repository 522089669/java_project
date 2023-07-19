package com.iweb.DAO;

import com.iweb.pojo.Reply;

import java.util.List;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 17:13
 */
public interface ReplyDAO {
    List<Reply> list(String message);
}
