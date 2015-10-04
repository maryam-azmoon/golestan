package adminview;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CourseFormPanel extends JPanel {

	private JLabel idLbl;
	private JLabel nameLbl;
	private JLabel professorLbl;

	private JTextField idTxt;
	private JTextField nameTxt;
	private JComboBox<Professor> professorCombo;

	private JButton courseBtn;

	private ICoursePnlSubmitListener listener;

	public void setIdTxt(String idTxt) {
		this.idTxt.setText(idTxt);
	}

	public void setNameTxt(String nameTxt) {
		this.nameTxt.setText(nameTxt);
	}

	public String getIdTxt() {
		return idTxt.getText();
	}

	public String getNameTxt() {
		return nameTxt.getText();
	}

	public void setListener(ICoursePnlSubmitListener x) {
		this.listener = x;
	}

	public CourseFormPanel() {

		Dimension dim = getPreferredSize();
		dim.height = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);

		professorCombo = new JComboBox<Professor>();

		setLayout(new GridBagLayout());

		idLbl = new JLabel("Course Code :");
		idTxt = new JTextField(20);

		nameLbl = new JLabel("Course Name :");
		nameTxt = new JTextField(20);

		professorLbl = new JLabel("Professor :");

		courseBtn = new JButton("submit");
		courseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String error = "";
				if (!Validation.checkTextFieldString(nameTxt.getText())) {
					error += "course name in not correct\n";
				}
				if (!Validation.checkTextFieldNumber(idTxt.getText())) {
					error += "course id is not correct\n";
				}
				if (error.equals("")) {
					Course c = new Course();

				c.setCourseId(Integer.parseInt(idTxt.getText()));
				c.setCourseName(nameTxt.getText());
				c.setCourseProf(professorCombo.getSelectedItem().toString());

				listener.myCoursePnlSubBtnClicked(c);
				}else {
					JOptionPane.showMessageDialog(null, error);
				}
				
			}
		});

		this.layoutComponent();
	}

	public void layoutComponent() {

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		this.add(idLbl, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		this.add(idTxt, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		this.add(nameLbl, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		this.add(nameTxt, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		this.add(professorLbl, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		this.add(professorCombo, gc);

		gc.gridx = 4;
		gc.gridy = 2;
		this.add(courseBtn, gc);

	}

	public void addToCombo(ArrayList<Professor> profList) {
		this.professorCombo.setModel(new DefaultComboBoxModel(profList
				.toArray()));
	}
}
