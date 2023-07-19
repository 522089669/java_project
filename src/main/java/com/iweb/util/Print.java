package com.iweb.util;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/17 18:01
 */
public class Print {
    public static void print(String printMessage){
        //字符串转为字符数组 逐个打印
        char[] cs = printMessage.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[i]);
            //控制打印的出现
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //换行
        System.out.println();
    }
}
