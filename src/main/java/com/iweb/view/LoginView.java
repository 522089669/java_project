package com.iweb.view;

import com.iweb.util.JDBCUtil;
import com.iweb.util.Print;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/17 16:28
 */
public class LoginView {

    public static Scanner sc = new Scanner(System.in);

    public static void login() {
        Print.print("请输入您的登录名：");
        String loginName = sc.nextLine();
        Print.print("请输入您的密码：");
        String loginPassword = sc.nextLine();
        Print.print("请输入您的权限：");
        String loginAuthority =sc.nextLine();
        if (loginName == null || loginPassword == null) {
            return;
        }
        String sql = "select * from user where username =? and password =?and authority=?";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, loginName);
            ps.setString(2, loginPassword);
            ps.setString(3,loginAuthority);
            ResultSet rs = ps.executeQuery();
           if (rs.next()){
               System.out.println("登录成功");
               System.out.println("即将跳转到商城页面。。。");
           }else {
               System.out.println("登录失败，请检查用户名和密码和权限后，重新登录");
               login();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
