
import java.awt.Dimension;
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Element;
import javax.swing.text.TableView.TableRow;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 * School Portal project. 3/8/2018
 * 
 * */
public class JStudent2 {

	private JFrame frmSchoolPortal;
	private JTextField textField_1;
	private JTextField txtTodaysDate;
	private JTable table1;
	private int num_rows = 5;
	private int num_cols = 5;
	private JTextField txtJess;
	private JTextField txtDeveloper;
	private JTextField textField;
	DefaultTableModel model ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JStudent2 window = new JStudent2();
					window.frmSchoolPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JStudent2() {
		initialize();
	}

	/**
	 * Method to update the table. 
	 * 1. Get the mode selected then build the array of new data to fill the table.
	 * 2. update the table accordingly.
	 * 
	 */
	private void updateRecord() {
		
		//Create data or get data from a database source.
		Object[][] updatedata = {
				{new Integer(100), "Kathy", "Smith", new Integer(3), new Integer(12),new Integer(1973),"Male" },
		        {new Integer(101), "John", "Doe", new Integer(3), new Integer(12),new Integer(1973),"Male" },
		        {new Integer(102), "Sue", "Black",  new Integer(3), new Integer(12),new Integer(1973),"Male" },
		        {new Integer(103), "Jane", "White", new Integer(3), new Integer(12),new Integer(1973),"Male" },
		        {new Integer(1111), "Joe", "Brown",  new Integer(3), new Integer(12),new Integer(1973),"Male" },
		        {new Integer(105), "Moe", "Vaughn",  new Integer(30), new Integer(102),new Integer(1983),"Male" },
		        };

		fillStudentTable(updatedata);
		
	}
	
	/**
	 * Generic method that deletes and fill a table with new data
	 * if data is empty, deletes the table only
	 * otherwise replaces the data with new one
	 * */
	private void fillStudentTable(Object[][] data ) {

		num_cols = 6;
		
		int numStudents = data.length;
		//int num_of_rows_now = table1.getRowCount(); 
		
		// remove all row from table
        if (table1.getRowCount() > 0) {
            for (int i = table1.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        
		//DefaultTableModel dm = (DefaultTableModel)table.getModel();
		//dm.getDataVector().removeAllElements();
		//dm.fireTableDataChanged(); // notifies the JTable that the model has changed
		
		for (int r=0; r < numStudents; r++) {

			//for (int c=0; c < num_cols; c++) {
				//table.getModel().setValueAt(null, r, c); //delete
				//table1.getModel().setValueAt(data[r][c], r, c); //input new data
				model.addRow(new Object[]{data[r][0], data[r][1],data[r][2],data[r][3], data[r][4],data[r][5],data[r][6]});
				
			//}
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  {
		frmSchoolPortal = new JFrame();
		frmSchoolPortal.setTitle("XYZ Records Portal");
		frmSchoolPortal.setBounds(100, 100, 1000, 808);
		frmSchoolPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Date 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        
		txtTodaysDate = new JTextField();
		txtTodaysDate.setText(formatDateTime);
		txtTodaysDate.setColumns(10);
		
		 Object[][] data = {
			        {new Integer(100), "Kathy", "Smith", new Integer(3), new Integer(12),new Integer(1973),"Male" },
			        {new Integer(101), "John", "Doe", new Integer(3), new Integer(12),new Integer(1973),"Male" },
			        {new Integer(102), "Sue", "Black",  new Integer(3), new Integer(12),new Integer(1973),"Male" },
			        {new Integer(103), "Jane", "White", new Integer(3), new Integer(12),new Integer(1973),"Male" },
			        {new Integer(104), "Joe", "Brown",  new Integer(3), new Integer(12),new Integer(1973),"Male" }
			        };
		 
		//Create the table 
		table1 = new JTable();
		table1.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table1.setFillsViewportHeight(true);
	 				 
		//set columns of the table
		 model = new DefaultTableModel();
         table1.setModel(model);
         model.addColumn("Id");
         model.addColumn("First Name");
         model.addColumn("Last Name");
         model.addColumn("B-month");
         model.addColumn("B-day");
         model.addColumn("B-year");
         model.addColumn("Gender");
         
         fillStudentTable(data);
        
		String[] QuarterStrings = { " Q1 ", " Q2 ", " Summer Q3 ", " Q4 "};		
		String[] SectionsStrings = { "100-101", "100-102", "200-101", "200-501"};
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala 2.jpg"));
		
		JLabel lblUser = new JLabel("User");
		
		txtJess = new JTextField();
		txtJess.setText("Jess");
		txtJess.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level");
		
		txtDeveloper = new JTextField();
		txtDeveloper.setText("Admin");
		txtDeveloper.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		
		JButton btnConfig = new JButton("Config");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        
		GroupLayout groupLayout = new GroupLayout(frmSchoolPortal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(txtTodaysDate, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUser)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtJess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblLevel)
										.addGap(29)
										.addComponent(txtDeveloper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
							.addGap(54)))
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
					.addGap(347))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTodaysDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(142)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtJess, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUser))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDeveloper, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLevel))
					.addGap(108)
					.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
					.addGap(77))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Demo1", null, panel, null);
		
		//table = new JTable(data, columnNames);
		//table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//table.setFillsViewportHeight(true);
		
		//Create JScrollpane, add table to it
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setViewportBorder(new LineBorder(Color.GREEN, 2));
		
		textField_1 = new JTextField();
		textField_1.setText("2018");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Year");
		JComboBox quarter_comboBox = new JComboBox(QuarterStrings);
		JComboBox section_comboBox = new JComboBox(SectionsStrings);
		
		JButton btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRecord();
			}
		});
		
		JLabel lblSection = new JLabel("Section");
		
				JLabel lblQuater = new JLabel("Quarter");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(lblQuater, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(98)
							.addComponent(lblSection))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnUpdateRecord)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuater)
						.addComponent(lblSection)
						.addComponent(lblNewLabel))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateRecord))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Demo2", null, panel_1, null);
		frmSchoolPortal.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmSchoolPortal.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
	}
}
