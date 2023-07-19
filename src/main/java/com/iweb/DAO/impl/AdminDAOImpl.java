package com.iweb.DAO.impl;

import com.iweb.DAO.AdminDAO;
import com.iweb.service.*;
import com.iweb.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author Cjl
 * @Description:
 * @Date 2023/7/18 11:31
 */
public class AdminDAOImpl implements AdminDAO {


    //======================================订单查询============================================
    @Override
    public Collection<OrderService> orderCheck() {
        Collection<OrderService> orderList = new ArrayList<>();
        String sql = "select * from `order`";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int user_id = rs.getInt("user_id");
                int address_id = rs.getInt("address_id");
                Date order_date = rs.getDate("order_date");
                String order_status = rs.getString("order_status");

                OrderService order = new OrderService(order_id, user_id, address_id, order_date, order_status);

                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList.isEmpty() ? null : orderList;
    }

    //=======================================订单详情查询================================================
    @Override
    public Collection<OrderDetailService> orderDetailCheck() {
        Collection<OrderDetailService> OrderDetailList = new ArrayList<>();
        String sql = "select * from order_detail";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int detail_id = rs.getInt("detail_id");
                int oid = rs.getInt("oid");
                int pid = rs.getInt("pid");
                int quantity = rs.getInt("quantity");

                OrderDetailService orderDetail = new OrderDetailService(detail_id, oid, pid, quantity);

                OrderDetailList.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderDetailList.isEmpty() ? null : OrderDetailList;
    }
//============================商品属性值增删改查===========================================


    @Override
    public void propertyValueInsert(PropertyValueService propertyValue) {
        String sql = "insert into propertyvalue(pid,ptid,value) values(?,?,?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            if (propertyValue.getValue() == null || propertyValue == null || propertyValue.getValue().equals("")) {
                System.out.println("参数有误，请检查参数,后重新插入");
                return;
            }
            ps.setInt(1, propertyValue.getPid());
            ps.setInt(2, propertyValue.getPtid());
            ps.setString(3, propertyValue.getValue());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                propertyValue.setId(id);
            }
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void propertyValueDelete(PropertyValueService propertyValue) {
        String sql = "delete from property where 1=1";
        if (propertyValue == null) {
            System.out.println("参数有误");
            return;
        }
        if (propertyValue.getId() > 0 && (propertyValue.getValue() == null || propertyValue.getValue().equals(""))) {
            sql = sql + " and id = ?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setInt(1, propertyValue.getId());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (propertyValue.getId() <= 0 && (propertyValue.getValue() != null && (!propertyValue.getValue().equals("")))) {
            sql = sql + " and name =?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, propertyValue.getValue());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("参数有误");
        }
    }

    @Override
    public void propertyValueUpdate(PropertyValueService propertyValue) {
        String sql = "update property set pid=?,ptid=?,value =? where id=?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, propertyValue.getPid());
            ps.setInt(2, propertyValue.getPtid());
            ps.setString(2, propertyValue.getValue());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<PropertyValueService> propertyValueCheck() {
        Collection<PropertyValueService> propertyValueList = new ArrayList<>();
        String sql = "select * from propertyvalue";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int pid = rs.getInt("pid");
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                PropertyValueService propertyValue = new PropertyValueService(id, pid, ptid, value);

                propertyValueList.add(propertyValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValueList.isEmpty() ? null : propertyValueList;
    }

    //======================================商品属性增删改查================================================
    @Override
    public void propertyInsert(PropertyService property) {
        String sql = "insert into property(cid,name) values(?,?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            if (property.getName() == null || property == null || property.getName().equals("")) {
                System.out.println("参数有误，请检查参数,后重新插入");
                return;
            }
            ps.setInt(1, property.getCid());
            ps.setString(2, property.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                property.setId(id);
            }
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void propertyDelete(PropertyService property) {
        String sql = "delete from property where 1=1";
        if (property == null) {
            System.out.println("参数有误");
            return;
        }
        if (property.getId() > 0 && (property.getName() == null || property.getName().equals(""))) {
            sql = sql + " and id = ?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setInt(1, property.getId());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (property.getId() <= 0 && (property.getName() != null && (!property.getName().equals("")))) {
            sql = sql + " and name =?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, property.getName());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("参数有误");
        }
    }

    @Override
    public void propertyUpdate(PropertyService property) {
        String sql = "update property set name=? where id=?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, property.getName());
            ps.setInt(2, property.getId());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<PropertyService> propertyCheck() {
        Collection<PropertyService> propertyList = new ArrayList<>();
        String sql = "select * from property";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cid = rs.getInt("cid");
                String name = rs.getString("name");

                PropertyService propertyService = new PropertyService(id, cid, name);

                propertyList.add(propertyService);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyList.isEmpty() ? null : propertyList;
    }

    //======================================商品分类的增删改查===================================================
    @Override
    public void categoryInsert(CategoryService category) {
        String sql = "insert into category(name) values(?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            if (category.getName() == null || category == null || category.getName().equals("")) {
                System.out.println("参数有误，请检查参数,后重新插入");
                return;
            }
            ps.setString(1, category.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                category.setId(id);
            }
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void categoryDelete(CategoryService category) {
        String sql = "delete from category where 1=1";
        if (category == null) {
            System.out.println("参数有误");
            return;
        }
        if (category.getId() > 0 && (category.getName() == null || category.getName().equals(""))) {
            sql = sql + " and id = ?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setInt(1, category.getId());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (category.getId() <= 0 && (category.getName() != null && (!category.getName().equals("")))) {
            sql = sql + " and name =?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, category.getName());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("参数有误");
        }
    }

    @Override
    public void categoryUpdate(CategoryService category) {
        String sql = "update category set name=? where id=?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<CategoryService> categoryCheck() {
        Collection<CategoryService> categoryList = new ArrayList<>();
        String sql = "select * from category";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                CategoryService categoryService = new CategoryService(id, name);

                categoryList.add(categoryService);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList.isEmpty() ? null : categoryList;
    }

    //------------------------------------------------------------------------------------------
    //商品增删改查
    @Override
    public void productInsert(ProductService product) {
        String sql = "insert into product(name,origibakprice,cid,stock,creatDate,promoteprice) values(?,?,?,?,?,?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            if (product.getName() == null || product == null || product.getName().equals("")) {
                System.out.println("参数有误，请检查参数,后重新插入");
                return;
            }
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getOrigibakprice());
            ps.setInt(3, product.getCid());
            ps.setInt(4, product.getStock());
            ps.setTime(5, (Time) product.getCreatDate());
            ps.setDouble(6, product.getPromoteprice());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                product.setId(id);
            }
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void productDelete(ProductService product) {
        String sql = "delete from product where 1=1";
        if (product == null) {
            System.out.println("参数有误");
            return;
        }
        if (product.getId() > 0 && (product.getName() == null || product.getName().equals(""))) {
            sql = sql + " and id = ?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setInt(1, product.getId());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (product.getId() <= 0 && (product.getName() != null && (!product.getName().equals("")))) {
            sql = sql + " and name =?";
            try (Connection c = JDBCUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, product.getName());
                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("参数有误");
        }
    }

    @Override
    public void productUpdate(ProductService product) {
        String sql = "update product set name=? , originalprice=? ,cid=? , stock=? , creatDate=? ,promoteprice=? where id=?)";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getOrigibakprice());
            ps.setInt(3, product.getCid());
            ps.setInt(4, product.getStock());
            ps.setTime(5, (Time) product.getCreatDate());
            ps.setDouble(6, product.getPromoteprice());
            ps.setInt(7, product.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<ProductService> productCheck() {
        Collection<ProductService> productList = new ArrayList<>();
        String sql = "select * from product";
        try (Connection c = JDBCUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double originalprice = rs.getDouble("originalprice");
                int cid = rs.getInt("cid");
                int stock = rs.getInt("stock");
                Date createDate = rs.getDate("creatDate");
                double promoterprice = rs.getDouble("promoterprice");
                String subtitle = rs.getString("subtitle");
                ProductService produceService = new ProductService(id, name, originalprice, cid, stock, createDate, promoterprice, subtitle);

                productList.add(produceService);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList.isEmpty() ? null : productList;
    }
}
