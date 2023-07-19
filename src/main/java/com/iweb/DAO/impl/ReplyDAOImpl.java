package com.iweb.DAO.impl;

import com.iweb.DAO.ReplyDAO;
import com.iweb.pojo.Reply;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 17:22
 */
public class ReplyDAOImpl implements ReplyDAO {
    public List<Reply> list(String message) {
        List<Reply> replies = new ArrayList<>();
        String sql = "select * from reply where message like concat('%',?,'%')";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1,message);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Reply r = new Reply(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                replies.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replies.isEmpty()?null:replies;

    }
}
