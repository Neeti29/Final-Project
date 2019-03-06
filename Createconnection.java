package Final_Project;

import java.sql.Connection;
import java.sql.DriverManager;

public class Createconnection {
	static Connection con;
	
		public static Connection createConnection()
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // cj is a latest driver //loading and registering the driver
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/ems", "root", "connection");
				
			}

			catch (Exception e) {
				System.out.println(e);
			}
			return con;
		}
	}