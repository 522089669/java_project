package com.iweb.view;

import com.iweb.controller.MainController;
import com.iweb.controller.UserController;
import com.iweb.util.Print;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 9:14
 */
public class UserView {
    public static Scanner sc = new Scanner(System.in);
    public static void user() throws IOException {
        Print.print(" 欢迎进入用户界面 ");
        Print.print("  1.商品选购  ");
        Print.print("  2.购物车查看 ");
        Print.print("  3.购物车结算");
        Print.print("  3.订单查看");
        Print.print("  4.收货地址");
        Print.print("  5.账号充值");
        Print.print("  6.联系客服");
        Print.print("请输入操作指令:");
        int key = sc.nextInt();
        UserController.userController(key);
    }
}
