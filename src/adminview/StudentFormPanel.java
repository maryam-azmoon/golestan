package adminview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StudentFormPanel extends JPanel {

	private JLabel nameLbl, familyLbl, numberLbl, emailLbl, phoneLbl,
			addressLbl, usernameLbl, passwordLbl;

	private JTextField nameTxt, familyTxt, studentNumberTxt, emailTxt, phoneTxt,
			addressTxt, usernameTxt;

	private JPasswordField passwordTxt;

	private JButton regBtn;

	private IStudentPnlSubmitListener stdListener;

	public StudentFormPanel() {

		Dimension dim = getPreferredSize();
		dim.height = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);

		EtchedBorder innerBorder = new EtchedBorder(2);
		TitledBorder OuterBorder = new TitledBorder("Student Info");
		setBorder(BorderFactory.createCompoundBorder(OuterBorder, innerBorder));

		nameLbl = new JLabel("Name :*");
		familyLbl = new JLabel("Family :*");
		numberLbl = new JLabel("StudentNO :*");
		emailLbl = new JLabel("Email :*");
		phoneLbl = new JLabel("Phone :*");
		addressLbl = new JLabel("Address :");
		usernameLbl = new JLabel("Username :*");
		passwordLbl = new JLabel("Password :*");

		nameTxt = new JTextField(10);
		familyTxt = new JTextField(10);
		studentNumberTxt = new JTextField(10);
		emailTxt = new JTextField(10);
		phoneTxt = new JTextField(10);
		addressTxt = new JTextField(10);
		usernameTxt = new JTextField(10);
		passwordTxt = new JPasswordField(10);

		regBtn = new JButton("Submit");

		regBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				String error = "";
				if (!Validation.checkTextFieldString(nameTxt.getText())) {
					error += "name is incorrect. \n";
				}
				nameTxt.requestFocusInWindow();

				if (!Validation.checkTextFieldString(familyTxt.getText())) {
					error += "family is incorrect. \n";
				}

				if (!Validation.checkTextFieldNumber(studentNumberTxt.getText())) {

					if (!Validation.checkInputLenghtTextField(
							studentNumberTxt.getText())) {
						error += "Student number is incorrect you must enter 9 digits. \n";
					}
				}

				if (!Validation.checkPhonePattern(phoneTxt.getText())) {

					if (!Validation.checkInputLenghtTextField(
							phoneTxt.getText())) {
						error += "Phone number is incorrect you must enter 8 digits. \n";
					}
				}
				if (!Validation.checkEmailPattern(emailTxt.getText())) {
					error += "email is incorrect.\n";
				}
				if (!Validation.checkTextFieldEmpty(usernameTxt.getText())) {
					error+="Username can not empty.\n";
				}
				if (!Validation.checkTextFieldEmpty(passwordTxt.getText())) {
					error+="Password can not empty.\n";
				}

				if (error.equals("")) {

					Student std = new Student();

					std.setName(nameTxt.getText());
					std.setFamily(familyTxt.getText());
					std.setNumber(Integer.parseInt(studentNumberTxt.getText()));
					std.setEmail(emailTxt.getText());
					std.setPhone(phoneTxt.getText());
					std.setAddress(addressTxt.getText());
					std.setUsername(usernameTxt.getText());
					std.setPassword(passwordTxt.getText());
					stdListener.myStudentPnlSubBtnClicked(std);

				} else {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
		this.setLayout(new GridBagLayout());
		this.layoutComponent();
	}

	public void setStdListener(IStudentPnlSubmitListener x) {
		this.stdListener = x;
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
		add(numberLbl, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(studentNumberTxt, gc);

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
		add(regBtn, gc);
	}
}
