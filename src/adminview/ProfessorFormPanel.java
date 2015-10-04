package adminview;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfessorFormPanel extends JPanel {

	private JLabel nameLbl;
	private JLabel familyLbl;
	private JLabel profNOLbl;
	private JLabel usernameLbl;
	private JLabel passwordLbl;
	private JLabel phoneLbl;
	private JLabel emailLbl;
	private JLabel addressLbl;

	private JTextField nameTxt;
	private JTextField familyTxt;
	private JTextField profNOTxt;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JTextField phoneTxt;
	private JTextField emailTxt;
	private JTextField addressTxt;

	private Professor prof;

	private JButton submitBtn;

	private IProfessorPnlSubmitListener profListener;

	public void setProfListener(IProfessorPnlSubmitListener x) {
		this.profListener = x;
	}

	public ProfessorFormPanel() {

		Dimension dim = getPreferredSize();
		dim.height = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);

		nameLbl = new JLabel("Name:*");
		familyLbl = new JLabel("Family:*");
		profNOLbl = new JLabel("ProfNO:*");
		usernameLbl = new JLabel("username:*");
		passwordLbl = new JLabel("password:*");
		phoneLbl = new JLabel("phone:");
		addressLbl = new JLabel("address:");
		emailLbl = new JLabel("email:*");

		nameTxt = new JTextField(15);
		familyTxt = new JTextField(15);
		profNOTxt = new JTextField(15);
		usernameTxt = new JTextField(15);
		passwordTxt = new JPasswordField(15);
		phoneTxt = new JTextField(15);
		addressTxt = new JTextField(15);
		emailTxt = new JTextField(15);
		 

		submitBtn = new JButton("Submit");

		this.setLayout(new GridBagLayout());

		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				
				String error = "";
				if (!Validation.checkTextFieldString(nameTxt.getText())) 
					error += "Name is not correct. \n";
				if (!Validation.checkTextFieldString(familyTxt.getText()))
					error+= "Family is not correct. \n";
				if (!Validation.checkTextFieldNumber(profNOTxt.getText()))
					error += "Id is not correct. \n";
				if(!Validation.checkTextFieldEmpty(usernameTxt.getText()))
					error+="username is not correct \n";
				if(!Validation.checkTextFieldEmpty(passwordTxt.getText()))
					error+="password is not correct \n";
				if (!Validation.checkEmailPattern(emailTxt.getText())) {
						error+="email in not correct";
					}			
				if(error.equals("")){
				prof = new Professor();

				prof.setName(nameTxt.getText());
				prof.setFamily(familyTxt.getText());
				prof.setProfNO(Integer.parseInt(profNOTxt.getText()));
				prof.setAddress(addressTxt.getText());
				prof.setEmail(emailTxt.getText());
				prof.setPhone(phoneTxt.getText());
				prof.setUsername(usernameTxt.getText());
				prof.setPassword(passwordTxt.getText());

				profListener.myProfessorPnlSubBtnClicked(prof);
				}
				else{
					JOptionPane.showMessageDialog(null, error);
				}
			} 
		});

		this.layoutComponent();
	}

	public void layoutComponent() {

		GridBagConstraints gc = new GridBagConstraints();

		// gc.anchor = GridBagConstraints.FIRST_LINE_START;
		// gc.fill = GridBagConstraints.HORIZONTAL;
		// gc.weightx = 0.5;
		// gc.weighty = 0.5;
		gc.gridx = 0;
		gc.gridy = 0;
		add(nameLbl, gc);

		// gc.anchor = GridBagConstraints.FIRST_LINE_START;
		// gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridy = 0;
		add(nameTxt, gc);

		gc.gridx = 2;
		gc.gridy = 0;
		add(familyLbl, gc);

		gc.gridx = 3;
		gc.gridy = 0;
		add(familyTxt, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		add(profNOLbl, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(profNOTxt, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		add(emailLbl, gc);

		gc.gridx = 3;
		gc.gridy = 1;
		add(emailTxt, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		add(phoneLbl, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		add(phoneTxt, gc);

		gc.gridx = 2;
		gc.gridy = 2;
		add(addressLbl, gc);

		gc.gridx = 3;
		gc.gridy = 2;
		add(addressTxt, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		add(usernameLbl, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		add(usernameTxt, gc);

		gc.gridx = 2;
		gc.gridy = 3;
		add(passwordLbl, gc);

		gc.gridx = 3;
		gc.gridy = 3;
		add(passwordTxt, gc);

		gc.gridx = 4;
		gc.gridy = 4;
		add(submitBtn, gc);
	}
}
