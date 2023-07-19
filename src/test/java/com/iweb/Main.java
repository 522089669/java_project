package com.iweb;

import com.iweb.DAO.AdminDAO;
import com.iweb.DAO.impl.AdminDAOImpl;
import com.iweb.service.OrderDetailService;
import com.iweb.service.OrderService;
import com.iweb.service.PropertyValueService;
import org.junit.Test;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 17:44
 */
public class Main {

    @Test
    public void test() {
        //订单细节
        AdminDAO adminDAO = new AdminDAOImpl();
        OrderDetailService o = new OrderDetailService();
        System.out.println(adminDAO.categoryCheck());

    }

    @Test
    public void test1() {
        //订单
        AdminDAO adminDAO = new AdminDAOImpl();
        OrderService o1 = new OrderService();
        System.out.println(adminDAO.orderCheck());
    }

    @Test
    public void test2() {
        //属性值
        AdminDAO adminDAO = new AdminDAOImpl();
        PropertyValueService p = new PropertyValueService();
        p.setPid(1);
        p.setPtid(2);
        p.setValue("你好");
////1
        adminDAO.propertyValueInsert(p);
        //1
//        System.out.println(adminDAO.propertyValueCheck());
        //2

        // adminDAO.propertyValueDelete(p);


    }

}
