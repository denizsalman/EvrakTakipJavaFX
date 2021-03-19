package application.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.db.SqliteConnection;
import application.entity.Evrak;

public class EvrakRepository {

	private static final String GET_ALL_EVRAK = "SELECT id, idari_birim_kodu, il_kodu, ilce_kodu, kurum_kisi, evrak_tarihi, ek, kayit_tarihi, aciklama, konu"
			+ " FROM EVRAK where status = 1";

	private static final String GET_EVRAK = "select * from evrak where id = ?";
	private static final String INSERT_EVRAK = "INSERT INTO EVRAK (status, idari_birim_kodu, il_kodu, ilce_kodu, kurum_kisi, kayit_tarihi, ek, evrak_tarihi, aciklama, konu) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String DELETE_EVRAK = "DELETE FROM EVRAK WHERE id=?";

	
	public static int createEvrak(Evrak evrak) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		int update = 0;
		
		try {
			connection = SqliteConnection.getConnection();
			ps = connection.prepareStatement(INSERT_EVRAK);
			ps.setInt(1, 1);
			ps.setString(2, evrak.getIdariBirimKodu());
			ps.setString(3, evrak.getIl());
			ps.setString(4, evrak.getIlce());
			ps.setString(5, evrak.getKurumKisi());
			ps.setString(6, evrak.getEvrakTarihi());
			ps.setString(7, evrak.getEk());
			ps.setString(8, evrak.getKayitTarih());
			ps.setString(9, evrak.getAciklama());
			ps.setString(10, evrak.getKonu());
			
			update = ps.executeUpdate();
			
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
		return 0;
	}
	
	public static int deleteEvrak(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		int update = 0;
		
		try {
			connection = SqliteConnection.getConnection();
			ps = connection.prepareStatement(DELETE_EVRAK);
			ps.setInt(1, id);
			
			update = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
		return 0;
	}

	public static List<Evrak> getAllEvrak() throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		List<Evrak> evrakList = new ArrayList();
		
		try {
			connection = SqliteConnection.getConnection();
			ps = connection.prepareStatement(GET_ALL_EVRAK);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Evrak evrak = new Evrak();
				evrak.setId(rs.getInt(1));
				evrak.setIdariBirimKodu(rs.getString(2));
				evrak.setIl(rs.getString(3));
				evrak.setIlce(rs.getString(4));
				evrak.setKurumKisi(rs.getString(5));
				evrak.setEvrakTarihi(rs.getString(6));
				evrak.setEk(rs.getString(7));
				evrak.setKayitTarih(rs.getString(8));
				evrak.setAciklama(rs.getString(9));
				evrak.setKonu(rs.getString(10));
				evrakList.add(evrak);
			}
			
			return evrakList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
		return null;
	}
}
