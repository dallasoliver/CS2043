package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalFitnessTrackerUI extends JFrame {

	private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	private Image imgStrengthLarge = new ImageIcon(PersonalFitnessTrackerUI.class.getResource("/weight2ICON.png")).getImage();
	private Icon iconStrengthLarge = new ImageIcon(imgStrengthLarge);
	private Image imgCardioLarge = new ImageIcon(PersonalFitnessTrackerUI.class.getResource("/cardio2icon.png")).getImage();
	private Icon iconCardioLarge = new ImageIcon(imgCardioLarge);
	
	//private Image imgStrengthSmall = new ImageIcon(PersonalFitnessTrackerUI.class.getResource("/weight2ICON.png")).getImage();
	Image imgStrengthSmall = imgStrengthLarge.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
	private Icon iconStrengthSmall = new ImageIcon(imgStrengthSmall);
	//private Image imgCardioSmall = new ImageIcon(PersonalFitnessTrackerUI.class.getResource("/cardio2icon.png")).getImage();
	Image imgCardioSmall = imgCardioLarge.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
	private Icon iconCardioSmall = new ImageIcon(imgCardioSmall);
	
	
	
	private SpinnerModel repsModel = new SpinnerNumberModel(0, 0, 100, 1);   
	private SpinnerModel hoursModel = new SpinnerNumberModel(0, 0, 25, 1);    
	private SpinnerModel minsModel = new SpinnerNumberModel(0, 0, 59, 1);                
	private JPanel contentPane;
	private JTextField tfCardioActivityName;
	private JTabbedPane tabbedPane;
	private JPanel tabbedPane1;
	private JTabbedPane tabbedPane2;
	private JPanel cardioMainPanel;
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
	private JSpinner repsSpinner;
	private JTextField tfWeightLifted;
	private JLabel lblLbs;
	private JButton btnSaveStrength;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton btnCompareWorkouts;
	private JLabel txtrCompareInstructions;
	private JXDatePicker compareDatePicker1;
	private JXDatePicker compareDatePicker2;
	private JScrollPane compareScrollPane1;
	private JScrollPane compareScrollPane2;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(System.getProperty("os.name").contains("Linux") ||
							System.getProperty("os.name").contains("Windows")){	
						UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
					}
					else{
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
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
		setBounds(100, 100, 516, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setForeground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 502, 328);
		contentPane.add(tabbedPane);
		
		tabbedPane1 = new JPanel();
		tabbedPane1.setBorder(emptyBorder);
		tabbedPane1.setBackground(new Color(211, 211, 211));
		tabbedPane.addTab("Enter Workout Information", null, tabbedPane1, null);
		tabbedPane1.setLayout(null);
		
		tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane2.setBackground(new Color(211, 211, 211));
		tabbedPane2.setBounds(6, 0, 468, 278);
		tabbedPane2.setBorder(emptyBorder);
		tabbedPane1.add(tabbedPane2);
		
		cardioMainPanel = new JPanel();
		cardioMainPanel.setBackground(new Color(204, 204, 204));
		cardioMainPanel.setBorder(emptyBorder);
		
		strengthMainPanel = new JPanel();
		strengthMainPanel.setBorder(emptyBorder);
		strengthMainPanel.setBackground(new Color(204, 204, 204));
		tabbedPane2.addTab("...for a strength training workout", iconStrengthSmall, strengthMainPanel, null);
		strengthMainPanel.setLayout(null);
		
		lblStrengthActivityName = new JLabel("Activity Name");
		lblStrengthActivityName.setForeground(new Color(224, 255, 255));
		lblStrengthActivityName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblStrengthActivityName.setBounds(67, 17, 176, 35);
		strengthMainPanel.add(lblStrengthActivityName);
		
		lblRepetitions = new JLabel("Repetitions");
		lblRepetitions.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblRepetitions.setForeground(new Color(224, 255, 255));
		lblRepetitions.setBounds(67, 124, 145, 25);
		strengthMainPanel.add(lblRepetitions);
		
		lblWeightLifted = new JLabel("Weight Lifted");
		lblWeightLifted.setForeground(new Color(224, 255, 255));
		lblWeightLifted.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblWeightLifted.setBounds(67, 90, 145, 25);
		strengthMainPanel.add(lblWeightLifted);
		
		lblDateStrength = new JLabel("Date");
		lblDateStrength.setForeground(new Color(224, 255, 255));
		lblDateStrength.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblDateStrength.setBounds(67, 56, 78, 25);
		strengthMainPanel.add(lblDateStrength);
		
		tfStrengthActivityName = new JTextField();
		tfStrengthActivityName.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfStrengthActivityName.setBounds(226, 21, 162, 28);
		strengthMainPanel.add(tfStrengthActivityName);
		tfStrengthActivityName.setColumns(10);
		
		datePickerStrength = new JXDatePicker();
		datePickerStrength.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePickerStrength.setBounds(226, 55, 187, 28);
		strengthMainPanel.add(datePickerStrength);
		
		btnSaveStrength = new JButton("Save Session Details");
		btnSaveStrength.setBorder(UIManager.getBorder("Button.border"));
		btnSaveStrength.setForeground(new Color(105, 105, 105));
		btnSaveStrength.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnSaveStrength.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfStrengthActivityName.getText();
		        Integer reps = (Integer)repsSpinner.getValue();
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
		btnSaveStrength.setBounds(136, 174, 176, 35);
		strengthMainPanel.add(btnSaveStrength);
		
		repsSpinner = new JSpinner();
		repsSpinner.setBounds(223, 123, 53, 30);
		repsSpinner.setModel(repsModel);
		strengthMainPanel.add(repsSpinner);
		
		lblLbs = new JLabel("lbs");
		lblLbs.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblLbs.setForeground(new Color(105, 105, 105));
		lblLbs.setBounds(282, 97, 61, 16);
		strengthMainPanel.add(lblLbs);
		
		tfWeightLifted = new JTextField();
		tfWeightLifted.setColumns(10);
		tfWeightLifted.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfWeightLifted.setBounds(226, 89, 53, 28);
		strengthMainPanel.add(tfWeightLifted);
		
		tabbedPane2.addTab("...for a cardio session", iconCardioSmall, cardioMainPanel, null);
		cardioMainPanel.setLayout(null);
		
		lblCardioActivityName = new JLabel("Activity Name");
		lblCardioActivityName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblCardioActivityName.setForeground(new Color(224, 255, 255));
		lblCardioActivityName.setBounds(67, 17, 176, 35);
		cardioMainPanel.add(lblCardioActivityName);
		
		lblTimeSpent = new JLabel("Time Spent");
		lblTimeSpent.setForeground(new Color(224, 255, 255));
		lblTimeSpent.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblTimeSpent.setBounds(67, 88, 136, 29);
		cardioMainPanel.add(lblTimeSpent);
		
		lblDateCardio = new JLabel("Date");
		lblDateCardio.setForeground(new Color(224, 255, 255));
		lblDateCardio.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 22));
		lblDateCardio.setBounds(67, 54, 162, 28);
		cardioMainPanel.add(lblDateCardio);
		
		tfCardioActivityName = new JTextField();
		tfCardioActivityName.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfCardioActivityName.setBackground(new Color(255, 255, 255));
		tfCardioActivityName.setBounds(226, 21, 162, 28);
		cardioMainPanel.add(tfCardioActivityName);
		tfCardioActivityName.setColumns(10);
		
		btnSaveCardio = new JButton("Save Session Details");
		btnSaveCardio.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnSaveCardio.setForeground(new Color(105, 105, 105));
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
		
		btnSaveCardio.setBounds(136, 174, 176, 35);
		cardioMainPanel.add(btnSaveCardio);
		
		datePickerCardio = new JXDatePicker();
		datePickerCardio.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePickerCardio.setBounds(226, 55, 187, 28);
		cardioMainPanel.add(datePickerCardio);
		
		timeSpentHoursSpinner = new JSpinner();
		timeSpentHoursSpinner.setName("");
		timeSpentHoursSpinner.setBounds(200, 89, 65, 28);
		repsSpinner.setModel(hoursModel);
		cardioMainPanel.add(timeSpentHoursSpinner);
		
		lblHours = new JLabel("Hours");
		lblHours.setForeground(new Color(105, 105, 105));
		lblHours.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblHours.setBounds(257, 96, 61, 16);
		cardioMainPanel.add(lblHours);
		
		timeSpentMinsSpinner = new JSpinner();
		timeSpentMinsSpinner.setBounds(307, 89, 65, 28);
		repsSpinner.setModel(minsModel);
		cardioMainPanel.add(timeSpentMinsSpinner);
		
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setForeground(new Color(105, 105, 105));
		lblMinutes.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblMinutes.setBounds(365, 96, 61, 16);
		cardioMainPanel.add(lblMinutes);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -14, 195, 158);
		cardioMainPanel.add(lblNewLabel);
		lblNewLabel.setIcon(iconCardioLarge);
		
		label = new JLabel("");
		label.setBounds(-31, 0, 162, 167);
		label.setIcon(iconStrengthLarge);
		strengthMainPanel.add(label);
		
		compareWorkoutsPanel = new JPanel();
		compareWorkoutsPanel.setBorder(null);
		compareWorkoutsPanel.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Compare Workout Details", null, compareWorkoutsPanel, null);
		
		compareScrollPane1 = new JScrollPane ();		
		compareScrollPane1.setBorder(null);
		
		compareScrollPane2 = new JScrollPane ();		
		compareScrollPane2.setBorder(null);
		compareScrollPane2.setBackground(Color.LIGHT_GRAY);
		compareScrollPane2.setBounds(12, 97, 226, 145);
		compareScrollPane1.setBounds(261, 97, 226, 145);
		compareWorkoutsPanel.setBorder(emptyBorder);
		compareWorkoutsPanel.setLayout(null);
		compareWorkoutsPanel.add(compareScrollPane2);
		textArea2 = new JTextArea(5, 30);
		compareScrollPane2.setViewportView(textArea2);
		textArea2.setForeground(new Color(105, 105, 105));
		textArea2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		textArea2.setMaximumSize(new Dimension(200, 200));
		textArea2.setBackground(Color.WHITE);
		compareWorkoutsPanel.add(compareScrollPane1);
		
		//compareWorkoutsPanel.setLayout(null);

		textArea1 = new JTextArea(5, 30);
		compareScrollPane1.setViewportView(textArea1);
		textArea1.setForeground(new Color(105, 105, 105));
		textArea1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		textArea1.setBackground(Color.WHITE);
		
		compareDatePicker1 = new JXDatePicker();
		compareDatePicker1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date now1 = new Date();
				compareDatePicker2.setDate(now1);

			}
		});
		compareDatePicker1.setBounds(45, 65, 151, 28);
		compareWorkoutsPanel.add(compareDatePicker1);
		
		compareDatePicker2 = new JXDatePicker();
		compareDatePicker2.setBounds(294, 65, 151, 28);
		compareWorkoutsPanel.add(compareDatePicker2);
		
		txtrCompareInstructions = new JLabel();
		txtrCompareInstructions.setBackground(Color.LIGHT_GRAY);
		txtrCompareInstructions.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));

		txtrCompareInstructions.setText("<html>Choose up to two dates to compare workout sessions.<br> Your past workout details can inform you of your fitness improvements or declines.</html>");
		txtrCompareInstructions.setBounds(12, 0, 469, 62);
		compareWorkoutsPanel.add(txtrCompareInstructions);
		
		btnCompareWorkouts = new JButton("Compare ");
		btnCompareWorkouts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//textArea1.text();
			}
		});
		btnCompareWorkouts.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnCompareWorkouts.setBounds(175, 254, 150, 35);
		compareWorkoutsPanel.add(btnCompareWorkouts);
		
	}
}
