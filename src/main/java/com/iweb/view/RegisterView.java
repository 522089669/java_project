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
 * @Date 2023/7/17 16:29
 */
public class RegisterView {
    public static Scanner sc = new Scanner(System.in);

    public static void register() {
        Print.print("请输入您的登录名：");
        String registerName = sc.nextLine();
        Print.print("请输入您的密码：");
        String registerPassword = sc.nextLine();
        Print.print("请输入你的手机号码：");
        String phone = sc.nextLine();
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("select username from user where username=?");) {
            ps.setString(1, registerName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("账号已存在，重新输入！");
                register();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (registerName == null || registerPassword == null || phone == null) {
            System.out.println("输入有误,请宠幸输入");
            register();
            return;
        }
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement("insert into user(username,password,phone) values(?,?,?)");) {
            ps.setString(1, registerName);
            ps.setString(2, registerPassword);
            ps.setString(3, phone);
            ps.execute();
            System.out.println("注册成功，即将跳转到登录页面。。");
            LoginView.login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
