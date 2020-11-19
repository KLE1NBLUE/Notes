package com.Zane;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;



public class Orm {

    static  String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=GMT&characterEncoding=utf8&useSSL=true";

    static String user = "root";

    static String password = "admin";

    public static void add(Hero h,Statement s) throws SQLException {

        String sql="insert into hero values(null,'"+h.name+"',"+h.hp+","+h.damage+")";

        s.execute(sql);

        ResultSet rs=s.getGeneratedKeys();

        if(rs.next()) {

            h.id=rs.getInt(1);

            System.out.println("已插入name为"+h.name+"的英雄,自动分配ID为"+h.id);

        }

    }

    public static void delete(Hero h,Statement s) throws SQLException {

        String sql="delete from hero where id="+h.id;

        s.execute(sql);

        System.out.println("已删除ID为"+h.id+"的英雄");

    }

    public static void update(Hero h,Statement s) throws SQLException {

        String sql="update hero set name='蛤蟆' where id ="+h.id;

        s.execute(sql);

        System.out.println("已将ID为"+h.id+"的英雄姓名更改为蛤蟆");

    }

    public static List<Hero> list(Statement s) throws SQLException{

        String sql="select * from hero";

        List<Hero> heros=new ArrayList<>();

        ResultSet rs=s.executeQuery(sql);

        while(rs.next()) {

            Hero h=new Hero();

            h.id=rs.getInt("id");

            h.name=rs.getString("name");

            h.hp=rs.getFloat("hp");

            h.damage=rs.getInt("damage");

            heros.add(h);

        }

        return heros;

    }

    public static void getDataNum(Statement s) throws SQLException {

        String sql="select count(*) from hero";

        ResultSet rs=s.executeQuery(sql);

        if(rs.next()) {

            System.out.println("数据库中共有"+rs.getInt(1)+"条数据");

        }

    }

    public static void main(String args[]) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        try ( Connection c = DriverManager.getConnection(url,user,password);

              Statement s = c.createStatement();

        ){

            for(int i=0;i<50;i++) {

                Hero h=new Hero("压缩"+i,166,20);

                add(h,s);

            }

            List<Hero> heros=list(s);

            for(Hero h:heros) {

                if(h.id==100) {

                    delete(h,s);

                }else if(h.id==101) {

                    update(h,s);

                }

            }

            getDataNum(s);

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
