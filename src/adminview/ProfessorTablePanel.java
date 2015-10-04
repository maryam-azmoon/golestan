package adminview;
import java.awt.BorderLayout;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProfessorTablePanel extends JPanel{
	private JTable professorTbl;
	private ProfessorTableModel professorTblModl;
	
	private JPopupMenu pPopupMenu;
	private ITableListener iTableListener;
	
	public void setiTableListener(ITableListener iTableListener) {
		this.iTableListener = iTableListener;
	}

	public ProfessorTablePanel() {
		
		professorTblModl = new ProfessorTableModel();
		professorTbl = new JTable(professorTblModl);
		
		JMenuItem remove = new JMenuItem("Delete Row");
		pPopupMenu = new JPopupMenu();
		
		pPopupMenu.add(remove);
		
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(professorTbl),BorderLayout.CENTER);
		
		professorTbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				int row = professorTbl.rowAtPoint(event.getPoint());
				professorTbl.getSelectionModel().setSelectionInterval(row,row);
				if (event.getButton() == MouseEvent.BUTTON3) {
					pPopupMenu.show(professorTbl, event.getX(), event.getY());
				}
			}
		});
		
	}
	
	void setproftblModel(List<Professor> p){
		professorTblModl.setProfList(p);
	}
	void refreshProfTbl(){
		professorTblModl.fireTableDataChanged();
	}
	
}
