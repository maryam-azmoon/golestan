package adminview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.table.AbstractTableModel;

public class CourseTableModel extends AbstractTableModel {

	String[] colName = { "Course.ID", "Course.Name", "Professor" };

	private List<Course> courseList;

	public CourseTableModel() {
		
		courseList = new ArrayList<Course>();
		
	}

	public void setCourseList(List<Course> cL) {
		this.courseList = cL;
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
		return courseList.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		for (int i = 0; i < courseList.size(); i++) {
			Course c = courseList.get(row);
			if (0==col) {
				return c.getCourseId();
			}
			else if(1==col){
				return c.getCourseName();
			}
			else if(2==col){
				return c.getCourseProf();
			}
		}
		return null;
	}

}
