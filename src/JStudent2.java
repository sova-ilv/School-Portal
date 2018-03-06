
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

public class JStudent2 {

	private JFrame frmSchoolPortal;
	private JTextField textField_1;
	private JTextField txtTodaysDate;
	private JTable table;

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

	private void updateRecord() {
		Object[][] updatedata = {
		        {"Beverly", "Smith","Fun", new Integer(50), new Boolean(false)},
		        {"John", "Doe", "Notfun", new Integer(30), new Boolean(true)},
		        {"Noah", "Black", "Farmer", new Integer(20), new Boolean(false)},
		        {"Juaqim", "White","Fisher", new Integer(45), new Boolean(true)},
		        {"James", "Brown", "Runner", new Integer(48), new Boolean(false)},
		        {"Samuel", "Lorenzo", "Actor", new Integer(48), new Boolean(false)}
		        };
		
		 table.setValueAt(Object aValue,
                 int rowIndex,
                 int columnIndex);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSchoolPortal = new JFrame();
		frmSchoolPortal.setTitle("XYZ Records Portal");
		frmSchoolPortal.setBounds(100, 100, 727, 625);
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

		 Object[][] data = {
			        {"Kathy", "Smith","Snowboarding", new Integer(5), new Boolean(false)},
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
		
		String[] QuarterStrings = { " Q1 ", " Q2 ", " Summer Q3 ", " Q4 "};
		JComboBox quarter_comboBox = new JComboBox(QuarterStrings);
		
		String[] SectionsStrings = { "100-101", "100-102", "200-101", "200-501"};
		JComboBox section_comboBox = new JComboBox(SectionsStrings);
		
		JLabel lblSection = new JLabel("Section");
		
		JButton btnUpdateRecord = new JButton("Update Record");

        
		GroupLayout groupLayout = new GroupLayout(frmSchoolPortal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(lblQuater)
							.addGap(102)
							.addComponent(lblSection))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtTodaysDate)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(btnUpdateRecord)))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtTodaysDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuater, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSection, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(quarter_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(section_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateRecord))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		frmSchoolPortal.getContentPane().setLayout(groupLayout);
	}
}
