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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.JXDatePicker;

import applogic.PersonalFitnessTrackerLogic;
import javax.swing.ScrollPaneConstants;

public class PersonalFitnessTrackerUI extends JFrame {
	private String OSString;
	private Border emptyBorder;
	private Image imgStrengthLarge;
	private Icon iconStrengthLarge;
	private Image imgCardioLarge;
	private Icon iconCardioLarge;
	private Image imgStrengthSmall;
	private Icon iconStrengthSmall;
	private Image imgCardioSmall;
	private Icon iconCardioSmall;
	private Image imgCheck;
	private Image imgCheckSmall;
	private Icon iconCheck;
	private JLabel lblCheckMarkIcon;
	private JLabel lblCheck2;
	private JTextField tfHours;
	private JTextField tfMinutes;
	private JTextField tfReps;
	private JPanel contentPane;
	private JTextField tfCardioActivityName;
	private JTabbedPane tabbedPane;
	private JPanel enterWorkoutPanel;
	private JTabbedPane enterWorkoutTabbedPane;
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
	private JLabel lblHours;
	private JLabel lblMinutes;
	private JTextField tfWeightLifted;
	private JLabel lblLbs;
	private JButton btnSaveStrength;
	private JLabel lblCardioIcon;
	private JLabel lblStrengthIcon;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton btnCompareWorkouts;
	private JLabel txtrCompareInstructions;
	private JXDatePicker compareDatePicker1;
	private JXDatePicker compareDatePicker2;
	private JScrollPane compareScrollPane1;
	private JScrollPane compareScrollPane2;
	private static applogic.PersonalFitnessTrackerLogic logic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (System.getProperty("os.name").contains("Linux")
							|| System.getProperty("os.name")
									.contains("Windows")) {
						UIManager
								.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
					} else {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					}
					PersonalFitnessTrackerUI frame = new PersonalFitnessTrackerUI();
					if (System.getProperty("os.name").contains("Linux")
							|| System.getProperty("os.name")
									.contains("Windows")){
					frame.setBounds(512, 512, frame.getWidth(), frame.getHeight()+12);
					}
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("Personal Fitness Tracker");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		logic = new PersonalFitnessTrackerLogic("activities.xml");
	}

	/**
	 * Create the frame.
	 */
	public PersonalFitnessTrackerUI() {
		emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		OSString = System.getProperty("os.name");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setForeground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 362);
		setContentPane(contentPane);
		
		//Configure all imageIcons
		imgStrengthLarge = new ImageIcon(
				PersonalFitnessTrackerUI.class.getResource("/weight2ICON.png"))
				.getImage();
		iconStrengthLarge = new ImageIcon(imgStrengthLarge);
		imgCardioLarge = new ImageIcon(
				PersonalFitnessTrackerUI.class.getResource("/cardio2icon.png"))
				.getImage();
		iconCardioLarge = new ImageIcon(imgCardioLarge);
		imgStrengthSmall = imgStrengthLarge.getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH);
		iconStrengthSmall = new ImageIcon(imgStrengthSmall);
		imgCardioSmall = imgCardioLarge.getScaledInstance(20, 20,
				java.awt.Image.SCALE_SMOOTH);
		iconCardioSmall = new ImageIcon(imgCardioSmall);
		imgCheck = new ImageIcon(
					PersonalFitnessTrackerUI.class.getResource("/check2.png"))
					.getImage();
		imgCheckSmall = imgCheck.getScaledInstance(30, 30,
				java.awt.Image.SCALE_SMOOTH);
		iconCheck = new ImageIcon(imgCheckSmall);
		
		//Cardio Workout Panel
		cardioMainPanel = new JPanel();
		cardioMainPanel.setBackground(new Color(204, 204, 204));
		cardioMainPanel.setBorder(emptyBorder);
		cardioMainPanel.setLayout(null);

		lblCardioActivityName = new JLabel("Activity Name");
		lblCardioActivityName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblCardioActivityName.setForeground(new Color(224, 255, 255));
		lblCardioActivityName.setBounds(67, 17, 176, 35);
		lblTimeSpent = new JLabel("Time Spent");
		lblTimeSpent.setForeground(new Color(224, 255, 255));
		lblTimeSpent.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblTimeSpent.setBounds(67, 88, 136, 29);
		lblDateCardio = new JLabel("Date");
		lblDateCardio.setForeground(new Color(224, 255, 255));
		lblDateCardio.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblDateCardio.setBounds(67, 54, 162, 28);
		tfCardioActivityName = new JTextField();
		tfCardioActivityName.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfCardioActivityName.setBackground(new Color(255, 255, 255));
		tfCardioActivityName.setBounds(226, 21, 162, 28);
		tfCardioActivityName.setColumns(10);
		btnSaveCardio = new JButton("Save Session Details");
		btnSaveCardio.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnSaveCardio.setForeground(new Color(105, 105, 105));
		btnSaveCardio.setBackground(new Color(0, 0, 0));
		btnSaveCardio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				String name = tfCardioActivityName.getText();
				Integer hours = 0;
				Integer minutes = 0;
				String time = "";
				
				try{
					if (!tfHours.getText().isEmpty()){
						hours = Integer.parseInt(tfHours.getText());
					}
					if (!tfMinutes.getText().isEmpty()){
						minutes = Integer.parseInt(tfMinutes.getText());
					}
					if(tfHours.getText().isEmpty() && tfMinutes.getText().isEmpty()){
						hours = null;
						minutes = null;
					}
					String negNumberToProduceErrorInLogic = "-1";
					if(hours == null && minutes == null){
						time = "";
					}
					else if (hours < 0 || minutes < 0) {
						time = negNumberToProduceErrorInLogic;
					}
					else {
						time += (hours * 60 + minutes);
					}
				} catch(NumberFormatException e){
					time = "Error, the time spent must be numeric.";
				}
				Date dateSelected = datePickerCardio.getDate();
				try {
					logic.addCardioActivity(name, dateSelected, time);
					lblCheck2.setIcon(iconCheck);
					tfCardioActivityName.setText("");
					tfHours.setText("0");
					tfMinutes.setText("0");
					datePickerCardio.setDate(null);
				} catch (Exception e) {
					lblCheck2.setIcon(null);
					JOptionPane.showMessageDialog(cardioMainPanel,
							e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSaveCardio.setBounds(136, 174, 176, 35);
		datePickerCardio = new JXDatePicker();
		datePickerCardio.getEditor().setEditable(false);
		datePickerCardio.getEditor().setBorder(new LineBorder(new Color(192, 192, 192)));
		datePickerCardio.setBounds(226, 55, 187, 28);
		tfHours = new JTextField();
		tfHours.setBounds(226, 89, 43, 28);
		tfHours.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfHours.setText("0");
		tfMinutes = new JTextField();
		tfMinutes.setBounds(324, 89, 43, 28);
		tfMinutes.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfMinutes.setText("0");
		lblMinutes = new JLabel("Minutes");
		lblMinutes.setForeground(new Color(105, 105, 105));
		lblMinutes.setFont(new Font("Sathu", Font.PLAIN, 14));
		if (OSString.contains("Mac")) {
			lblMinutes.setBounds(380, 97, 61, 16);
		} else {
			lblMinutes.setBounds(367, 97, 61, 16);
		}
		lblHours = new JLabel("Hours");
		lblHours.setForeground(new Color(105, 105, 105));
		lblHours.setFont(new Font("Sathu", Font.PLAIN, 14));
		if (OSString.contains("Mac")) {
			lblHours.setBounds(270, 97, 61, 16);
		} else {
			lblHours.setBounds(271, 97, 61, 16);
		}
		lblCardioIcon = new JLabel("");
		lblCardioIcon.setBounds(0, -14, 195, 158);
		lblCardioIcon.setIcon(iconCardioLarge);
		lblCheck2 = new JLabel("");
		lblCheck2.setBounds(324, 174, 99, 35);
		lblCheck2.setIcon(null);
		
		cardioMainPanel.add(lblCheck2);
		cardioMainPanel.add(lblMinutes);
		cardioMainPanel.add(lblTimeSpent);
		cardioMainPanel.add(lblCardioActivityName);
		cardioMainPanel.add(lblDateCardio);
		cardioMainPanel.add(tfHours);
		cardioMainPanel.add(tfCardioActivityName);
		cardioMainPanel.add(lblHours);
		cardioMainPanel.add(datePickerCardio);
		cardioMainPanel.add(btnSaveCardio);
		cardioMainPanel.add(tfMinutes);
		cardioMainPanel.add(lblCardioIcon);

		//Strength Workout Panel
		lblStrengthActivityName = new JLabel("Activity Name");
		lblStrengthActivityName.setForeground(new Color(224, 255, 255));
		lblStrengthActivityName.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblStrengthActivityName.setBounds(67, 17, 176, 35);
		lblRepetitions = new JLabel("Repetitions");
		lblRepetitions.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblRepetitions.setForeground(new Color(224, 255, 255));
		lblRepetitions.setBounds(67, 124, 145, 25);
		lblWeightLifted = new JLabel("Weight Lifted");
		lblWeightLifted.setForeground(new Color(224, 255, 255));
		lblWeightLifted.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblWeightLifted.setBounds(67, 90, 145, 25);
		lblDateStrength = new JLabel("Date");
		lblDateStrength.setForeground(new Color(224, 255, 255));
		lblDateStrength.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 20));
		lblDateStrength.setBounds(67, 56, 78, 25);
		tfStrengthActivityName = new JTextField();
		tfStrengthActivityName.setBorder(new LineBorder(
				new Color(192, 192, 192)));
		tfStrengthActivityName.setBounds(226, 21, 162, 28);
		tfStrengthActivityName.setColumns(10);
		datePickerStrength = new JXDatePicker();
		datePickerStrength.getEditor().setEditable(false);
		datePickerStrength.getEditor().setBorder(
				new LineBorder(new Color(192, 192, 192)));
		datePickerStrength.setBounds(226, 55, 187, 28);
		btnSaveStrength = new JButton("Save Session Details");
		btnSaveStrength.setBorder(UIManager.getBorder("Button.border"));
		btnSaveStrength.setForeground(new Color(105, 105, 105));
		btnSaveStrength.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnSaveStrength.setBounds(136, 174, 176, 35);
		btnSaveStrength.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				String name = tfStrengthActivityName.getText();
				String reps = tfReps.getText();
				String weight = tfWeightLifted.getText();
				Date dateSelected = datePickerStrength.getDate();
				try {
					logic.addStrengthActivity(name, dateSelected, weight, reps);
					lblCheckMarkIcon.setIcon(iconCheck);
					tfStrengthActivityName.setText("");
					datePickerStrength.setDate(null);
					tfReps.setText("");
					tfWeightLifted.setText("");
				} catch (Exception e) {
					lblCheckMarkIcon.setIcon(null);
					JOptionPane.showMessageDialog(strengthMainPanel,
							e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tfReps = new JTextField();
		tfReps.setBounds(226, 122, 53, 30);
		tfReps.setBorder(new LineBorder(new Color(192, 192, 192)));
		lblLbs = new JLabel("lbs");
		lblLbs.setFont(new Font("Sathu", Font.PLAIN, 14));
		lblLbs.setForeground(new Color(105, 105, 105));
		lblLbs.setBounds(282, 97, 61, 16);
		tfWeightLifted = new JTextField();
		tfWeightLifted.setColumns(10);
		tfWeightLifted.setBorder(new LineBorder(new Color(192, 192, 192)));
		tfWeightLifted.setBounds(226, 89, 53, 28);
		lblStrengthIcon = new JLabel("");
		lblStrengthIcon.setBounds(-31, 0, 162, 167);
		lblStrengthIcon.setIcon(iconStrengthLarge);
		lblCheckMarkIcon = new JLabel("");
		lblCheckMarkIcon.setBounds(324, 174, 99, 35);
		lblCheckMarkIcon.setIcon(null);
		
		strengthMainPanel = new JPanel();
		strengthMainPanel.setBorder(emptyBorder);
		strengthMainPanel.setBackground(new Color(204, 204, 204));
		strengthMainPanel.setLayout(null);
		strengthMainPanel.add(tfWeightLifted);
		strengthMainPanel.add(lblDateStrength);
		strengthMainPanel.add(datePickerStrength);
		strengthMainPanel.add(lblStrengthActivityName);
		strengthMainPanel.add(lblLbs);
		strengthMainPanel.add(tfReps);
		strengthMainPanel.add(lblWeightLifted);
		strengthMainPanel.add(lblRepetitions);
		strengthMainPanel.add(btnSaveStrength);
		strengthMainPanel.add(tfStrengthActivityName);
		strengthMainPanel.add(lblStrengthIcon);
		strengthMainPanel.add(lblCheckMarkIcon);
		
		//Add VIEW/SEARCH tabs to contentPane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 502, 334);
		contentPane.add(tabbedPane);
		
		compareWorkoutsPanel = new JPanel();
		compareWorkoutsPanel.setBorder(null);
		compareWorkoutsPanel.setBackground(new Color(211, 211, 211));

		enterWorkoutPanel = new JPanel();
		enterWorkoutPanel.setBorder(emptyBorder);
		enterWorkoutPanel.setBackground(new Color(211, 211, 211));
		enterWorkoutPanel.setLayout(null);

		enterWorkoutTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		enterWorkoutTabbedPane.setBackground(new Color(211, 211, 211));
		enterWorkoutTabbedPane.setBounds(6, 0, 468, 278);
		if(OSString.contains("Linux")|| OSString.contains("Windows")){
			enterWorkoutTabbedPane.setBounds(15, 0, 468, 278);
			
		}
		enterWorkoutTabbedPane.setBorder(emptyBorder);
		enterWorkoutTabbedPane.addTab("...for a strength training workout",
				iconStrengthSmall, strengthMainPanel, null);
		enterWorkoutTabbedPane.addTab("...for a cardio session", iconCardioSmall,
				cardioMainPanel, null);
		
		enterWorkoutPanel.add(enterWorkoutTabbedPane);
		
		tabbedPane.addTab("Enter Workout Information", null, enterWorkoutPanel, null);
		tabbedPane.addTab("Compare Workout Details", null,
				compareWorkoutsPanel, null);

		//Compare Workouts Panel
		compareScrollPane1 = new JScrollPane();
		compareScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		compareScrollPane1.setBorder(new LineBorder(Color.GRAY));
		compareScrollPane2 = new JScrollPane();
		compareScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		compareScrollPane2.setBorder(new LineBorder(Color.GRAY));
		compareScrollPane2.setBackground(Color.LIGHT_GRAY);
		compareScrollPane2.setBounds(15, 97, 215, 145);
		compareScrollPane1.setBounds(250, 97, 215, 145);
		compareWorkoutsPanel.setBorder(emptyBorder);
		compareWorkoutsPanel.setLayout(null);
		compareWorkoutsPanel.add(compareScrollPane2);
		textArea2 = new JTextArea(5, 30);
		textArea2.setEditable(false);
		textArea2.setWrapStyleWord(true);
		textArea2.setLineWrap(true);
		compareScrollPane2.setViewportView(textArea2);
		textArea2.setForeground(Color.DARK_GRAY);
		textArea2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		textArea2.setBackground(Color.WHITE);
		compareWorkoutsPanel.add(compareScrollPane1);
		textArea1 = new JTextArea(5, 30);
		textArea1.setEditable(false);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		compareScrollPane1.setViewportView(textArea1);
		textArea1.setForeground(Color.DARK_GRAY);
		textArea1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		textArea1.setBackground(Color.WHITE);
		compareDatePicker1 = new JXDatePicker();
		compareDatePicker1.getEditor().setEditable(false);
		compareDatePicker1.setBounds(55, 65, 151, 28);
		compareWorkoutsPanel.add(compareDatePicker1);
		compareDatePicker2 = new JXDatePicker();
		compareDatePicker2.getEditor().setEditable(false);
		compareDatePicker2.setBounds(279, 65, 151, 28);
		compareWorkoutsPanel.add(compareDatePicker2);
		txtrCompareInstructions = new JLabel();
		txtrCompareInstructions.setForeground(new Color(105, 105, 105));
		txtrCompareInstructions.setBackground(Color.LIGHT_GRAY);
		txtrCompareInstructions.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 14));
		
		if (System.getProperty("os.name").contains("Linux")
				|| System.getProperty("os.name")
						.contains("Windows")){
			txtrCompareInstructions.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 12));
		}
		
		txtrCompareInstructions
				.setText("<html><div style=\"text-align: center;\">Choose up to two dates to compare workout sessions. Your past workout details can inform you of your fitness improvements or declines.</html>");
		txtrCompareInstructions.setBounds(15, 0, 450, 62);
		
		
		
		
		compareWorkoutsPanel.add(txtrCompareInstructions);
		btnCompareWorkouts = new JButton("Compare ");
		btnCompareWorkouts.setForeground(new Color(105, 105, 105));
		btnCompareWorkouts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent m) {
				try {
					textArea2.setText(logic.searchByDate(compareDatePicker1
							.getDate()));
					textArea1.setText(logic.searchByDate(compareDatePicker2
							.getDate()));
					if (textArea1.getText().isEmpty()
							&& textArea2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(compareWorkoutsPanel,
								"You must select at least one date.", "Error",
								JOptionPane.ERROR_MESSAGE);	
					}
				
				}catch(Exception e) {
					JOptionPane.showMessageDialog(compareWorkoutsPanel,
							e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCompareWorkouts
				.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 13));
		btnCompareWorkouts.setBounds(165, 250, 150, 35);
		compareWorkoutsPanel.add(btnCompareWorkouts);
	}
}
