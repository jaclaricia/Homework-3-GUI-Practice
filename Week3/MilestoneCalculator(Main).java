package Week3;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class MilestoneCalculator {

	private JFrame frmLaboratory;
	private JTextField txtMilestone1;
	private JTextField txtMilestone2;
	private JTextField txtMilestone3;
	private JTextField txtFinalGrade;
	private JTextField txtStudentName;
	private JTextField txtStudentNo;
	private JTextField txtGWA;
	private Object ComputeButton;
	private JTextField txtTerm;
	private JTextField txtSchoolYear;
	private JTextField txtStatus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MilestoneCalculator window = new MilestoneCalculator();
					window.frmLaboratory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MilestoneCalculator() {
		initialize();
		
		//Computes the grade by calling methods in Computation Class
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Initializing Computation Class
				Computation comp = new Computation();
				
				//Set
				comp.setMilestone1(Integer.parseInt(txtMilestone1.getText()));
				comp.setMilestone2(Integer.parseInt(txtMilestone2.getText()));
				comp.setMilestone3(Integer.parseInt(txtMilestone3.getText()));
				
				//Get
				int milestone1 = comp.getMilestone1();
				int milestone2 = comp.getMilestone2();
				int milestone3 = comp.getMilestone3();
				
				//Conditional statements for milestone grades inputs
				if(milestone1 <=0 || milestone1 >25) {
					JOptionPane.showMessageDialog(null, "Milestone 1 score must not exceed 25 and less than 0.");
				}else if (milestone2 <= 0 || milestone2 > 40) {
		            		JOptionPane.showMessageDialog(null, "Milestone 2 score must not exceed 40 and less than 0.");
		       		}else if (milestone3 <= 0 || milestone3 > 35) {
		           		JOptionPane.showMessageDialog(null, "Milestone 3 score must not exceed 35 and less than 0.");
		        	}else{	        	
		        	
		        	//Calls the Compute Method in Computation Class
		        	int finalGrade = comp.Compute(milestone1, milestone2, milestone3);
		        	txtFinalGrade.setText(Integer.toString(finalGrade));
		        	
		        	//Calls the GWA method in Computation Class
		        	double gwa = comp.GWA(finalGrade);
		        	txtGWA.setText(Double.toString(gwa));
		        	
		        	//Calls the Status method in Computation Class
		        	String status = comp.Status(gwa);
		        	txtStatus.setText(status); 	
				}
			}
		});
		
		//Creates textfile in local directory to save the result, using the methods on Student class as well
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Requiring Textfields to have an input
					if(txtStudentName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter a Student Name.");
					}else if(txtStudentNo.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter a Student Number.");
					}else if(txtSchoolYear.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter School Year");
					}else if(txtTerm.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter Term.");
					}else if(txtMilestone1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Milestone 1 Grade Invalid.");
					}else if(txtMilestone2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Milestone 2 Grade Invalid.");
					}else if(txtMilestone3.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Milestone 3 Grade Invalid.");
					}else {
						
						//Initializing Classes
						Student stud = new Student();
						Computation comp = new Computation();
						
						//Set Student Information
						stud.setStudentName(txtStudentName.getText());
						stud.setStudentNo(Integer.parseInt(txtStudentNo.getText()));
						stud.setSchoolYear(Integer.parseInt(txtSchoolYear.getText()));
						stud.setTerm(Integer.parseInt(txtTerm.getText()));
						
						//Set Milestone Grades
						comp.setMilestone1(Integer.parseInt(txtMilestone1.getText()));
						comp.setMilestone2(Integer.parseInt(txtMilestone2.getText()));
						comp.setMilestone3(Integer.parseInt(txtMilestone3.getText()));
						
						//Get Student Information
						String studentName = stud.getStudentName();
						int studentNo= stud.getStudentNo();
						int schoolYear = stud.getSchoolYear();
						int term = stud.getTerm();
						
						//Get Milestone Grades
						int milestone1 = comp.getMilestone1();
						int milestone2 = comp.getMilestone2();
						int milestone3 = comp.getMilestone3();
				
						//Calling the Compute method from Computation Class
						int finalGrade = comp.Compute(milestone1, milestone2, milestone3);
						double gwa = comp.GWA(finalGrade);
						
						//Calling the Status method from Computation Class
						String status = comp.Status(gwa);
				
						//Writing a file with contents from the Student Class and Computation Class
						try {
							BufferedWriter writer = new BufferedWriter(
									new FileWriter("C:\\Users\\clari\\Documents\\MMDC\\1st - 3rd Term\\Computer Programming 2\\Laboratory #3 - Milestone Calculator\\Save.txt", true));
							writer.write("\n");
							writer.write("Student Name: " + studentName + "\n");
							writer.write("Student No.: " + studentNo + "\n");
							writer.write("Milestone 1: " + milestone1 + "%" + "\n");
							writer.write("Milestone 2: " + milestone2 + "%" + "\n");
							writer.write("Milestone 3: " + milestone3 + "%" + "\n");
							writer.write("Final Grade: " + finalGrade + "%" + "\n");
							writer.write("GWA: " + gwa + "\n");
							writer.write("Status: " + status + "\n");
							writer.write("------------------");
							writer.close();
						}catch (Exception ex) {
							ex.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Saved");
					}
				}
		});
		btnSave.setBounds(10, 499, 173, 23);
		frmLaboratory.getContentPane().add(btnSave);
		
		//Reset the all textfields
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStudentName.setText("");
				txtStudentNo.setText("");
				txtSchoolYear.setText("");
				txtTerm.setText("");
				txtMilestone1.setText("");
				txtMilestone2.setText("");
				txtMilestone3.setText("");
				txtFinalGrade.setText("");
				txtGWA.setText("");
				txtStatus.setText("");
			}
		});	
		
		btnReset.setBounds(10, 451, 87, 44);
		frmLaboratory.getContentPane().add(btnReset);
		
		btnCompute.setBounds(97, 451, 86, 44);
		frmLaboratory.getContentPane().add(btnCompute);
		
		JLabel lblGWA = new JLabel("GWA");
		lblGWA.setBounds(10, 392, 46, 14);
		frmLaboratory.getContentPane().add(lblGWA);
		
		txtGWA = new JTextField();
		txtGWA.setBounds(97, 389, 86, 20);
		frmLaboratory.getContentPane().add(txtGWA);
		txtGWA.setColumns(10);
		txtGWA.setEditable(false);
		
		JLabel lblSchoolYear = new JLabel("School Year");
		lblSchoolYear.setBounds(10, 159, 76, 14);
		frmLaboratory.getContentPane().add(lblSchoolYear);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(10, 190, 46, 14);
		frmLaboratory.getContentPane().add(lblTerm);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 417, 46, 14);
		frmLaboratory.getContentPane().add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(97, 414, 86, 20);
		frmLaboratory.getContentPane().add(txtStatus);
		txtStatus.setColumns(10);
		txtStatus.setEditable(false);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLaboratory = new JFrame();
		frmLaboratory.setTitle("Laboratory #3 - MIlestone Calculator - Claricia, J. A.");
		frmLaboratory.setBounds(100, 100, 212, 572);
		frmLaboratory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaboratory.getContentPane().setLayout(null);
		
		JLabel lblMilestoneCalc = new JLabel("Milestone Calculator");
		lblMilestoneCalc.setBounds(10, 11, 134, 14);
		frmLaboratory.getContentPane().add(lblMilestoneCalc);
		
		JLabel lblMilestone1 = new JLabel("Milestone 1");
		lblMilestone1.setBounds(10, 237, 65, 14);
		frmLaboratory.getContentPane().add(lblMilestone1);
		
		JLabel lblMilestone2 = new JLabel("Milestone 2");
		lblMilestone2.setBounds(10, 278, 65, 14);
		frmLaboratory.getContentPane().add(lblMilestone2);
		
		JLabel lblMilestone3 = new JLabel("Milestone 3");
		lblMilestone3.setBounds(10, 316, 65, 14);
		frmLaboratory.getContentPane().add(lblMilestone3);
			
		JLabel lblFinalGrade = new JLabel("Final Grade");
		lblFinalGrade.setBounds(10, 365, 65, 14);
		frmLaboratory.getContentPane().add(lblFinalGrade);
			
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 344, 195, 15);
		frmLaboratory.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 36, 195, 15);
		frmLaboratory.getContentPane().add(separator_1);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 49, 107, 14);
		frmLaboratory.getContentPane().add(lblStudentName);
		
		JLabel lblStudentNo = new JLabel("Student Number");
		lblStudentNo.setBounds(10, 103, 118, 14);
		frmLaboratory.getContentPane().add(lblStudentNo);
			
		//Textfield required input
		//Textfields that ask user to input a "String" type data must be strictly string, if not, textfield will just consume the key pressed
		txtStudentName = new JTextField();
		txtStudentName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c) || c == ' ') {
				}else e.consume();
			}
		});
		
		txtStudentName.setBounds(10, 72, 173, 20);
		frmLaboratory.getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtStudentNo = new JTextField();
		txtStudentNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtStudentNo.setColumns(10);
		txtStudentNo.setBounds(10, 123, 173, 20);
		frmLaboratory.getContentPane().add(txtStudentNo);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtSchoolYear = new JTextField();
		txtSchoolYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtSchoolYear.setBounds(97, 156, 86, 20);
		frmLaboratory.getContentPane().add(txtSchoolYear);
		txtSchoolYear.setColumns(10);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtTerm = new JTextField();
		txtTerm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtTerm.setBounds(97, 187, 86, 20);
		frmLaboratory.getContentPane().add(txtTerm);
		txtTerm.setColumns(10);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtMilestone1 = new JTextField();
		txtMilestone1.setForeground(Color.BLACK);
		txtMilestone1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtMilestone1.setBounds(97, 234, 86, 20);
		frmLaboratory.getContentPane().add(txtMilestone1);
		txtMilestone1.setColumns(10);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtMilestone2 = new JTextField();
		txtMilestone2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtMilestone2.setBounds(97, 275, 86, 20);
		frmLaboratory.getContentPane().add(txtMilestone2);
		txtMilestone2.setColumns(10);
		
		//Textfields that ask user to input a "int" type data must be strictly int, if not, textfield will just consume the key pressed
		txtMilestone3 = new JTextField();
		txtMilestone3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c)) {
				}else e.consume();
			}
		});
		
		txtMilestone3.setBounds(97, 313, 86, 20);
		frmLaboratory.getContentPane().add(txtMilestone3);
		txtMilestone3.setColumns(10);
		
		txtFinalGrade = new JTextField();
		txtFinalGrade.setBounds(97, 362, 86, 20);
		frmLaboratory.getContentPane().add(txtFinalGrade);
		txtFinalGrade.setColumns(10);
		txtFinalGrade.setEditable(false);
			
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 223, 195, 15);
		frmLaboratory.getContentPane().add(separator_1_1);
	}
}
