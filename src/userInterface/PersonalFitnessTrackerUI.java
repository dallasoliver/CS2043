package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

public class PersonalFitnessTrackerUI extends JFrame {

	private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	private JPanel contentPane;
	private JTextField tfCardioActivityName;
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
	private JXDatePicker datePickerStrength;
	private JSpinner timeSpentHoursSpinner;
	private JLabel lblHours;
	private JSpinner timeSpentMinsSpinner;
	private JLabel lblMinutes;
	private JSpinner weightLiftedSpinner;
	private JSpinner repsSpinner;

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
		setBounds(100, 100, 580, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setForeground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 562, 380);
		contentPane.add(tabbedPane);
		
		tabbedPane1 = new JPanel();
		tabbedPane1.setBorder(emptyBorder);
		tabbedPane1.setBackground(new Color(211, 211, 211));
		tabbedPane.addTab("Enter Workout Information", null, tabbedPane1, null);
		tabbedPane1.setLayout(null);
		
		tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBackground(new Color(211, 211, 211));
		tabbedPane2.setBounds(6, 5, 529, 323);
		tabbedPane2.setBorder(emptyBorder);
		tabbedPane1.add(tabbedPane2);
		
		cardioMainPanel = new JPanel();
		cardioMainPanel.setBackground(new Color(204, 204, 204));
		cardioMainPanel.setBorder(emptyBorder);
		tabbedPane2.addTab("...for a cardio workout", null, cardioMainPanel, null);
		cardioMainPanel.setLayout(null);
		
		cardioPaneTitle = new JLabel("To save your cardio session details, enter the following information.");
		cardioPaneTitle.setForeground(Color.DARK_GRAY);
		cardioPaneTitle.setFont(new Font("Osaka", Font.BOLD, 15));
		cardioPaneTitle.setBounds(6, 6, 496, 16);
		cardioMainPanel.add(cardioPaneTitle);
		
		lblCardioActivityName = new JLabel("Activity Name");
		lblCardioActivityName.setFont(new Font("Sathu", Font.BOLD, 20));
		lblCardioActivityName.setForeground(new Color(224, 255, 255));
		lblCardioActivityName.setBounds(85, 49, 161, 29);
		cardioMainPanel.add(lblCardioActivityName);
		
		lblTimeSpent = new JLabel("Time Spent");
		lblTimeSpent.setForeground(new Color(224, 255, 255));
		lblTimeSpent.setFont(new Font("Sathu", Font.BOLD, 20));
		lblTimeSpent.setBounds(85, 135, 136, 29);
		cardioMainPanel.add(lblTimeSpent);
		
		lblDateCardio = new JLabel("Date");
		lblDateCardio.setForeground(new Color(224, 255, 255));
		lblDateCardio.setFont(new Font("Sathu", Font.BOLD, 20));
		lblDateCardio.setBounds(85, 90, 162, 28);
		cardioMainPanel.add(lblDateCardio);
		
		tfCardioActivityName = new JTextField();
		tfCardioActivityName.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfCardioActivityName.setBackground(new Color(255, 255, 255));
		tfCardioActivityName.setBounds(258, 50, 162, 28);
		cardioMainPanel.add(tfCardioActivityName);
		tfCardioActivityName.setColumns(10);
		
		btnSaveCardio = new JButton("Save Session Details");
		btnSaveCardio.setForeground(new Color(119, 136, 153));
		btnSaveCardio.setBackground(new Color(0, 0, 0));
		btnSaveCardio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfCardioActivityName.getText();
				Integer hours = (Integer) timeSpentHoursSpinner.getValue();
				Integer minutes = (Integer) timeSpentHoursSpinner.getValue();
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
		        if(hours == null && minutes == null){
		            JOptionPane.showMessageDialog(cardioMainPanel, "You must enter the time spent to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(dateSelected == null){
		            JOptionPane.showMessageDialog(cardioMainPanel, "You must enter a date to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
			}
		});
		
		btnSaveCardio.setBounds(165, 201, 176, 35);
		cardioMainPanel.add(btnSaveCardio);
		
		datePickerCardio = new JXDatePicker();
		datePickerCardio.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePickerCardio.setBounds(259, 91, 187, 28);
		cardioMainPanel.add(datePickerCardio);
		
		timeSpentHoursSpinner = new JSpinner();
		timeSpentHoursSpinner.setName("");
		timeSpentHoursSpinner.setBounds(258, 136, 37, 28);
		cardioMainPanel.add(timeSpentHoursSpinner);
		
		lblHours = new JLabel("Hours");
		lblHours.setForeground(Color.DARK_GRAY);
		lblHours.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblHours.setBounds(297, 143, 61, 16);
		cardioMainPanel.add(lblHours);
		
		timeSpentMinsSpinner = new JSpinner();
		timeSpentMinsSpinner.setBounds(343, 136, 37, 28);
		cardioMainPanel.add(timeSpentMinsSpinner);
		
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setForeground(Color.DARK_GRAY);
		lblMinutes.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblMinutes.setBounds(385, 143, 61, 16);
		cardioMainPanel.add(lblMinutes);
		
		strengthMainPanel = new JPanel();
		strengthMainPanel.setBorder(emptyBorder);
		strengthMainPanel.setBackground(new Color(204, 204, 204));
		tabbedPane2.addTab("...for a strength training workout", null, strengthMainPanel, null);
		strengthMainPanel.setLayout(null);
		
		JLabel lblToSaveYour = new JLabel("To save your strength training session details, enter the following information.");
		lblToSaveYour.setForeground(new Color(112, 128, 144));
		lblToSaveYour.setFont(new Font("Osaka", Font.BOLD, 15));
		lblToSaveYour.setBounds(6, 12, 496, 16);
		strengthMainPanel.add(lblToSaveYour);
		
		lblStrengthActivityName = new JLabel("Activity Name");
		lblStrengthActivityName.setForeground(new Color(224, 255, 255));
		lblStrengthActivityName.setFont(new Font("Sathu", Font.BOLD, 20));
		lblStrengthActivityName.setBounds(50, 43, 176, 35);
		strengthMainPanel.add(lblStrengthActivityName);
		
		lblRepetitions = new JLabel("Repetitions");
		lblRepetitions.setFont(new Font("Sathu", Font.BOLD, 20));
		lblRepetitions.setForeground(new Color(224, 255, 255));
		lblRepetitions.setBounds(50, 155, 145, 25);
		strengthMainPanel.add(lblRepetitions);
		
		lblWeightLifted = new JLabel("Weight Lifted");
		lblWeightLifted.setForeground(new Color(224, 255, 255));
		lblWeightLifted.setFont(new Font("Sathu", Font.BOLD, 20));
		lblWeightLifted.setBounds(50, 118, 145, 25);
		strengthMainPanel.add(lblWeightLifted);
		
		lblDateStrength = new JLabel("Date");
		lblDateStrength.setForeground(new Color(224, 255, 255));
		lblDateStrength.setFont(new Font("Sathu", Font.BOLD, 20));
		lblDateStrength.setBounds(50, 81, 78, 25);
		strengthMainPanel.add(lblDateStrength);
		
		tfStrengthActivityName = new JTextField();
		tfStrengthActivityName.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfStrengthActivityName.setBounds(228, 47, 162, 28);
		strengthMainPanel.add(tfStrengthActivityName);
		tfStrengthActivityName.setColumns(10);
		
		datePickerStrength = new JXDatePicker();
		datePickerStrength.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePickerStrength.setBounds(228, 80, 187, 28);
		strengthMainPanel.add(datePickerStrength);
		
		JButton btnSave = new JButton("Save Session Details");
		btnSave.setBorder(UIManager.getBorder("Button.border"));
		btnSave.setForeground(new Color(119, 136, 153));
		btnSave.setFont(new Font("Osaka", Font.BOLD, 14));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfStrengthActivityName.getText();
		        Integer reps = (Integer)repsSpinner.getValue();
		        Integer weight = (Integer) weightLiftedSpinner.getValue(); 
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
		        if(reps == null){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter the repititions to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(weight == null){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter the weight lifted to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
		        if(dateSelected == null){
		            JOptionPane.showMessageDialog(strengthMainPanel, "You must enter a date to save your workout details.", "Error", JOptionPane.ERROR_MESSAGE); 
		        }
			}
		});
		btnSave.setBounds(166, 210, 176, 35);
		strengthMainPanel.add(btnSave);
		
		weightLiftedSpinner = new JSpinner();
		weightLiftedSpinner.setBounds(228, 117, 53, 28);
		weightLiftedSpinner.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		strengthMainPanel.add(weightLiftedSpinner);
		
		repsSpinner = new JSpinner();
		repsSpinner.setBounds(228, 154, 53, 28);
		strengthMainPanel.add(repsSpinner);
		
		JLabel lblLbs = new JLabel("lbs");
		lblLbs.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblLbs.setForeground(new Color(112, 128, 144));
		lblLbs.setBounds(288, 124, 61, 16);
		strengthMainPanel.add(lblLbs);
		
		
		compareWorkoutsPanel = new JPanel();
		tabbedPane.addTab("Compare Workout Details", null, compareWorkoutsPanel, null);
	}
}
