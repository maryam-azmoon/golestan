package adminview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ActionListener {
	private JButton saveBtn;
	private JButton refreshBtn;
	private IToolbarListener iToolbarListener;

	public ToolBar() {
		//setFloatable(true);
		setBorder(BorderFactory.createEtchedBorder());
		
		saveBtn = new JButton();
		saveBtn.setIcon(Utils.createIcon("/images/Save16.gif"));
		saveBtn.setToolTipText("Save to Database");

		refreshBtn = new JButton();
		refreshBtn.setIcon(Utils.createIcon("/images/Refresh16.gif"));
		refreshBtn.setToolTipText("Refresh Data");

		this.add(saveBtn);
		this.addSeparator();
		this.add(refreshBtn);
		
		saveBtn.addActionListener(this);
		refreshBtn.addActionListener(this);

	}

	void setIToolbarListener(IToolbarListener iToolbarListener) {
		this.iToolbarListener = iToolbarListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == saveBtn) {
			if (this.iToolbarListener != null) {
				iToolbarListener.saveEventOccured();
			} else {
				if (this.iToolbarListener != null) {
					iToolbarListener.refreshEventOccured();
				}
			}
		}
		
		System.out.println("saved");
	}

}
