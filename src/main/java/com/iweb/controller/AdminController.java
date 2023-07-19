package com.iweb.controller;

import com.iweb.view.LoginView;
import com.iweb.view.RegisterView;

import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 9:27
 */
public class AdminController {
    public static void adminController(int key) {
        switch (key) {
            case 1:
                CRUDController.Controller(key);
                break;
            case 2:
                CRUDController.Controller(key);
                break;
            case 3:
                CRUDController.Controller(key);
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                break;
            default:
                System.out.println("输入的指令不对，请重新输入！");

        }
    }
}
