package com.iweb.controller;

import com.iweb.client.Client;
import com.iweb.server.Server;
import com.iweb.view.LoginView;
import com.iweb.view.RegisterView;

import java.io.IOException;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/17 17:57
 */
public class MainController {
    public static void mainController(int key) throws IOException {
        switch (key) {
            case 1:
                LoginView.login();
                break;
            case 2:
                RegisterView.register();
            case 3:
                new Server().start();
                new Client().start();

                break;
            default:
                System.out.println("输入的指令不对，请重新输入！");

        }
    }
}
