package Host;
//import ADT.*;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;




import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import Login.LoginWindow;
import Shared.Gradients.GradientButton;
import Shared.Gradients.GradientPanel;
import Shared.Notifications.NotificationGUI;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
@SuppressWarnings({"unused","rawtypes","unchecked", "serial"})
public class HostGUI extends JFrame implements ActionListener{
			
		/**
		 * Class created for using the Host System
		 * Uses DB as required throughout the code, 
		 * and Java Swing Library to create a user interface
		 * 
		 * @author David Arakelyan
		 * @tester David Arakelyan
		 * @debugger David Arakelyan
		 * 
		 */
	
			//Swing Variables
			//Notification GUI
			public NotificationGUI notification;
			private JPanel rootPanel,titlePanel;
			private GradientPanel MainPanel;
			private GradientButton logoutButton;
			public GradientButton Help;
			//private GradientButton logoutButton;
			private JLabel titleLabel,dateAndTime;
			//Other Variables
			public Timer timer;
			public JPanel TableStatus;
			public GradientButton AssignWaiter,UnassignWaiter,Reserve,UnReserve;
			public JButton Table1,Table2,Table3,Table4,Table5,Table6,Table7,Table8,Table9,Table10;
			public GradientButton Assign,Unassign,Unclean;
			public JComboBox combobox_customer,combobox_waiter, WaiterList;
			public JComboBox Waiters_for_Table_2;
			public JComboBox Waiters_for_Table_4;
			public JComboBox Waiters_for_Table_7;
			public JComboBox Waiters_for_Table_1;
			public JComboBox Waiters_for_Table_5;
			public JComboBox Waiters_for_Table_8;
			public JComboBox Waiters_for_Table_10;
			public JComboBox Waiters_for_Table_3;
			public JComboBox Waiters_for_Table_6;
			public JComboBox Waiters_for_Table_9;
			public JButton W_1,W_2,W_3,W_4,W_5,W_6,W_7,W_8,W_9,W_10;
			
			//Added by Sam
			public LinkedList dirtyTables = new LinkedList();
			private int counter = 0;
			private Border border_BLACK = new LineBorder(Color.BLACK,3); //Clean
			private Border border_YELLOW = new LineBorder(Color.YELLOW,6); //Unclean
			private Timer blinkTimer;
			
			public HostCommunicator h = new HostCommunicator();
			private HostHandler Hhandler = new HostHandler(h);
			
			
	public HostGUI() {
		
		super();
		// New blinker timer for dirty tables
		blinkTimer = new Timer(500,this);
		blinkTimer.setRepeats(true);
		blinkTimer.setCoalesce(true);
		blinkTimer.setInitialDelay(0);
		initialize();
		//h.updateTableStatus();
		
	}

	
	private void initialize() {
		this.setTitle("Host GUI");
		this.setVisible(false);
		this.setResizable(true);
		this.setSize(1200,700);
		this.frameManipulation();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().add(rootPanel);
		
		 addWindowListener(new WindowAdapter() // To open login again if you hit the corner "X"
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	blinkTimer.stop();
	    			notification.close();
	    			h.disconnect();
	    			new LoginWindow();
	    			dispose();
	            }
	        });
		
		this.setVisible(true);
		
		
		}
	
	
	public void frameManipulation()
	{
		setBackgroundPanel();
		setTitlePanel();
		setButtonPanel();
		setRootPanel();
	}
	
	
	private void setRootPanel()
	{
		rootPanel = new JPanel();
		// Create Notification GUI
		notification = new NotificationGUI(23,"Host");
		rootPanel.add(notification);
		rootPanel.setLayout(null);
		rootPanel.add(titlePanel);
		rootPanel.add(MainPanel);
		rootPanel.setVisible(true);
		
	}
	
	private void setBackgroundPanel() 
	{
		// Create Background Panel
		MainPanel = new GradientPanel();
		MainPanel.setGradient(Color.white,new Color(153,230,255));
		//backgroundPanel.setBrightness(backgroundPanel.getColor2(),1);
		MainPanel.setLayout(null);
		MainPanel.setBounds(0,0,1200,652);
		
		logoutButton = new GradientButton("LOGOUT");
		logoutButton.setBounds(10, 551, 580, 66);
		logoutButton.setFocusPainted(false);
		logoutButton.setFont(logoutButton.getFont().deriveFont(16.0f));
		MainPanel.add(logoutButton);
		// Only adjust horizontal and vertical gaps for this layout
		// DO NOT adjust panel size or location!!
		
		TableStatus = new JPanel();
		TableStatus.setBounds(0, 55, 1188, 482);
		MainPanel.add(TableStatus);
		TableStatus.setLayout(null);
		
		TableStatus.setOpaque(false);
		
		
		// ************************************
		// ************************************
		// Main definitions (ignore)
		// ************************************
		// ************************************
		
		// Borders for buttons):
		Border border = new LineBorder(Color.BLACK,3);
		
		//
		
		// Rows of waiters
				
		// Buttons, Labels, Combo boxes
		
		JLabel Title_Status = new JLabel("Table Status");
		Title_Status.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Title_Status.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Status.setBounds(423, 13, 371, 58);
		TableStatus.add(Title_Status);
		
		JButton Seperator_horizontal = new JButton("");
		Seperator_horizontal.setEnabled(false);
		Seperator_horizontal.setBounds(0, 473, 1188, 9);
		TableStatus.add(Seperator_horizontal);
		
		JLabel Customer_Title = new JLabel("Customer/Table");
		Customer_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Customer_Title.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Customer_Title.setBounds(0, 13, 281, 58);
		TableStatus.add(Customer_Title);
		
		JLabel Assign_Waiters = new JLabel("Waiters");
		Assign_Waiters.setHorizontalAlignment(SwingConstants.CENTER);
		Assign_Waiters.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Assign_Waiters.setBounds(930, 13, 258, 58);
		TableStatus.add(Assign_Waiters);
		
		Assign = new GradientButton("Assign");
		Assign.addActionListener(this);
		Assign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Assign.setBounds(43, 149, 187, 51);
		TableStatus.add(Assign);
		
		Unassign = new GradientButton("Unassign");
		Unassign.addActionListener(this);
		Unassign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Unassign.setBounds(43, 213, 187, 51);
		TableStatus.add(Unassign);
		
		String[] Tables_for_customer = {"Table 1","Table 2", "Table 3", "Table 4", "Table 5", "Table 6","Table 7","Table 8","Table 9","Table 10"};
		combobox_customer = new JComboBox(Tables_for_customer);
		combobox_customer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//combobox_customer.setSelectedIndex(0);
		combobox_customer.setBounds(43, 84, 187, 51);
		TableStatus.add(combobox_customer);
		Render(combobox_customer);
		
		String[] Tables_for_waiter = {"Table 1","Table 2", "Table 3", "Table 4", "Table 5", "Table 6","Table 7","Table 8","Table 9","Table 10"};
		combobox_waiter = new JComboBox(Tables_for_waiter);
		combobox_waiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		combobox_waiter.setBounds(974, 103, 187, 51);
		TableStatus.add(combobox_waiter);
		//combobox_waiter.setSelectedIndex(0);
		Render(combobox_waiter);
		
		WaiterList = new JComboBox(new DefaultComboBoxModel(h.initialEmployeeList().toArray()));
		WaiterList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WaiterList.setBounds(974, 195, 187, 51);
		TableStatus.add(WaiterList);
		TableStatus.setVisible(true);
		Render(WaiterList);
		
		AssignWaiter = new GradientButton("Waiter 1");
		AssignWaiter.setText("Assign Waiter");
		AssignWaiter.addActionListener(this);
		AssignWaiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AssignWaiter.setBounds(974, 294, 187, 45);
		TableStatus.add(AssignWaiter);
		
		UnassignWaiter = new GradientButton("Waiter 2");
		UnassignWaiter.setText("UnassignWaiter");
		UnassignWaiter.addActionListener(this);
		UnassignWaiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UnassignWaiter.setBounds(974, 384, 187, 45);
		TableStatus.add(UnassignWaiter);
		
		Waiters_for_Table_1 = new JComboBox();
		Waiters_for_Table_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_1.setBounds(284, 176, 186, 37);
		TableStatus.add(Waiters_for_Table_1);
		Render(Waiters_for_Table_1);
		
		Waiters_for_Table_2 = new JComboBox();
		Waiters_for_Table_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_2.setBounds(512, 127, 186, 37);
		TableStatus.add(Waiters_for_Table_2);
		Render(Waiters_for_Table_2);
		
		Waiters_for_Table_3 = new JComboBox();
		Waiters_for_Table_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_3.setBounds(731, 176, 186, 37);
		TableStatus.add(Waiters_for_Table_3);
		Render(Waiters_for_Table_3);
		
		Waiters_for_Table_4 = new JComboBox();
		Waiters_for_Table_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_4.setBounds(285, 276, 186, 37);
		TableStatus.add(Waiters_for_Table_4);
		Render(Waiters_for_Table_4);
		
		Waiters_for_Table_5 = new JComboBox();
		Waiters_for_Table_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_5.setBounds(512, 222, 186, 37);
		TableStatus.add(Waiters_for_Table_5);
		Render(Waiters_for_Table_5);
		
		Waiters_for_Table_6 = new JComboBox();
		Waiters_for_Table_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_6.setBounds(732, 279, 186, 37);
		TableStatus.add(Waiters_for_Table_6);
		Render(Waiters_for_Table_6);
		
		Waiters_for_Table_7 = new JComboBox();
		Waiters_for_Table_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_7.setBounds(285, 380, 186, 37);
		TableStatus.add(Waiters_for_Table_7);
		Render(Waiters_for_Table_7);
		
		Waiters_for_Table_8 = new JComboBox();
		Waiters_for_Table_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_8.setBounds(511, 326, 186, 37);
		TableStatus.add(Waiters_for_Table_8);
		Render(Waiters_for_Table_8);
		
		Waiters_for_Table_9 = new JComboBox();
		Waiters_for_Table_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_9.setBounds(732, 384, 186, 37);
		TableStatus.add(Waiters_for_Table_9);
		Render(Waiters_for_Table_9);
		
		Waiters_for_Table_10 = new JComboBox();
		Waiters_for_Table_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_10.setBounds(512, 423, 186, 37);
		TableStatus.add(Waiters_for_Table_10);
		Render(Waiters_for_Table_10);
		
		W_1 = new JButton("");
		W_1.setForeground(Color.GREEN);
		W_1.setEnabled(false);
		W_1.setBounds(450, 123, 21, 45);
		TableStatus.add(W_1);
		W_1.setBorder(border);
		
		W_2 = new JButton("");
		W_2.setEnabled(false);
		W_2.setBounds(677, 70, 21, 45);
		TableStatus.add(W_2);
		W_2.setBorder(border);
		
		W_3 = new JButton("");
		W_3.setEnabled(false);
		W_3.setBounds(897, 128, 21, 45);
		TableStatus.add(W_3);
		W_3.setBorder(border);
		
		W_4 = new JButton("");
		W_4.setEnabled(false);
		W_4.setBounds(450, 222, 21, 45);
		TableStatus.add(W_4);
		W_4.setBorder(border);
		
		W_5 = new JButton("");
		W_5.setEnabled(false);
		W_5.setBounds(677, 172, 22, 45);
		TableStatus.add(W_5);
		W_5.setBorder(border);
		
		W_6 = new JButton("");
		W_6.setEnabled(false);
		W_6.setBounds(897, 230, 21, 45);
		TableStatus.add(W_6);
		W_6.setBorder(border);
		
		W_7 = new JButton("");
		W_7.setEnabled(false);
		W_7.setBounds(450, 326, 21, 45);
		TableStatus.add(W_7);
		W_7.setBorder(border);
		
		W_8 = new JButton("");
		W_8.setEnabled(false);
		W_8.setBounds(677, 275, 22, 45);
		TableStatus.add(W_8);
		W_8.setBorder(border);
		
		W_9 = new JButton("");
		W_9.setEnabled(false);
		W_9.setBounds(897, 333, 21, 45);
		TableStatus.add(W_9);
		W_9.setBorder(border);
		
		W_10 = new JButton("");
		W_10.setEnabled(false);
		W_10.setBounds(677, 376, 22, 45);
		TableStatus.add(W_10);
		W_10.setBorder(border);
		
		Table2 = new JButton("Table 2");
		Table2.setEnabled(false);
		Table2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table2.setBounds(512, 70, 166, 45);
		TableStatus.add(Table2);
		Table2.setBorder(border);
		
		Table3 = new JButton("Table 3");
		Table3.setEnabled(false);
		Table3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table3.setBounds(731, 128, 166, 45);
		TableStatus.add(Table3);
		Table3.setBorder(border);
		
		Table4 = new JButton("Table 4");
		Table4.setEnabled(false);
		Table4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table4.setBounds(284, 222, 166, 45);
		TableStatus.add(Table4);
		Table4.setBorder(border);
		
		
		Table5 = new JButton("Table 5");
		Table5.setEnabled(false);
		Table5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table5.setBounds(512, 172, 166, 45);
		TableStatus.add(Table5);
		Table5.setBorder(border);
		
		Table6 = new JButton("Table 6");
		Table6.setEnabled(false);
		Table6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table6.setBounds(731, 230, 166, 45);
		TableStatus.add(Table6);
		Table6.setBorder(border);
		
		Table9 = new JButton("Table 9");
		Table9.setEnabled(false);
		Table9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table9.setBounds(731, 333, 166, 45);
		TableStatus.add(Table9);
		Table9.setBorder(border);
		
		Table7 = new JButton("Table 7");
		Table7.setEnabled(false);
		Table7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table7.setBounds(284, 326, 166, 45);
		TableStatus.add(Table7);
		Table7.setBorder(border);
		
		Table10 = new JButton("Table 10");
		Table10.setEnabled(false);
		Table10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table10.setBounds(512, 376, 166, 45);
		TableStatus.add(Table10);
		Table10.setBorder(border);
		
		
		Table8 = new JButton("Table 8");
		Table8.setEnabled(false);
		Table8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table8.setBounds(511, 275, 166, 45);
		TableStatus.add(Table8);
		Table8.setBorder(border);
		
		Table1 = new JButton("Table 1");
		Table1.setEnabled(false);
		Table1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table1.setBounds(284, 123, 166, 45);
		TableStatus.add(Table1);
		Table1.setBorder(border);
		
		Reserve = new GradientButton("Reserve");
		Reserve.setText("Reserve");
		Reserve.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Reserve.setBounds(43, 277, 187, 51);
		TableStatus.add(Reserve);
		Reserve.addActionListener(this);
		
		UnReserve = new GradientButton("Don't Reserve");
		UnReserve.setText("Don't Reserve");
		UnReserve.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UnReserve.setBounds(43, 345, 187, 51);
		TableStatus.add(UnReserve);
		UnReserve.addActionListener(this);
		
		Unclean = new GradientButton("Unclean");
		Unclean.setText("Mark as unclean");
		Unclean.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Unclean.setBounds(43, 409, 187, 51);
		TableStatus.add(Unclean);
		Unclean.addActionListener(this);
		
		Help = new GradientButton("HELP");
		Help.addActionListener(this);
		Help.setText("HELP");
		Help.setFont(Help.getFont().deriveFont(16f));
		Help.setFocusPainted(false);
		Help.setBounds(602, 551, 586, 66);
		MainPanel.add(Help);
		
		//UIManager.put("ToggleButton.select", Color.GREEN);
		
		// ************************************
		// ************************************
		// End of main definitions (ignore)
		// ************************************
		// ************************************
		
		// Initial Statuses
		
		//*************************************
		//INITIAL TABLE STATUS (CLEAN OR UNCLEAN?)
		//*************************************
		
		TableStatusInitialIndicator(Table1,0);
		TableStatusInitialIndicator(Table2,1);
		TableStatusInitialIndicator(Table3,2);
		TableStatusInitialIndicator(Table4,3);
		TableStatusInitialIndicator(Table5,4);
		TableStatusInitialIndicator(Table6,5);
		TableStatusInitialIndicator(Table7,6);
		TableStatusInitialIndicator(Table8,7);
		TableStatusInitialIndicator(Table9,8);
		TableStatusInitialIndicator(Table10,9);
		
		//************************************************
		//INITIAL TABLE STATUS (Reserved or not Reserved)
		//************************************************
		
		Hhandler.reservedTableIndicator(createReservedList());
	
		//*************************************
		//INITIAL CUSTOMER STATUSES (At table)
		//*************************************
		
		Hhandler.CustomerStatus(createCustomerList());
		
		//*********************************************
		//INITIAL WAITERS at table (FROM DATABASE)
		//*********************************************

		Hhandler.addInitialWaiters(createInitialWaiterList());
		
		//**********************************************************
		//INITIAL WAITER STATUS AT TABLE (OCCUPIED BY WAITER OR NOT?)
		//**********************************************************
		checkIfFull(Waiters_for_Table_1,W_1);
		checkIfFull(Waiters_for_Table_2,W_2);
		checkIfFull(Waiters_for_Table_3,W_3);
		checkIfFull(Waiters_for_Table_4,W_4);
		checkIfFull(Waiters_for_Table_5,W_5);
		checkIfFull(Waiters_for_Table_6,W_6);
		checkIfFull(Waiters_for_Table_7,W_7);
		checkIfFull(Waiters_for_Table_8,W_8);
		checkIfFull(Waiters_for_Table_9,W_9);
		checkIfFull(Waiters_for_Table_10,W_10);
		
		//*************************************

		// Show the first waiter of the list
			if (WaiterList.getItemCount() != 0){
				WaiterList.setSelectedIndex(0);
			}
			
		//*************************************
		
		
			
		logoutButton.addActionListener(this);
		
		MainPanel.setVisible(true);
		
		
	}
	
	public void Render(JComboBox<String> x){
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		x.setRenderer(dlcr); 
	}
	
	
	//*********************************************************
	//DO NOT edit the following function except for title name
	//*********************************************************
	
	private void setTitlePanel()
	{
		// Create Title Panel
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setOpaque(false);
		titlePanel.setBounds(new Rectangle(0, 0, 1200, 56));
		// Set Title
		titleLabel = new JLabel("Host Interface");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(38f));
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		titleLabel.setBounds(new Rectangle(0, 0, 793, 56));
		// Create a timer to update the clock
		timer = new Timer(500,this);
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(0);
        timer.addActionListener(this);
        timer.start();

		// Add components to Title Panel
		titlePanel.add(titleLabel);
		// Set Date and Time
		dateAndTime = new JLabel();
		dateAndTime.setBounds(792, 0, 402, 56);
		titlePanel.add(dateAndTime);
		dateAndTime.setHorizontalAlignment(JLabel.CENTER);
		dateAndTime.setFont(dateAndTime.getFont().deriveFont(28f));
		dateAndTime.setBorder(BorderFactory.createLineBorder(Color.black));
		
		titlePanel.setVisible(true);
	}
	
	private void setButtonPanel()
	{
		
	}
	private void updateClock() {
        dateAndTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }
	private void updateStats(){
		
	}
	
	public void actionPerformed(ActionEvent e) {
	Object a = e.getSource();
	if(a == logoutButton)
		{
			blinkTimer.stop();
			notification.close();
			h.disconnect();
			new LoginWindow();
			dispose();
		}
	if(a == timer)
		{
			updateClock();
		}
	if(a == Help)
		{
			int optionChoice = 0;
			String[] optionsAvailable = {"Customer Status", "Table Status", "Waiter Status", "Indicators at Tables", "Logout","Notifications"};
			optionChoice = JOptionPane.showOptionDialog(new JFrame(), "<html><body><div width='350px' align='right'>Which function would you like help with?</div></body></html>", "Help",JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null, optionsAvailable, 0);
			switch(optionChoice){
			case 0: // Customer Status Help
				JOptionPane.showMessageDialog(this, ""
						+ "To change the customer status, simply select at table under the 'Customer/Table' title, and"
						+ "\n select either the 'Assign' or the 'Unassign' option. If the 'Assign' button is selected,"
						+ "\n observe that the color of the Table will change to green, indicating that it is currently"
						+ "\n occupied by a customer. If the 'Unassign' button is selected, observe that the color of"
						+ "\n the table will change to red, indicating that it is currently unoccupied by a customer.");
				break;
			case 1: // Table Status Help
				JOptionPane.showMessageDialog(this, ""
						+ "Under the 'Table Status' title, observe the table arrangement of the restaurant. Each "
						+ "\n table has several indicators which change based on changes made throughout the interface."
						+ "\n More information on these indicators can be found by selecting the 'Indicators at Tables'"
						+ "\n help option at the Help menu. Under each table is a list which displays the waiters currently"
						+ "\n assigned to said table. Select the list to open it and view the Waiters assigned ot the table."
						+ "\n A dash ('-') represents an unassigned waiter to the table. The option of reserving a table or"
						+ "\n not reserving a table for customers is available through the 'Reserve' and 'Don't reserve' options."
						+ "\n A table can also be marked as clean by selecting the 'Mark as clean' option after selecting a"
						+ "\n table from thet able list. Indicators will be activates once the previous options have been"
						+ "\n selected, and more information on these indicators can be found by selecting the 'Inidcators at"
						+ "\n tables' option at the Help menu.");
				break;
			case 2: // Waiter Status
				JOptionPane.showMessageDialog(this,""
						+ "Under the 'Waiters' title, observe the Table seleciton list, as well as the waiter selection"
						+ "\n list below the Table selection list. To change the assignment of a waiter, simply select "
						+ "\n a table from the Table seleciton list, then select a waiter of intrest to said table."
						+ "\n After wards, select the 'Assign Waiter' option to assign said waiter to the table, or the"
						+ "\n 'Unassign Waiter' otion to unassign the waiter from the table. The limit of waiters to one"
						+ "\n table is 5, so if more than 5 waiters are assigned to a table, an error will be displayed"
						+ "\n on the interface addressing the situation. If no waiters are assigned to a table, and an "
						+ "\n attempt to unassign waiters from said table is maid, an error will be displayed addressing"
						+ "\n the situation. Once a waiter has been assigned to a table, observe a small indicator next to"
						+ "\n the Table name in the table arrangement area of the interface glow a bright green. This represents"
						+ "\n a situation where waiter(s) have been assigned to a table. If no waiters have been assigned to"
						+ "\n a table, the indicator will glow red.");
				break;
			case 3: // Indicators at Tables Status
				JOptionPane.showMessageDialog(this,""
						+ "The indicators for tables can be seen for each table under the 'Table Status' title. When a customer"
						+ "\n is assigned or unassigned to a table, the said table indicator will glow green or red (respectively)."
						+ "\n This particular table indicator is the largest for said table. A table which is unclean will flicker"
						+ "\n a yellow color. If a table is marked as clean by the 'Mark as Clean' button, it the yellow indicator"
						+ "\n will no longer flicker yellow, but rather stay a solid black color. If a waiter(s) is assigned to a"
						+ "\n table, a smaller indicator to the right of the Table name will glow green. If a waiter(s) is not"
						+ "\n assigned to a table, the indicator will glow red. If the table is marked as reserved by the host,"
						+ "\n the border around the waiter indicator will glow blue. If it is not reserved, then the border will"
						+ "\n have a dark color. ");
				break;
			case 4: // Logout
				JOptionPane.showMessageDialog(this,""
						+ "Upon selection of this button, the interface will disconnect.");
				break;
			case 5: // Notifications
				JOptionPane.showMessageDialog(this,""
						+ "The notifications can be found at the top right corner of the interface. Simply hover over the clock"
						+ "\n and select the 'Notificaitons' label. A list of outgoing and incoming messages will be displayed."
						+ "\n To use these notifications, first select the 'Send message' option, select 'Private' or 'Public'."
						+ "\n Selecting 'Private' option will make the message visible only to the employee the message is sent to"
						+ "\n Selecting the 'Public' option will make the message visible to all employees. Type in an Employee ID"
						+ "\n or the position of the employee to send a message typed in under the 'Message' option. If the position"
						+ "\n of the Employee is selected, the message will be sent to all employees of the position.");
				break;	
							
			}
			
		}
	if (a == Unclean){
		String s = (String)combobox_customer.getSelectedItem();
		if(s == "Table 1"){
			h.markTableAsUnClean(1);
			TableStatusIndicatorFinal(Table1);
		}
		if(s == "Table 2"){
			h.markTableAsUnClean(2);
			TableStatusIndicatorFinal(Table2);
		}
		if(s == "Table 3"){
			h.markTableAsUnClean(3);	
			TableStatusIndicatorFinal(Table3);
		}
		if(s == "Table 4"){
			h.markTableAsUnClean(4);
			TableStatusIndicatorFinal(Table4);
		}
		if(s == "Table 5"){
			h.markTableAsUnClean(5);
			TableStatusIndicatorFinal(Table5);
		}
		if(s == "Table 6"){
			h.markTableAsUnClean(6);
			TableStatusIndicatorFinal(Table6);
		}
		if(s == "Table 7"){
			h.markTableAsUnClean(7);
			TableStatusIndicatorFinal(Table7);
		}
		if(s == "Table 8"){
			h.markTableAsUnClean(8);
			TableStatusIndicatorFinal(Table8);
		}
		if(s == "Table 9"){
			h.markTableAsUnClean(9);
			TableStatusIndicatorFinal(Table9);
		}
		if(s == "Table 10"){
			h.markTableAsUnClean(10);
			TableStatusIndicatorFinal(Table10);
		}
	}
	if(a == Assign)
		{
			String s = (String)combobox_customer.getSelectedItem();
			if(s == "Table 1"){
				CheckColorAndSetGreen(Table1);
				h.updateTableOccupiedByCustomer(1);
			}
			if(s == "Table 2"){
				CheckColorAndSetGreen(Table2);
				h.updateTableOccupiedByCustomer(2);
			}
			if(s == "Table 3"){
				CheckColorAndSetGreen(Table3);
				h.updateTableOccupiedByCustomer(3);
			}
			if(s == "Table 4"){
				CheckColorAndSetGreen(Table4);
				h.updateTableOccupiedByCustomer(4);
			}
			if(s == "Table 5"){
				CheckColorAndSetGreen(Table5);
				h.updateTableOccupiedByCustomer(5);
			}
			if(s == "Table 6"){
				CheckColorAndSetGreen(Table6);
				h.updateTableOccupiedByCustomer(6);
			}
			if(s == "Table 7"){
				CheckColorAndSetGreen(Table7);
				h.updateTableOccupiedByCustomer(7);
			}
			if(s == "Table 8"){
				CheckColorAndSetGreen(Table8);
				h.updateTableOccupiedByCustomer(8);
			}
			if(s == "Table 9"){
				CheckColorAndSetGreen(Table9);
				h.updateTableOccupiedByCustomer(9);
			}
			if(s == "Table 10"){
				CheckColorAndSetGreen(Table10);
				h.updateTableOccupiedByCustomer(10);
			}
			
		}
	if(a == Reserve)
		{
		String s = (String)combobox_customer.getSelectedItem();
		if(s == "Table 1"){
			h.setBorderBlue_Reserved(W_1,1);
		}
		if(s == "Table 2"){
			h.setBorderBlue_Reserved(W_2,2);
		}
		if(s == "Table 3"){
			h.setBorderBlue_Reserved(W_3,3);
		}
		if(s == "Table 4"){
			h.setBorderBlue_Reserved(W_4,4);
		}
		if(s == "Table 5"){
			h.setBorderBlue_Reserved(W_5,5);
		}
		if(s == "Table 6"){
			h.setBorderBlue_Reserved(W_6,6);
		}
		if(s == "Table 7"){
			h.setBorderBlue_Reserved(W_7,7);
		}
		if(s == "Table 8"){
			h.setBorderBlue_Reserved(W_8,8);
		}
		if(s == "Table 9"){
			h.setBorderBlue_Reserved(W_9,9);
		}
		if(s == "Table 10"){
			h.setBorderBlue_Reserved(W_10,10);
		}
		}
	if(a == UnReserve)
		{
		String s = (String)combobox_customer.getSelectedItem();
		if(s == "Table 1"){
			h.setBorderBlack_Not_Reserved(W_1,1);
		}
		if(s == "Table 2"){
			h.setBorderBlack_Not_Reserved(W_2,2);
		}
		if(s == "Table 3"){
			h.setBorderBlack_Not_Reserved(W_3,3);
		}
		if(s == "Table 4"){
			h.setBorderBlack_Not_Reserved(W_4,4);
		}
		if(s == "Table 5"){
			h.setBorderBlack_Not_Reserved(W_5,5);
		}
		if(s == "Table 6"){
			h.setBorderBlack_Not_Reserved(W_6,6);
		}
		if(s == "Table 7"){
			h.setBorderBlack_Not_Reserved(W_7,7);
		}
		if(s == "Table 8"){
			h.setBorderBlack_Not_Reserved(W_8,8);
		}
		if(s == "Table 9"){
			h.setBorderBlack_Not_Reserved(W_9,9);
		}
		if(s == "Table 10"){
			h.setBorderBlack_Not_Reserved(W_10,10);
		}
		}
	if(a == Unassign)
		{
			String s = (String)combobox_customer.getSelectedItem();
			if(s == "Table 1"){
				CheckColorAndSetRed(Table1);
				h.updateTableUnoccupiedByCustomer(1);
				
			}
			if(s == "Table 2"){
				CheckColorAndSetRed(Table2);
				h.updateTableUnoccupiedByCustomer(2);
			}
			if(s == "Table 3"){
				CheckColorAndSetRed(Table3);
				h.updateTableUnoccupiedByCustomer(3);
			}
			if(s == "Table 4"){
				CheckColorAndSetRed(Table4);
				h.updateTableUnoccupiedByCustomer(4);
			}
			if(s == "Table 5"){
				CheckColorAndSetRed(Table5);
				h.updateTableUnoccupiedByCustomer(5);
			}
			if(s == "Table 6"){
				CheckColorAndSetRed(Table6);
				h.updateTableUnoccupiedByCustomer(6);
			}
			if(s == "Table 7"){
				CheckColorAndSetRed(Table7);
				h.updateTableUnoccupiedByCustomer(7);
			}
			if(s == "Table 8"){
				CheckColorAndSetRed(Table8);
				h.updateTableUnoccupiedByCustomer(8);
			}
			if(s == "Table 9"){
				CheckColorAndSetRed(Table9);
				h.updateTableUnoccupiedByCustomer(9);
			}
			if(s == "Table 10"){
				CheckColorAndSetRed(Table10);
				h.updateTableUnoccupiedByCustomer(10);
			}
		}
	if(a == AssignWaiter)
	{
		String x = (String)combobox_waiter.getSelectedItem();
		if(x == "Table 1"){
			if (checkIfFull(Waiters_for_Table_1) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_1,WaiterList);
			Waiters_for_Table_1.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_1,1);
			}
			}
		if(x == "Table 2"){
			if (checkIfFull(Waiters_for_Table_2) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_2,WaiterList);
			Waiters_for_Table_2.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_2,2);
			}
		}
		if(x == "Table 3"){
			if (checkIfFull(Waiters_for_Table_3) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_3,WaiterList);
			Waiters_for_Table_3.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_3,3);
			}
			
		}
		if(x == "Table 4"){
			if (checkIfFull(Waiters_for_Table_4) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_4,WaiterList);
			Waiters_for_Table_4.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_4,4);
			}
			
		}
		if(x == "Table 5"){
			if (checkIfFull(Waiters_for_Table_5) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_5,WaiterList);
			Waiters_for_Table_5.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_5,5);
			}
			
		}
		if(x == "Table 6"){
			if (checkIfFull(Waiters_for_Table_6) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_6,WaiterList);
			Waiters_for_Table_6.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_6,6);
			}
			
		}
		if(x == "Table 7"){
			if (checkIfFull(Waiters_for_Table_7) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_7,WaiterList);
			Waiters_for_Table_7.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_7,7);
			}
			
		}
		if(x == "Table 8"){
			if (checkIfFull(Waiters_for_Table_8) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_8,WaiterList);
			Waiters_for_Table_8.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_8,8);
			}
		}
		if(x == "Table 9"){
			if (checkIfFull(Waiters_for_Table_9) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_9,WaiterList);
			Waiters_for_Table_9.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_9,9);
			}
			
		}
		if(x == "Table 10"){
			if (checkIfFull(Waiters_for_Table_10) == 0 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Max waiters assigned to table! (5 Waiters is max) </html>","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
			removeDuplicatesAndAdd(Waiters_for_Table_10,WaiterList);
			Waiters_for_Table_10.setSelectedItem(WaiterList.getSelectedItem());
			h.CommunicateWaiterStatusChange(Waiters_for_Table_10,10);
			}
			
		}
		
		// Any waiters occupy the table -> Green Indicator. Else -> Red Indicator
		checkIfFull(Waiters_for_Table_1,W_1);
		checkIfFull(Waiters_for_Table_2,W_2);
		checkIfFull(Waiters_for_Table_3,W_3);
		checkIfFull(Waiters_for_Table_4,W_4);
		checkIfFull(Waiters_for_Table_5,W_5);
		checkIfFull(Waiters_for_Table_6,W_6);
		checkIfFull(Waiters_for_Table_7,W_7);
		checkIfFull(Waiters_for_Table_8,W_8);
		checkIfFull(Waiters_for_Table_9,W_9);
		checkIfFull(Waiters_for_Table_10,W_10);
		
	}
	if(a == UnassignWaiter)
	{
		String x = (String)combobox_waiter.getSelectedItem();
		if(x == "Table 1"){
			if (checkIfFull(Waiters_for_Table_1) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_1,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_1,1);
			}
		}
		if(x == "Table 2"){
			if (checkIfFull(Waiters_for_Table_2) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_2,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_2,2);
			}
		}
		if(x == "Table 3"){
			if (checkIfFull(Waiters_for_Table_3) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_3,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_3,3);
			}
		}
		if(x == "Table 4"){
			if (checkIfFull(Waiters_for_Table_4) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_4,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_4,4);
			}
		}
		if(x == "Table 5"){
			if (checkIfFull(Waiters_for_Table_5) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_5,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_5,5);
			}
		}
		if(x == "Table 6"){
			if (checkIfFull(Waiters_for_Table_6) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_6,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_6,6);
			}
		}
		if(x == "Table 7"){
			if (checkIfFull(Waiters_for_Table_7) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_7,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_7,7);
			}
		}
		if(x == "Table 8"){
			if (checkIfFull(Waiters_for_Table_8) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_8,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_8,8);
			}
		}
		if(x == "Table 9"){
			if (checkIfFull(Waiters_for_Table_9) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_9,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_9,9);
			}
		}
		if(x == "Table 10"){
			if (checkIfFull(Waiters_for_Table_10) == 5 ){
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Can't remove waiter! No waiters are assigned to the table! </html>","Error", JOptionPane.ERROR_MESSAGE);
				}
			else {
			removeItem(Waiters_for_Table_10,WaiterList);
			h.CommunicateWaiterStatusChange(Waiters_for_Table_10,10);
			}
		}
		
		// Any waiters occupy the table -> Green Indicator. Else -> Red Indicator
		checkIfFull(Waiters_for_Table_1,W_1);
		checkIfFull(Waiters_for_Table_2,W_2);
		checkIfFull(Waiters_for_Table_3,W_3);
		checkIfFull(Waiters_for_Table_4,W_4);
		checkIfFull(Waiters_for_Table_5,W_5);
		checkIfFull(Waiters_for_Table_6,W_6);
		checkIfFull(Waiters_for_Table_7,W_7);
		checkIfFull(Waiters_for_Table_8,W_8);
		checkIfFull(Waiters_for_Table_9,W_9);
		checkIfFull(Waiters_for_Table_10,W_10);
	
		
	}
	if(a == blinkTimer)
	{	
		counter++;
		for(int i = 0;i < dirtyTables.size();i++){
			if (counter % 2 == 0) {
				((JButton)dirtyTables.get(i)).setBorder(border_YELLOW);
			} else {
				((JButton)dirtyTables.get(i)).setBorder(border_BLACK);
			}
		         
		}
	}
	

	}
	
	/**
	 * This function will add waiters from the initial waiter list to a table, depending
	 * on which individual waiter is selected. If a waiter already exists at a table,
	 * an error will be displayed, and the waiter will not be added. 
	 * 
	 * @return none
	 * @param JComboBox, JComboBox
	 * 
	 */
	
	public void removeDuplicatesAndAdd(JComboBox WaitersAtTables, JComboBox WaitersToBeSelected){
		String a = "-";
		boolean exists = false;
		 for (int index = 0; index < WaitersAtTables.getItemCount() && !exists; index++) { 
			   if (WaitersToBeSelected.getSelectedItem().equals(WaitersAtTables.getItemAt(index))) { 
			     exists = true;
			     JOptionPane.showMessageDialog(rootPanel, "Waiter already exists at selected table!","Error", JOptionPane.ERROR_MESSAGE);
			   }
			 }
			 if (!exists) {
				 for(int i = 0; i <=5; i++){
					 if(WaitersAtTables.getItemAt(i).equals("-")){
						WaitersAtTables.removeItemAt(i);
						WaitersAtTables.addItem((String) WaitersToBeSelected.getSelectedItem());
						 break;
					 }
					 
				 }
		}
	}
	
	/**
	 * This function will remove a waiter at a table, depending on which waiter is 
	 * selected from the initial waiter list.
	 * 
	 * @return none
	 * @param JComboBox, JComboBox
	 * 
	 */
	
	public void removeItem(JComboBox WaitersAtTables, JComboBox WaitersToBeSelected){
		String Selected = (String) WaitersToBeSelected.getSelectedItem();
		for(int index = 0; index < WaitersAtTables.getItemCount();index++){
			if(WaitersAtTables.getItemAt(index).equals(Selected)){
				WaitersAtTables.removeItemAt(index);
				WaitersAtTables.addItem("-"); 
				break;
			}
		}
		WaitersToBeSelected.getSelectedItem();
	}

	/**
	 * This function will set the color of a table to red if it is not red already,
	 * indicating that customers do not occupy the table and if it is already set to 
	 * red, it will throw an error stating that customers have already been unassigned
     * from the table. 
	 * 
	 * @return none 
	 * @param  JButton
	 * 
	 */
	
	public void CheckColorAndSetRed(JButton x ){
		if (x.getBackground() == Color.RED){
				System.out.println("Cannot unassign customer(s) from a table that has no customers!");
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Cannot unassign customer(s) from a table that has no customers! </html>","Error", JOptionPane.ERROR_MESSAGE);
		} else {x.setBackground(Color.RED);}
	}

	/**
	 * This function will set the color of a table to green, indicating that customers	
	 * occupy the table. IF the table is already set to green, an error will be
	 * thrown stating that the table already has customers assigned to it.
	 * 
	 * @return none 
	 * @param JButton
	 * 
	 */
	
	public void CheckColorAndSetGreen(JButton x ){
		if (x.getBackground() == Color.GREEN){
				System.out.println("Customer(s) already assigned to table!");
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Customer(s) already assigned to table! </html>","Error", JOptionPane.ERROR_MESSAGE);
		} else {x.setBackground(Color.GREEN);}
	}

	/**
	 * Checks if the maximum amount of waiters has been assigned to a table already.	
	 * If the maximum has been reached, an indicator (next to the table name) will glow
	 * green, else it will glow red.
	 * 
	 * @return none
	 * @param JComboBox, JButton
	 * 
	 */
	
	public void checkIfFull(JComboBox WaitersAtTables,JButton W){
		if (WaitersAtTables.getItemAt(0).equals("-") && WaitersAtTables.getItemAt(1).equals("-") && WaitersAtTables.getItemAt(2).equals("-")
				&& WaitersAtTables.getItemAt(3).equals("-") && WaitersAtTables.getItemAt(4).equals("-")){
				W.setBackground(Color.RED);
		}else{W.setBackground(Color.GREEN);}
	}

	/**
	 * This function will indicate if a table is marked as dirty in the database.
     * If it is, then a yellow indicator will start to blink at said table, else,
     * the indicator will not blink
	 * 
	 * @return none
	 * @param JButton, Int
	 * 
	 */
	
	public void TableStatusInitialIndicator(JButton Tablenumber,int index){
		Border border_BLACK = new LineBorder(Color.BLACK,3); //Clean
		Border border_YELLOW = new LineBorder(Color.YELLOW,6); //Unclean
		try {
			if(h.returnList("T_Status").get(index).toString().equals("Unclean")){//Tablenumber.setBorder(border_YELLOW);
				if(!dirtyTables.contains(Tablenumber)){
					dirtyTables.add(Tablenumber);
				}
			}
			if(h.returnList("T_Status").get(index).toString().equals("Clean")){
				dirtyTables.remove(Tablenumber);
			}
			if(dirtyTables.isEmpty()){
				blinkTimer.stop();
				counter = 0;
			}
			else{
				blinkTimer.start();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This function will be used to flicker the yellow indicator around a table
	 *  if a table is marked as unclean
	 * 
	 * @return none
	 * @param JButton
	 * 
	 */
	
	public void TableStatusIndicatorFinal(JButton Tablenumber){
		dirtyTables.add(Tablenumber);
		
	}

	/**
	 * This function will check if a table is marked as full. If it is, it will 
	 * return an integer which will later be used in the GUI to test if a maximum
	 * amount of waiters has been reached, so no more waiters can be assigned to
	 * said table.
	 * 
	 * @return int
	 * @param JComboBox
	 * 
	 */
	
	public int checkIfFull(JComboBox Waiters_at_table){
		int counter = 0;
		for(int i  = 0; i < Waiters_at_table.getItemCount();i++){
			if (Waiters_at_table.getItemAt(i).toString().equals("-")){
				counter++;
			}	
		}
		return counter;
	}

	/**
	 * This function is used to push all reserved table indicator buttons to an
	 * array list so that they can later be used for testing. Indiviual buttons
	 * can be pulled from this list by using an index.
	 * 
	 * @return none
	 * @param ArrayList<JButton>
	 * 
	 */
	
	public ArrayList<JButton> createReservedList(){
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		Buttons.add(W_1);Buttons.add(W_2);Buttons.add(W_3);Buttons.add(W_4);Buttons.add(W_5);
		Buttons.add(W_6);Buttons.add(W_7);Buttons.add(W_8);Buttons.add(W_9);Buttons.add(W_10);
		return Buttons;
	}

	/**
	 * This function is used to push all customer table indicator buttons to an
	 * array list so that they can later be used for testing. Indiviual buttons
	 * can be pulled from this list by using an index.
	 * 
	 * @return none 
	 * @param ArrayList<JButton>
	 * 
	 */
	
	public ArrayList<JButton> createCustomerList(){
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		Buttons.add(Table1);Buttons.add(Table2);Buttons.add(Table3);Buttons.add(Table4);Buttons.add(Table5);
		Buttons.add(Table6);Buttons.add(Table7);Buttons.add(Table8);Buttons.add(Table9);Buttons.add(Table10);
		return Buttons;
	}
	

	/**
	 * This function is used to push all initial waiter lists at tables into an
	 * Array List. They can later be pulled from the list via an index.
	 * 
	 * @return none
	 * @param ArrayList<JComboBox>
	 * 
	 */
	
	public ArrayList<JComboBox> createInitialWaiterList(){
		ArrayList<JComboBox> JComboBox = new ArrayList<JComboBox>();
		JComboBox.add(Waiters_for_Table_1);JComboBox.add(Waiters_for_Table_2);JComboBox.add(Waiters_for_Table_3);JComboBox.add(Waiters_for_Table_4);JComboBox.add(Waiters_for_Table_5);
		JComboBox.add(Waiters_for_Table_6);JComboBox.add(Waiters_for_Table_7);JComboBox.add(Waiters_for_Table_8);JComboBox.add(Waiters_for_Table_9);JComboBox.add(Waiters_for_Table_10);
		return JComboBox;
	}
	
	
}
		
	

