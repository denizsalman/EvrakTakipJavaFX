package application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.db.SqliteConnection;
import application.entity.Il;
import application.entity.Ilce;

public class UtilRepository {

	private static final String GET_ILLER = "select * from il";
	private static final String GET_ILCELER = "select * from ilce where il_no = ?";
	
	
	public static List<Il> getIller() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Il> ilList = new ArrayList();
		
		try {
			connection = SqliteConnection.getConnection();
			ps = connection.prepareStatement(GET_ILLER);
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Il il = new Il();
				il.setIl_no(rs.getInt(1));
				il.setIsim(rs.getString(2));
				ilList.add(il);
			}
			
			return ilList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<Ilce> getIlceler(int id) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ilce> ilceList = new ArrayList();
		
		try {
			connection = SqliteConnection.getConnection();
			ps = connection.prepareStatement(GET_ILCELER);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				Ilce ilce = new Ilce();
				ilce.setIlce_no(rs.getInt(1));
				ilce.setIsim(rs.getString(2));
				ilce.setIl_no(rs.getInt(3));
				ilceList.add(ilce);
			}
			
			return ilceList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
