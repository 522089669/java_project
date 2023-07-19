package com.iweb.controller;

import com.iweb.client.Client;
import com.iweb.server.Server;
import com.iweb.view.LoginView;
import com.iweb.view.RegisterView;

import java.io.IOException;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 9:21
 */
public class UserController {
    public static void userController(int key) throws IOException {
        switch (key) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                new Server().start();
                new Client().start();
                break;
            default:
                System.out.println("输入的指令不对，请重新输入！");

        }
    }
}