package com.iweb.view;

import com.iweb.controller.MainController;
import com.iweb.util.Print;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/17 16:32
 */
public class MainView {

    //类加载的时候就创建 sc对应的Scanner对象
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Print.print(" 欢迎进入商城系统 ");
        Print.print("  1.用户登录  ");
        Print.print("  2.用户注册 ");
        Print.print("  3.人工客服");
        Print.print("请输入操作指令:");
        int key = sc.nextInt();
        MainController.mainController(key);
    }
}