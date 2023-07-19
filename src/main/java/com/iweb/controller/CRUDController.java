package com.iweb.controller;

import com.iweb.service.ProductService;
import com.iweb.service.PropertyService;
import com.iweb.util.Print;
import com.iweb.view.CRUDView;

import java.util.Scanner;


/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 9:46
 */
public class CRUDController {
    static Scanner sc = new Scanner(System.in);

    public static void Controller(int key) {
        switch (key) {
            case 1:
                Print.print("请选择你的操作：1、增加 2、删除 3、更新 4、查询");
                switch (sc.nextInt()) {
                    case 1:
                        Print.print("即将跳转增加页面");
                        CRUDView.ProductInsert();
                        break;
                    case 2:
                        Print.print("即将跳转删除页面");
                        CRUDView.ProductDelete();
                        break;
                    case 3:
                        Print.print("即将跳转更新页面");
                        CRUDView.ProductUpdate();
                        break;
                    case 4:
                        Print.print("即将跳转查询页面");
                        CRUDView.ProductCheck();
                        break;
                }
                break;
            case 2:
                Print.print("请选择你的操作：1、增加 2、删除 3、更新 4、查询");
                switch (sc.nextInt()) {
                    case 1:
                        Print.print("即将跳转增加页面");
                        CRUDView.PropertyInsert();
                        break;
                    case 2:
                        Print.print("即将跳转删除页面");
                        CRUDView.PropertyDelete();
                        break;
                    case 3:
                        Print.print("即将跳转更新页面");
                        CRUDView.PropertyUpdate();
                        break;
                    case 4:
                        Print.print("即将跳转查询页面");
                        CRUDView.PropertyCheck();
                        break;
                    default:
                        System.out.println("输入的指令不对，请重新输入！");
                }
                break;
            case 3:
                Print.print("请选择你的操作：1、增加 2、删除 3、更新 4、查询");
                switch (sc.nextInt()) {
                    case 1:
                        Print.print("即将跳转增加页面");
                        CRUDView.PropertyValueInsert();
                        break;
                    case 2:
                        Print.print("即将跳转删除页面");
                        CRUDView.PropertyValueDelete();
                        break;
                    case 3:
                        Print.print("即将跳转更新页面");
                        CRUDView.PropertyValueUpdate();
                        break;
                    case 4:
                        Print.print("即将跳转查询页面");
                        CRUDView.PropertyValueCheck();
                        break;
                    default:
                        System.out.println("输入的指令不对，请重新输入！");
                }
                break;
            case 4:
                Print.print("即将跳转查询页面");
                CRUDView.OrderCheck();
                break;
            case 5:
                Print.print("即将跳转查询页面");
                CRUDView.OrderDetailCheck();
                break;
            case 6:
                //发货
                break;
            case 7:
                //退货
                break;
            default:
                System.out.println("输入的指令不对，请重新输入！");
        }
    }

}
