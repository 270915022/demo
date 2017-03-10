package connpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnPoolTest {
	public static void main(String[] args) {
		final ConnectionPool pool = new ConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3308/usp", "root", "");
		try {
			pool.createpool();
			for (int i = 0; i < 2300; i++) {
				new Thread(){
					public void run() {
						try {
							Connection conn = pool.getConnection();
							PreparedStatement prepareStatement = conn.prepareStatement("select * from org_person");
							ResultSet result = prepareStatement.executeQuery();
							while(result.next()){
								String name = result.getString("name");
								System.out.println(name);
							}
							pool.closeCollection(conn);
						} catch (Exception e) {
							e.printStackTrace();
						}
					};
				}.start();
			}
			System.out.println(pool.getConnections().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
