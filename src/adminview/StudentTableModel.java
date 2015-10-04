package adminview;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
	private String[] colName = { "Name", "Family", "StudentNO", "Email", "Phone","Address", "Username", "Password" };
	private List<Student> dataSourceStd;

	public StudentTableModel() {
		dataSourceStd = new ArrayList<Student>();
	}

	void setDataSourceStd(List<Student> dataSource) {
		this.dataSourceStd = dataSource;
	}

	@Override
	public String getColumnName(int i) {

		return this.colName[i];
	}

	@Override
	public int getColumnCount() {

		return colName.length;
	}

	@Override
	public int getRowCount() {
		return dataSourceStd.size();
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		if (dataSourceStd==null) {
			return;
		}
		Student s = (Student)dataSourceStd.get(row);
		switch (col){
		case 0:
			s.setName((String)value);
			break;
		case 1:
			s.setFamily((String)value);
			break;
		case 5:
			s.setPhone((String)value);
			break;
		case 6:
			s.setEmail((String)value);
			break;
		case 7:
			s.setAddress((String)value);
			break;
			default:
				return ;
		}

	}

	@Override
	public Object getValueAt(int row, int col) {
		for (int i = 0; i < dataSourceStd.size(); i++) {

			Student s = dataSourceStd.get(row);

			if (0 == col) {
				return s.getName();
			} else if (1 == col) {
				return s.getFamily();
			} else if (2 == col) {
				return s.getNumber();
			} else if (3 == col) {
				return s.getEmail();
			} else if (4 == col) {
				return s.getPhone();
			} else if (5 == col) {
				return s.getAddress();
			} else if (6 == col) {
				return s.getUsername();
			} else if (7 == col) {
				return s.getPassword();
			}
		}
		return null;
	}
}
