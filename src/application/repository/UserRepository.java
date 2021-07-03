package application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.db.DBConnection;
import application.entity.User;

public class UserRepository {

	private static final String GET_USERS = "select * from user where id = ?";
	
	
	public static User getUser(Integer id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(GET_USERS);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = new User();
			
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setCreated(rs.getString(4));
			}
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return null;
	}
	
	public static List<User> getUsers(Integer id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> userList = new ArrayList();
		
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(GET_USERS);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setCreated(rs.getString(4));
				userList.add(user);
			}
			
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			connection.close();
		}
		return null;
	}
}
