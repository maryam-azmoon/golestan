package Biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import adminview.Student;

import java.io.IOException;
import java.sql.SQLException;

public class DataBase {
	Connection con;

	public void save(List<Student> studentArray) {

	}

	public boolean connect() throws SQLException, ClassNotFoundException {

		if (con != null) {
			return true;
		}

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionURL = "jdbc:sqlserver://swsql.mahanair.aero;user=sa;password=123;database=javaTraining";

		con = DriverManager.getConnection(connectionURL);
		System.out.println("connected");
		if (con == null) {
			return false;
		}
		return true;

	}
}
