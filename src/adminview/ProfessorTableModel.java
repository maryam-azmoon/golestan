package adminview;

import javax.swing.table.AbstractTableModel;

import java.util.ArrayList;
import java.util.List;

public class ProfessorTableModel extends AbstractTableModel {

	private String[] colName = { "Name", "Family", "ProfNO", "Email", "Phone",
			"Address", "Username", "Password" };

	private List<Professor> profList;

	public void setProfList(List<Professor> p) {
		this.profList = p;
	}

	public ProfessorTableModel() {
	
		profList = DataUtil.profList;
	}

	@Override
	public String getColumnName(int i) {
		return colName[i];
	}

	@Override
	public int getColumnCount() {

		return colName.length;
	}

	@Override
	public int getRowCount() {
		return profList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		for (int i = 0; i < profList.size(); i++) {

			Professor p = profList.get(row);

			if (0 == col)
				return p.getName();
			else if (1 == col)
				return p.getFamily();
			else if (2 == col)
				return p.getProfNO();
			else if (3 == col)
				return p.getEmail();
			else if (4 == col)
				return p.getPhone();
			else if (5 == col)
				return p.getAddress();
			else if (6 == col)
				return p.getUsername();
			else if (7 == col)
				return p.getPassword();

		}

		return null;
	}

}
