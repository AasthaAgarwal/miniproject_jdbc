package mp;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "aastha");

		} catch (Exception e) {
			System.out.print("error-->" + e);
		}

	}

	public static Connection getConnection() {
		return con;
	}

}
