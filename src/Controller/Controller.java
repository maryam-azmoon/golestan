package Controller;

import java.sql.SQLException;
import java.util.List;

import Biz.DataBase;
import adminview.Student;

public class Controller {
	DataBase db;

	public Controller()  {
		db = new DataBase();
	}

	public void save(List<Student> input)throws ClassNotFoundException, SQLException {
		db.connect();
		this.db.save(input);
	}

}
