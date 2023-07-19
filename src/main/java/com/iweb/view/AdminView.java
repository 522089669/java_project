package com.iweb.view;

import com.iweb.controller.AdminController;
import com.iweb.controller.UserController;
import com.iweb.util.Print;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 9:26
 */
public class AdminView {
    public static Scanner sc = new Scanner(System.in);
    public static void admin() throws IOException {
        Print.print(" 欢迎进入管理员界面 ");
        Print.print("  1.增删改查商品 ");
        Print.print("  2.增删改查商品属性 ");
        Print.print("  3.增删改查商品值");
        Print.print("  4.查看订单");
        Print.print("  5.查看订单详情");
        Print.print("  6.指定订单发货");
        Print.print("  7.订单退货");
        Print.print("请输入操作指令:");
        int key = sc.nextInt();
        AdminController.adminController(key);
    }
}
