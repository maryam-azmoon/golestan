package adminview;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CourseTablePanel extends JPanel {
	private JTable table;
	private CourseTableModel ctm;
	private JPopupMenu cPopupMnu;
	//farghesh ba inke tu constructor tarif konim chiye? remove itemo
	private JMenuItem removeMnuItem;
	private ITableListener cTblListener;
	
	public void setcTblListener(ITableListener tl) {
		this.cTblListener = tl;
	}

	public CourseTablePanel(){
		
		ctm = new CourseTableModel();
		table = new JTable(ctm);
		cPopupMnu = new JPopupMenu();
		removeMnuItem = new JMenuItem("Remove");
				
		setLayout(new BorderLayout());
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		cPopupMnu.add(removeMnuItem);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent event) {
				int row = table.rowAtPoint(event.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				if (event.getButton()==MouseEvent.BUTTON3){
					cPopupMnu.show(table, event.getX(), event.getY());
				}
			}
			
		});
		
	removeMnuItem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			if (cTblListener!=null){
			cTblListener.rowDeleted(row);
			ctm.fireTableDataChanged();
			}
			
		}
	});
		
	}
	
	public void setCourseTblMdl(List<Course> cL) {
		ctm.setCourseList(cL);
	}
	void refreshCourseTbl(){
		ctm.fireTableDataChanged();
	}
	
}
