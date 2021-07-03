package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
	
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			Connection connection = DriverManager.getConnection("jdbc:h2:./database/evrak_kayit;IFEXISTS=TRUE");
			System.out.println("H2 Connection SUCCESS");
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
