package com.Zane;

import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) {

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=GMT&characterEncoding=utf8&useSSL=true";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);

            Statement s = connection.createStatement();



            System.out.println("获取 Statement对象： " + s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

}
