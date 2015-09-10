package inventory.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderCheck {
	private ResultSet result;
	int j;

	public boolean order(int n) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement st = conn.createStatement();
			String cmd = "Select * from dept where deptno=" + n;
			ResultSet result = st.executeQuery(cmd);
			result.next();
			j = result.getInt(0);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		if (j != 0) {
			return false;
		} else {
			return true;
		}
	}

}
