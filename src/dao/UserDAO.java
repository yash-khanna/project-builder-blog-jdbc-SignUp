package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) {
		// TODO Auto-generated method stub
		ConnectionManager cm=new ConnectionManager();
		String sql="insert into user1(username,password,LocalDate) values (?,?,?)";
		Connection con;
		int a=0;
		try {
			con = cm.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setDate(3, user.getDate());
			a=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		ConnectionManager cm=new ConnectionManager();
		String sql="select * from user1 where username=(?) and password1=(?) ";
		
		Connection con;
		int a=0;
		try {
			con = cm.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setDate(3, user.getDate());
			a=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
