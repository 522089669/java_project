package com.iweb.DAO;

import com.iweb.service.*;

import java.util.Collection;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 11:08
 */
public interface AdminDAO {


    /**商品的插入
     * @param product
     */
    void productInsert(ProductService product);

    /**商品的删除
     * @param product
     */
    void productDelete(ProductService product);

    /**商品的修改
     * @param product
     */
    void productUpdate(ProductService product);

    /**商品查看
     * @return
     */
    Collection<ProductService> productCheck();


    /**商品分类增加
     * @param category
     */
    void categoryInsert(CategoryService category);

    /**商品分类删除
     * @param category
     */
    void categoryDelete(CategoryService category);

    /**商品分类更新
     * @param category
     */
    void categoryUpdate(CategoryService category);

    /**商品分类查询
     * @return
     */
    Collection<CategoryService> categoryCheck();



    /**商品属性增加
     * @param property
     */
    void propertyInsert(PropertyService property);

    /**商品属性删除
     * @param property
     */
    void propertyDelete(PropertyService property);

    /**商品属性更新
     * @param property
     */
    void propertyUpdate(PropertyService property);

    /**商品属性查询
     * @return
     */
    Collection<PropertyService> propertyCheck();


    /**商品属性值增加
     * @param propertyValue
     */
    void propertyValueInsert(PropertyValueService propertyValue);

    /**商品属性值删除
     * @param propertyValue
     */
    void propertyValueDelete(PropertyValueService propertyValue);

    /**商品属性值更改
     * @param propertyValue
     */
    void propertyValueUpdate(PropertyValueService propertyValue);

    /**商品属性值查询
     * @return
     */
    Collection<PropertyValueService> propertyValueCheck();

    /**查看订单
     * @return
     */
    Collection<OrderService> orderCheck();

    /**订单发货状态
     * @param oid  根据订单编号发货
     */
    void orderDeliveroodsUpdate(int oid);

    /**订单退货状态
     * @param oid  根据订单编号退货
     */
    void orderReturnGoodsUpdate(int oid);

    /**查看订单详情
     * @return
     */
    Collection<OrderDetailService> orderDetailCheck();



}
