package by.htp.library.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DBConnectionHelper {

	private static final String DB_CONNECT_PROPERTY = "db_config";

	private DBConnectionHelper() {
	}

	public static Connection connect() {
		Connection connection = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
			String url = rb.getString("db.url");
			String login = rb.getString("db.login");
			String pass = rb.getString("db.pass");
			String driver = rb.getString("db.driver");

			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName(driver); // dynamic upload of class

			connection = DriverManager.getConnection(url, login, pass);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void disconnect(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
