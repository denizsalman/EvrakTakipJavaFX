package application.db;

import java.sql.Connection;

public class DBConnection {

	public static Connection getConnection() {
		return H2Connection.getConnection();
	}
}
