package com.iweb.view;

import com.iweb.DAO.AdminDAO;
import com.iweb.DAO.impl.AdminDAOImpl;
import com.iweb.service.OrderService;
import com.iweb.service.ProductService;
import com.iweb.service.PropertyService;
import com.iweb.service.PropertyValueService;
import com.iweb.util.Print;

import java.util.Date;
import java.util.Scanner;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/19 10:08
 */
public class CRUDView {

    static AdminDAO adminDAO = new AdminDAOImpl();

    static Scanner sc= new Scanner(System.in);
    public static void ProductInsert() {
        Print.print("请输入相关参数：");
        ProductService p = new ProductService(sc.nextInt(),sc.nextLine(),sc.nextDouble(),
                sc.nextInt(),sc.nextInt(),(new Date(System.currentTimeMillis())),sc.nextDouble(),sc.nextLine());

        adminDAO.productInsert(p);
    }

    public static void ProductDelete() {
        Print.print("请输入你要删除的id");
        int id = sc.nextInt();
        ProductService p = new ProductService();
        p.setId(id);
        adminDAO.productDelete(p);
    }

    public static void ProductUpdate() {
        Print.print("输入你的参数");
        ProductService p = new ProductService(sc.nextInt(),sc.nextLine(),sc.nextDouble(),
                sc.nextInt(),sc.nextInt(),(new Date(System.currentTimeMillis())),sc.nextDouble(),sc.nextLine());
        adminDAO.productUpdate(p);
    }

    public static void ProductCheck() {
        adminDAO.productCheck();
    }

    //商品属性
    public static void PropertyInsert() {
        Print.print("输入你的参数");
        PropertyService p = new PropertyService(sc.nextInt(),sc.nextInt(),sc.nextLine());
        adminDAO.propertyInsert(p);
    }

    public static void PropertyDelete() {
        Print.print("输入你的参数");
        PropertyService p = new PropertyService();
        p.setId(sc.nextInt());
        adminDAO.propertyDelete(p);
    }

    public static void PropertyUpdate() {
        Print.print("输入你的参数");
        PropertyService p = new PropertyService(sc.nextInt(),sc.nextInt(),sc.nextLine());
        adminDAO.propertyUpdate(p);
    }

    public static void PropertyCheck() {
        adminDAO.propertyCheck();
    }

    //商品属性值
    public static void PropertyValueInsert() {
        PropertyValueService p = new PropertyValueService(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextLine());
        adminDAO.propertyValueInsert(p);
    }

    public static void PropertyValueDelete() {
        PropertyValueService p = new PropertyValueService();
        p.setId(sc.nextInt());
        adminDAO.propertyValueDelete(p);
    }

    public static void PropertyValueUpdate() {
        PropertyValueService p = new PropertyValueService(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextLine());
        adminDAO.propertyValueUpdate(p);
    }

    public static void PropertyValueCheck() {
        adminDAO.propertyValueCheck();
    }

    //订单查询
    public static void OrderCheck(){
        adminDAO.orderCheck();
    }
    //订单详情查询
    public static void OrderDetailCheck(){
        adminDAO.orderDetailCheck();
    }
    //订单发货
    public static void deliverDoods(){
        OrderService o = new OrderService();
        Print.print("请输入订单id");
        adminDAO.orderDeliveroodsUpdate(sc.nextInt());
    }
    //订单退货
    public static void returnGoods(){
        OrderService o = new OrderService();
        Print.print("请输入订单id");
        adminDAO.orderReturnGoodsUpdate(sc.nextInt());
    }
}
