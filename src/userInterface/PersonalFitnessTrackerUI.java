package userInterface;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.Font;

public class PersonalFitnessTrackerUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfCardioActivityName;
	private JTextField tfTimeSpent;
	private JTabbedPane tabbedPane;
	private JPanel tabbedPane1;
	private JTabbedPane tabbedPane2;
	private JPanel cardioMainPanel;
	private JLabel cardioPaneTitle;
	private JLabel lblCardioActivityName;
	private JLabel lblTimeSpent;
	private JLabel lblDateCardio;
	private JButton btnSaveCardio;
	private JXDatePicker datePickerCardio;
	private JPanel strengthMainPanel;
	private JPanel compareWorkoutsPanel;
	private JLabel lblStrengthActivityName;
	private JLabel lblRepetitions;
	private JLabel lblWeightLifted;
	private JLabel lblDateStrength;
	private JTextField tfStrengthActivityName;
	private JTextField tfReps;
	private JTextField tfWeightLifted;
	private JXDatePicker datePickerStrength;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalFitnessTrackerUI frame = new PersonalFitnessTrackerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonalFitnessTrackerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 562, 323);
		contentPane.add(tabbedPane);
		
		tabbedPane1 = new JPanel();
		tabbedPane.addTab("Enter Workout Information", null, tabbedPane1, null);
		tabbedPane1.setLayout(null);
		
		tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBounds(6, 5, 529, 266);
		tabbedPane1.add(tabbedPane2);
		
		cardioMainPanel = new JPanel();
		tabbedPane2.addTab("...for a cardio workout", null, cardioMainPanel, null);
		cardioMainPanel.setLayout(null);
		
		cardioPaneTitle = new JLabel("To save your cardio session details, enter the following information.");
		cardioPaneTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		cardioPaneTitle.setBounds(44, 6, 430, 16);
		cardioMainPanel.add(cardioPaneTitle);
		
		lblCardioActivityName = new JLabel("Activity Name:");
		lblCardioActivityName.setBounds(6, 34, 111, 16);
		cardioMainPanel.add(lblCardioActivityName);
		
		lblTimeSpent = new JLabel("Time Spent: ");
		lblTimeSpent.setBounds(6, 62, 93, 16);
		cardioMainPanel.add(lblTimeSpent);
		
		lblDateCardio = new JLabel("Date:");
		lblDateCardio.setBounds(6, 90, 61, 16);
		cardioMainPanel.add(lblDateCardio);
		
		tfCardioActivityName = new JTextField();
		tfCardioActivityName.setBounds(105, 28, 134, 28);
		cardioMainPanel.add(tfCardioActivityName);
		tfCardioActivityName.setColumns(10);
		
		tfTimeSpent = new JTextField();
		tfTimeSpent.setBounds(84, 56, 134, 28);
		cardioMainPanel.add(tfTimeSpent);
		tfTimeSpent.setColumns(10);
		
		btnSaveCardio = new JButton("Save");
		btnSaveCardio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfCardioActivityName.getText();
		        String time = tfTimeSpent.getText();
		        Date dateSelected = datePickerCardio.getDate();
		        Date now = new Date();
		        long ctime = System.currentTimeMillis();
		        now.setTime(ctime);
		        //String date = jXDatePicker1.getDate().toString();
		        if (dateSelected != null){
		            boolean dateForm = dateSelected.before(now);
		            if(!dateForm){
		                JOptionPane.showMessageDialog(cardioMainPanel, "You must enter a date on or before today to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		            } 
		        }
		        
		        if (name.isEmpty()){
		            JOptionPane.showMessageDialog(cardioMainPanel, "You must enter an activity name to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        if(time.isEmpty()){
		            JOptionPane.showMessageDialog(cardioMainPanel, "You must enter the time spent to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(dateSelected == null){
		            JOptionPane.showMessageDialog(cardioMainPanel, "You must enter a date to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
			}
		});
		
		btnSaveCardio.setBounds(163, 174, 117, 29);
		cardioMainPanel.add(btnSaveCardio);
		
		datePickerCardio = new JXDatePicker();
		datePickerCardio.setBounds(51, 84, 151, 28);
		cardioMainPanel.add(datePickerCardio);
		
		strengthMainPanel = new JPanel();
		tabbedPane2.addTab("...for a strength training workout", null, strengthMainPanel, null);
		strengthMainPanel.setLayout(null);
		
		JLabel lblToSaveYour = new JLabel("To save your strength training session details, enter the following information.");
		lblToSaveYour.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblToSaveYour.setBounds(24, 6, 462, 16);
		strengthMainPanel.add(lblToSaveYour);
		
		lblStrengthActivityName = new JLabel("Activity Name:");
		lblStrengthActivityName.setBounds(6, 34, 101, 16);
		strengthMainPanel.add(lblStrengthActivityName);
		
		lblRepetitions = new JLabel("Repetitions: ");
		lblRepetitions.setBounds(6, 62, 90, 16);
		strengthMainPanel.add(lblRepetitions);
		
		lblWeightLifted = new JLabel("Weight Lifted: ");
		lblWeightLifted.setBounds(6, 90, 101, 16);
		strengthMainPanel.add(lblWeightLifted);
		
		lblDateStrength = new JLabel("Date:");
		lblDateStrength.setBounds(6, 118, 61, 16);
		strengthMainPanel.add(lblDateStrength);
		
		tfStrengthActivityName = new JTextField();
		tfStrengthActivityName.setBounds(105, 28, 134, 28);
		strengthMainPanel.add(tfStrengthActivityName);
		tfStrengthActivityName.setColumns(10);
		
		tfReps = new JTextField();
		tfReps.setBounds(91, 56, 134, 28);
		strengthMainPanel.add(tfReps);
		tfReps.setColumns(10);
		
		tfWeightLifted = new JTextField();
		tfWeightLifted.setBounds(105, 84, 134, 28);
		strengthMainPanel.add(tfWeightLifted);
		tfWeightLifted.setColumns(10);
		
		datePickerStrength = new JXDatePicker();
		datePickerStrength.setBounds(50, 112, 151, 28);
		strengthMainPanel.add(datePickerStrength);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfStrengthActivityName.getText();
		        String reps = tfReps.getText();
		        String weight = tfWeightLifted.getText(); 
		        Date dateSelected = datePickerStrength.getDate();
		        Date now = new Date();
		        long ctime = System.currentTimeMillis();
		        now.setTime(ctime);
		        if (dateSelected != null){
		            boolean dateForm = dateSelected.before(now);
		            if(!dateForm){
		                JOptionPane.showMessageDialog(strengthMainPanel, "You must enter a date on or before today to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		            } 
		        }
		        
		        if (name.isEmpty()){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter an activity name to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        if(reps.isEmpty()){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter the repititions to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(weight.isEmpty()){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter the weight lifted to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(dateSelected == null){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter a date to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
			}
		});
		btnSave.setBounds(199, 167, 117, 29);
		strengthMainPanel.add(btnSave);
		
		compareWorkoutsPanel = new JPanel();
		tabbedPane.addTab("Compare Workout Details", null, compareWorkoutsPanel, null);
	}
}
