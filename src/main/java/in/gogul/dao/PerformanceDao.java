package in.gogul.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PerformanceDao {

	private static final String GOKUL_26 = "Gokul@26";
	private static final String ROOT = "root";
	private static final String JDBC_MYSQL_LOCALHOST_3306_PERFORMANCE = "jdbc:mysql://localhost:3306/performance";
	private static final String COM_MYSQL_CJ_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public boolean perfDao(List<String> randomList) throws Exception {

		try {
			Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
			Connection con = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_PERFORMANCE, ROOT, GOKUL_26);
			Statement statement = con.createStatement();

			String sql = "insert ignore into Code (unique_Code) values "
					+ randomList.toString().replace("[", "").replace("]", "");
			statement.executeUpdate(sql);

			statement.close();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public int getDao() throws Exception {

		String sql = "select count(Unique_code) from code";
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;

		try {
			Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
			con = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_PERFORMANCE, ROOT, GOKUL_26);
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			con.close();
			resultSet.close();

		}

		return count;
	}

}
