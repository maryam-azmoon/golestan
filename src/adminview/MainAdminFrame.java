package adminview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import Controller.Controller;

public class MainAdminFrame extends JFrame {

	private JTabbedPane adminTabbedPane;

	private JSplitPane studentTab;
	private StudentFormPanel studentFormPanel;
	private StudentTablePanel studentTablePanel;
	private ArrayList<Student> studentArrLst;

	private JSplitPane courseTab;
	private CourseFormPanel courseFormPanel;
	private CourseTablePanel courseTablePanel;
	private ArrayList<Course> courseArrLst;

	private JSplitPane ProfessorTab;
	private ProfessorFormPanel professorFrmPnl;
	private ProfessorTablePanel professorTablePanel;

	private ToolBar toolbar;

	Controller c;

	public MainAdminFrame() {

		super("Golestan System");
		c = new Controller();
		setJMenuBar(createMenu());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);

		this.adminTabbedPane = new JTabbedPane();

		this.studentArrLst = new ArrayList<Student>();
		this.courseArrLst = new ArrayList<Course>();
		toolbar = new ToolBar();
		this.createStudentTab();
		this.creatCourseTab();
		this.createProfTab();
		
		this.setLayout(new BorderLayout());

		studentTablePanel.setTableListener(new ITableListener() {

			@Override
			public void rowDeleted(int row) {
				studentArrLst.remove(row);
			}
		});

		courseTablePanel.setcTblListener(new ITableListener() {

			@Override
			public void rowDeleted(int row) {
				courseArrLst.remove(row);

			}
		});
		professorTablePanel.setiTableListener(new ITableListener() {

			@Override
			public void rowDeleted(int row) {
				DataUtil.profList.remove(row);
				// professorTablePanel.setproftblModel(DataUtil.profList);

			}
		});
		toolbar.setIToolbarListener(new IToolbarListener() {

			@Override
			public void saveEventOccured() {
				try {
					c.save(studentArrLst);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void refreshEventOccured() {
				// TODO Auto-generated method stub

			}
		});

		this.add(adminTabbedPane, BorderLayout.CENTER);

		this.add(toolbar, BorderLayout.PAGE_START);
	}

	private JMenuBar createMenu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu colorMenu = new JMenu("Color");
		JMenu pageMenu = new JMenu("Page");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(colorMenu);
		menuBar.add(pageMenu);

		JMenuItem saveDbItem = new JMenuItem("Save To DB");
		JMenuItem loadDbItem = new JMenuItem("Load From DB");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(saveDbItem);
		fileMenu.add(loadDbItem);
		fileMenu.add(exitItem);

		JMenu prefrences = new JMenu("Prefrences");
		JMenu changeMenu = new JMenu("Change");

		editMenu.add(prefrences);
		editMenu.add(changeMenu);

		JMenuItem setDbDataItem = new JMenuItem("Set DB Data");
		JMenuItem changeTheme = new JMenuItem("Change Theme");

		prefrences.add(setDbDataItem);
		prefrences.add(changeTheme);

		JMenuItem passwordItem = new JMenuItem("Password");
		changeMenu.add(passwordItem);

		JRadioButtonMenuItem redRadio = new JRadioButtonMenuItem("Red");
		JRadioButtonMenuItem blueRadio = new JRadioButtonMenuItem("Blue");
		JRadioButtonMenuItem greenRdio = new JRadioButtonMenuItem("Green");

		ButtonGroup bg = new ButtonGroup();

		bg.add(redRadio);
		bg.add(blueRadio);
		bg.add(greenRdio);

		redRadio.setSelected(true);

		colorMenu.add(redRadio);
		colorMenu.add(blueRadio);
		colorMenu.add(greenRdio);

		JCheckBoxMenuItem studentCheckBx = new JCheckBoxMenuItem("Student");
		JCheckBoxMenuItem courseCheckBx = new JCheckBoxMenuItem("Course");
		JCheckBoxMenuItem profCheckBx = new JCheckBoxMenuItem("Professor");

		pageMenu.add(studentCheckBx);
		pageMenu.add(courseCheckBx);
		pageMenu.add(profCheckBx);

		saveDbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		loadDbItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));

		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		colorMenu.setMnemonic(KeyEvent.VK_C);
		pageMenu.setMnemonic(KeyEvent.VK_P);

		saveDbItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("save to db");
			}
		});

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		redRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentFormPanel.setBackground(Color.RED);

			}
		});
		blueRadio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentFormPanel.setBackground(Color.BLUE);

			}
		});
		greenRdio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentFormPanel.setBackground(Color.GREEN);
			}
		});
		return menuBar;
	}

	private void createStudentTab() {

		studentFormPanel = new StudentFormPanel();
		studentTablePanel = new StudentTablePanel();

		studentTab = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				studentFormPanel, studentTablePanel);

		adminTabbedPane.add("Student", studentTab);

		studentTab.setOneTouchExpandable(true);

		studentFormPanel.setStdListener(new IStudentPnlSubmitListener() {

			@Override
			public void myStudentPnlSubBtnClicked(Student s) {

				studentArrLst.add(s);
				studentTablePanel.setStdTblMdlDataSource(studentArrLst);
				studentTablePanel.refreshStdTbl();
			}
		});
	}

	private void creatCourseTab() {
		this.courseFormPanel = new CourseFormPanel();
		this.courseTablePanel = new CourseTablePanel();

		this.courseTab = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				courseFormPanel, courseTablePanel);

		adminTabbedPane.add("Course", courseTab);

		this.courseTab.setOneTouchExpandable(true);

		this.courseFormPanel.setListener(new ICoursePnlSubmitListener() {

			@Override
			public void myCoursePnlSubBtnClicked(Course c) {

				courseArrLst.add(c);
				courseTablePanel.setCourseTblMdl(courseArrLst);
				courseTablePanel.refreshCourseTbl();
			}

		});
	}

	private void createProfTab() {

		professorFrmPnl = new ProfessorFormPanel();
		professorTablePanel = new ProfessorTablePanel();

		ProfessorTab = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				professorFrmPnl, professorTablePanel);

		ProfessorTab.setOneTouchExpandable(true);

		adminTabbedPane.add("Professor", ProfessorTab);

		this.professorFrmPnl.setProfListener(new IProfessorPnlSubmitListener() {

			@Override
			public void myProfessorPnlSubBtnClicked(Professor p) {

				DataUtil.profList.add(p);

				professorTablePanel.refreshProfTbl();

				courseFormPanel.addToCombo(DataUtil.profList);
			}
		});
	}
}
