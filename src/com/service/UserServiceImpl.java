package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.User;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser(User user) {

		
		try {
			
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String username="root";
			String password="Vishnu664";
			try {
				Connection con=DriverManager.getConnection(url,username,password);
				
				// create query
				String sql="insert into user(name,email,address,phone)values('"+user.getName()+"','"+user.getEmail()+"','"+user.getAddress()+"','"+user.getPhone()+"')";
				
				// create statement
				Statement stmt=con.createStatement();
				
				// execute statement
				stmt.execute(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","Vishnu664");
			
			
			String sql="update user set name='"+user.getName()+"' , email='"+user.getEmail()+"' , address='"+user.getAddress()+"' , phone='"+user.getPhone()+"' where id='"+user.getId()+"'   ";
			
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate(sql);
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","Vishnu664");
				
				String sql="delete from user where id='"+userId+"'  ";
				
				Statement stmt=con.createStatement();
				
				stmt.execute(sql);
				
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		

	}

	@Override
	public User getUser(int id) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","Vishnu664");
				
				String sql="select * from user where id='"+id+"'  ";
				
				Statement stmt=con.createStatement();
				
				
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println("********************************************");
				}
				
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public List<User> getAllUser() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","Vishnu664");
				
				String sql="select * from user";
				
				Statement stmt=con.createStatement();
				
				ResultSet rs =stmt.executeQuery(sql);
				
				
				while(rs.next())
				{
					
					System.out.println("User Id : "+rs.getInt(1));
					System.out.println("User Name : "+ rs.getString(2));
					System.out.println("User Email : "+rs.getString(3));
					System.out.println("User Address : "+rs.getString(4));
					System.out.println("User Phone : "+rs.getString(5));
					System.out.println("**********************************************");
					
					
				}
				
				con.close();
				
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
