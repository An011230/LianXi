package com.test;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        //1、加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、连接信息，用户信息密码
            String url="jdbc:mysql://localhost:3306/ry?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
            String username = "root";
            String password = "123456";
            //3、连接数据库，获得数据库对象
            Connection connection = DriverManager.getConnection(url,username,password);
            //4、获取sql执行对象
            Statement statement = connection.createStatement();
            //5、执行sql
            String sql="select * from sys_user";
            ResultSet resultSet= statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("user_id:"+resultSet.getObject("user_id")+"login_name"+resultSet.getObject("login_name"));
            }
            //6、释放连接
            resultSet.close();
            statement.close();
            connection.close();





        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
