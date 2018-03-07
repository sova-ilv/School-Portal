
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
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class JStudent2 {

	private JFrame frmSchoolPortal;
	private JTextField textField_1;
	private JTextField txtTodaysDate;
	private JTable table;
	private int num_rows = 5;
	private int num_cols = 5;
	private JTextField txtJess;
	private JTextField txtDeveloper;
	private JTextField textField;

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
		Object[][] updatedata = {
		        {"Beverly", "Smith","Fun", new Integer(50), new Boolean(false)},
		        {"John", "Doe", "Notfun", new Integer(30), new Boolean(true)},
		        {"Noah", "Black", "Farmer", new Integer(20), new Boolean(false)},
		        {"Juaqim", "White","Fisher", new Integer(45), new Boolean(true)},
		        {"James", "Brown", "Runner", new Integer(48), new Boolean(false)},
		        {"Samuel", "Lorenzo", "Actor", new Integer(48), new Boolean(false)}
		        };
		
		//table.getModel().setValueAt(null, 1, 1); //this code works
		 //table.setValueAt(Object aValue, int rowIndex, int columnIndex);
		
		for (int r=0; r < num_rows; r++) {
			for (int c=0; c < num_cols; c++) {
				table.getModel().setValueAt(null, r, c); //delete
				table.getModel().setValueAt(updatedata[r][c], r, c); //input new data
			}
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSchoolPortal = new JFrame();
		frmSchoolPortal.setTitle("XYZ Records Portal");
		frmSchoolPortal.setBounds(100, 100, 937, 708);
		frmSchoolPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField_1 = new JTextField();
		textField_1.setText("2018");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Year");

		//Date 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        
		txtTodaysDate = new JTextField();
		txtTodaysDate.setText(formatDateTime);
		txtTodaysDate.setColumns(10);
					
		 String[] columnNames = {"First Name",
                 "Last Name",
                 "Sport",
                 "# of Years",
                 "Vegetarian"};

		 int v1 = 311; 
		 Object[][] data = {
			        {"Kathy", "Smith","Snowboarding", new Integer(v1), new Boolean(false)},
			        {"John", "Doe", "Rowing", new Integer(3), new Boolean(true)},
			        {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
			        {"Jane", "White","Speed reading", new Integer(20), new Boolean(true)},
			        {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
			        };
		 
		 table = new JTable(data, columnNames);
	         table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	         table.setFillsViewportHeight(true);

		JLabel lblQuater = new JLabel("Quarter");
		
		//Create JScrollpane, add table to it
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new LineBorder(Color.GREEN, 2));
		
		String[] QuarterStrings = { " Q1 ", " Q2 ", " Summer Q3 ", " Q4 "};
		JComboBox quarter_comboBox = new JComboBox(QuarterStrings);
		
		String[] SectionsStrings = { "100-101", "100-102", "200-101", "200-501"};
		JComboBox section_comboBox = new JComboBox(SectionsStrings);
		
		JLabel lblSection = new JLabel("Section");
		
		JButton btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateRecord();
			}
		});
		
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

        
		GroupLayout groupLayout = new GroupLayout(frmSchoolPortal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTodaysDate, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
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
									.addGap(44)))))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(53)
									.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(btnUpdateRecord))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(75)
									.addComponent(lblQuater)
									.addGap(133)
									.addComponent(lblSection)))
							.addGap(478))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
							.addGap(451))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTodaysDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(107)
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
							.addGap(33)
							.addComponent(btnConfig, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblQuater, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSection, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdateRecord))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		frmSchoolPortal.getContentPane().setLayout(groupLayout);
	}
}
