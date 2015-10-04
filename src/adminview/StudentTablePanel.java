package adminview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class StudentTablePanel extends JPanel {

	private StudentTableModel stm;
	private JTable table;
	private JPopupMenu stdPopMenu;
	private ITableListener sTblListener;

	public void setTableListener(ITableListener tableListener) {
		this.sTblListener = tableListener;
	}

	public StudentTablePanel() {

		stm = new StudentTableModel();
		table = new JTable(stm);
		
		stdPopMenu = new JPopupMenu();
		JMenuItem remove = new JMenuItem("remove");
		
		stdPopMenu.add(remove);

		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				int row = table.rowAtPoint(event.getPoint());
				table.getSelectionModel().setSelectionInterval(row,row);
				if (event.getButton() == MouseEvent.BUTTON3) {
					stdPopMenu.show(table, event.getX(), event.getY());
				}
			}
		});
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (sTblListener != null) {
					sTblListener.rowDeleted(row);
					refreshStdTbl();
				}
			}
		});
	}

	void setStdTblMdlDataSource(List<Student> ds) {
		stm.setDataSourceStd(ds);
	}

	void refreshStdTbl() {
		stm.fireTableDataChanged();
	}
}
