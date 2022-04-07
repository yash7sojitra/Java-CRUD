package com.crud;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empDAO {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url="jdbc:mysql://localhost:3306/yash";
		String uname="root";
		String password = "root";
			Connection con= null;
		 
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection(url,uname,password);
		
			
			return con;
	}
	
	
	public static int save(Emp e) throws SQLException, ClassNotFoundException {
		int status=0;
		
		
		
			Connection con = empDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO employee (emp_name,emp_password,email ,country) VALUES (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status=ps.executeUpdate();
			
			con.close();
	
		return status;	
	
	}
	
	public static int update(Emp e) throws ClassNotFoundException, SQLException {
		int status=0;
		
		
		Connection con=empDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE employee SET emp_name=?, emp_password=?,email=?,country =? WHERE id =?;");
		ps.setString(1,e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setInt(5, e.getId());
		
		status = ps.executeUpdate();
		
		con.close();
		return status;
	}
	public static int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con = empDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("Delete from employee where id = ?");
		ps.setInt(1, id);
		int status = ps.executeUpdate();
		
		con.close();
		return status;
	}
	public static Emp getEmployeeById(int id) throws ClassNotFoundException, SQLException {
		Emp e = new Emp();
		
		Connection con = empDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
		}
		
		con.close();
		return e;
	}
	public static List<Emp> getAllEmployees() throws ClassNotFoundException, SQLException{
		Connection con = empDAO.getConnection();
		List<Emp> list = new ArrayList<Emp>();
		
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Emp e = new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
			
			list.add(e);
		}
		con.close();
		return list;
	}
}
