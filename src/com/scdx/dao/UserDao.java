package com.scdx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class UserDao {
	

	private static String URL="jdbc:mysql://localhost:3306/scdx?characterEncoding=utf-8" ;
	private static String USER="root" ;
	private static String PASSWORD="root" ;
	private static Connection conn=null ;
	
	public String register(String id,String pwd){
		
		System.out.println("UserDao.register:开始连接数据库");
		
		
		
          try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("已找到JDBC驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
          
          
          try {
			conn=DriverManager.getConnection(URL,USER,PASSWORD) ;
			System.out.println("连接已经建立");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
          
          try {
			Statement stmt=(Statement) conn.createStatement();
			System.out.println("已经建立声明对象Statement");
			String sql="insert into  user(username,password) values('"+id+"','"+pwd+"');";
			
			System.out.println("将执行sql:"+sql);
			stmt.executeUpdate(sql);
			
			stmt.close();
			System.out.println("关闭声明对象Statment成功");
			conn.close();
			System.out.println("关闭连接成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
		return "success";
	}
	
	
	
	

}
