package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconexion {
	public static Connection getConexion() {
		
		/*bd
		 * remotemysql.com/uRrawx2ojM
		 *uRrawx2ojM
		 *IO3L6M2YiU */
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://remotemysql.com/uRrawx2ojM";
			String usr = "uRrawx2ojM";
			String psw = "IO3L6M2YiU";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException ex) {
			System.out.println("Error >> de conexión con la BD");
		}
		return con;
	}
}
