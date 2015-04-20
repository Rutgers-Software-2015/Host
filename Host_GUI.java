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
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
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

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
@SuppressWarnings("unused")

public class Host_GUI extends JFrame implements ActionListener{
	//Swing Variables
			private JPanel rootPanel,titlePanel;
			private GradientPanel MainPanel;
			private GradientButton logoutButton;
			public GradientButton Help;
			public GradientButton Message;
			//private GradientButton logoutButton;
			private JLabel titleLabel,dateAndTime;
			//Other Variables
			public Timer timer;
			public JPanel TableStatus;
			public GradientButton AssignWaiter,UnassignWaiter;
			public JButton Table1,Table2,Table3,Table4,Table5,Table6,Table7,Table8,Table9,Table10;
			public GradientButton Assign,Unassign;
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
			public Vector<String> Waiter_List;//Row1,Row2,Row3,Row4,Row5,Row6,Row7,Row8,Row9,Row10;
			
			private Host_Handler h = new Host_Handler();
			
	public Host_GUI() {
		
		super();
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
		logoutButton.setBounds(10, 551, 371, 66);
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
		
		JLabel Title_Status = new JLabel("Change Table Status");
		Title_Status.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Title_Status.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Status.setBounds(408, 13, 371, 58);
		TableStatus.add(Title_Status);
		
		JButton Seperator_horizontal = new JButton("");
		Seperator_horizontal.setEnabled(false);
		Seperator_horizontal.setBounds(0, 473, 1188, 9);
		TableStatus.add(Seperator_horizontal);
		
		JLabel Customer_Title = new JLabel("Assign Customer");
		Customer_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Customer_Title.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Customer_Title.setBounds(0, 13, 307, 58);
		TableStatus.add(Customer_Title);
		
		JLabel Assign_Waiters = new JLabel("Assign Waiters");
		Assign_Waiters.setHorizontalAlignment(SwingConstants.CENTER);
		Assign_Waiters.setFont(new Font("Tahoma", Font.PLAIN, 28));
		Assign_Waiters.setBounds(930, 13, 258, 58);
		TableStatus.add(Assign_Waiters);
		
		Assign = new GradientButton("Assign");
		Assign.addActionListener(this);
		Assign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Assign.setBounds(55, 223, 172, 68);
		TableStatus.add(Assign);
		
		Unassign = new GradientButton("Unassign");
		Unassign.addActionListener(this);
		Unassign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Unassign.setBounds(55, 330, 175, 68);
		TableStatus.add(Unassign);
		
		String[] Tables_for_customer = {"Table 1","Table 2", "Table 3", "Table 4", "Table 5", "Table 6","Table 7","Table 8","Table 9","Table 10"};
		combobox_customer = new JComboBox(Tables_for_customer);
		combobox_customer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		//combobox_customer.setSelectedIndex(0);
		combobox_customer.setBounds(55, 121, 172, 51);
		TableStatus.add(combobox_customer);
		Render(combobox_customer);
		
		String[] Tables_for_waiter = {"Table 1","Table 2", "Table 3", "Table 4", "Table 5", "Table 6","Table 7","Table 8","Table 9","Table 10"};
		combobox_waiter = new JComboBox(Tables_for_waiter);
		combobox_waiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		combobox_waiter.setBounds(990, 121, 151, 51);
		TableStatus.add(combobox_waiter);
		//combobox_waiter.setSelectedIndex(0);
		Render(combobox_waiter);
		
		Waiter_List=new Vector<String>();
		WaiterList = new JComboBox(Waiter_List);
		WaiterList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WaiterList.setBounds(990, 220, 151, 51);
		TableStatus.add(WaiterList);
		TableStatus.setVisible(true);
		Render(WaiterList);
		
		AssignWaiter = new GradientButton("Waiter 1");
		AssignWaiter.setText("Assign Waiter");
		AssignWaiter.addActionListener(this);
		AssignWaiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AssignWaiter.setBounds(974, 312, 187, 45);
		TableStatus.add(AssignWaiter);
		
		UnassignWaiter = new GradientButton("Waiter 2");
		UnassignWaiter.setText("UnassignWaiter");
		UnassignWaiter.addActionListener(this);
		UnassignWaiter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UnassignWaiter.setBounds(974, 384, 187, 45);
		TableStatus.add(UnassignWaiter);
		
		Waiters_for_Table_1 = new JComboBox();
		Waiters_for_Table_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_1.setBounds(266, 170, 186, 37);
		TableStatus.add(Waiters_for_Table_1);
		Render(Waiters_for_Table_1);
		
		Waiters_for_Table_2 = new JComboBox();
		Waiters_for_Table_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_2.setBounds(494, 121, 186, 37);
		TableStatus.add(Waiters_for_Table_2);
		Render(Waiters_for_Table_2);
		
		Waiters_for_Table_3 = new JComboBox();
		Waiters_for_Table_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_3.setBounds(713, 170, 186, 37);
		TableStatus.add(Waiters_for_Table_3);
		Render(Waiters_for_Table_3);
		
		Waiters_for_Table_4 = new JComboBox();
		Waiters_for_Table_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_4.setBounds(267, 270, 186, 37);
		TableStatus.add(Waiters_for_Table_4);
		Render(Waiters_for_Table_4);
		
		Waiters_for_Table_5 = new JComboBox();
		Waiters_for_Table_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_5.setBounds(494, 216, 186, 37);
		TableStatus.add(Waiters_for_Table_5);
		Render(Waiters_for_Table_5);
		
		Waiters_for_Table_6 = new JComboBox();
		Waiters_for_Table_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_6.setBounds(714, 273, 186, 37);
		TableStatus.add(Waiters_for_Table_6);
		Render(Waiters_for_Table_6);
		
		Waiters_for_Table_7 = new JComboBox();
		Waiters_for_Table_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_7.setBounds(267, 374, 186, 37);
		TableStatus.add(Waiters_for_Table_7);
		Render(Waiters_for_Table_7);
		
		Waiters_for_Table_8 = new JComboBox();
		Waiters_for_Table_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_8.setBounds(493, 320, 186, 37);
		TableStatus.add(Waiters_for_Table_8);
		Render(Waiters_for_Table_8);
		
		Waiters_for_Table_9 = new JComboBox();
		Waiters_for_Table_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_9.setBounds(714, 378, 186, 37);
		TableStatus.add(Waiters_for_Table_9);
		Render(Waiters_for_Table_9);
		
		Waiters_for_Table_10 = new JComboBox();
		Waiters_for_Table_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiters_for_Table_10.setBounds(494, 417, 186, 37);
		TableStatus.add(Waiters_for_Table_10);
		Render(Waiters_for_Table_10);
		
		W_1 = new JButton("");
		W_1.setForeground(Color.GREEN);
		W_1.setEnabled(false);
		W_1.setBounds(432, 117, 21, 45);
		TableStatus.add(W_1);
		W_1.setBorder(border);
		
		W_2 = new JButton("");
		W_2.setEnabled(false);
		W_2.setBounds(659, 64, 21, 45);
		TableStatus.add(W_2);
		W_2.setBorder(border);
		
		W_3 = new JButton("");
		W_3.setEnabled(false);
		W_3.setBounds(879, 122, 21, 45);
		TableStatus.add(W_3);
		W_3.setBorder(border);
		
		W_4 = new JButton("");
		W_4.setEnabled(false);
		W_4.setBounds(432, 216, 21, 45);
		TableStatus.add(W_4);
		W_4.setBorder(border);
		
		W_5 = new JButton("");
		W_5.setEnabled(false);
		W_5.setBounds(659, 166, 22, 45);
		TableStatus.add(W_5);
		W_5.setBorder(border);
		
		W_6 = new JButton("");
		W_6.setEnabled(false);
		W_6.setBounds(879, 224, 21, 45);
		TableStatus.add(W_6);
		W_6.setBorder(border);
		
		W_7 = new JButton("");
		W_7.setEnabled(false);
		W_7.setBounds(432, 320, 21, 45);
		TableStatus.add(W_7);
		W_7.setBorder(border);
		
		W_8 = new JButton("");
		W_8.setEnabled(false);
		W_8.setBounds(659, 269, 22, 45);
		TableStatus.add(W_8);
		W_8.setBorder(border);
		
		W_9 = new JButton("");
		W_9.setEnabled(false);
		W_9.setBounds(879, 327, 21, 45);
		TableStatus.add(W_9);
		W_9.setBorder(border);
		
		W_10 = new JButton("");
		W_10.setEnabled(false);
		W_10.setBounds(659, 370, 22, 45);
		TableStatus.add(W_10);
		W_10.setBorder(border);
		
		Table2 = new JButton("Table 2");
		//Table2.setBackground(Color.RED);
		Table2.setEnabled(false);
		Table2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table2.setBounds(494, 64, 166, 45);
		TableStatus.add(Table2);
		Table2.setBorder(border);
		
		Table3 = new JButton("Table 3");
		//Table3.setBackground(Color.RED);
		Table3.setEnabled(false);
		Table3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table3.setBounds(713, 122, 166, 45);
		TableStatus.add(Table3);
		Table3.setBorder(border);
		
		Table4 = new JButton("Table 4");
		//Table4.setBackground(Color.RED);
		Table4.setEnabled(false);
		Table4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table4.setBounds(266, 216, 166, 45);
		TableStatus.add(Table4);
		Table4.setBorder(border);
		
		
		Table5 = new JButton("Table 5");
		//Table5.setBackground(Color.RED);
		Table5.setEnabled(false);
		Table5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table5.setBounds(494, 166, 166, 45);
		TableStatus.add(Table5);
		Table5.setBorder(border);
		
		Table6 = new JButton("Table 6");
		//Table6.setBackground(Color.RED);
		Table6.setEnabled(false);
		Table6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table6.setBounds(713, 224, 166, 45);
		TableStatus.add(Table6);
		Table6.setBorder(border);
		
		Table9 = new JButton("Table 9");
		//Table9.setBackground(Color.RED);
		Table9.setEnabled(false);
		Table9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table9.setBounds(713, 327, 166, 45);
		TableStatus.add(Table9);
		Table9.setBorder(border);
		
		Table7 = new JButton("Table 7");
		//Table7.setBackground(Color.RED);
		Table7.setEnabled(false);
		Table7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table7.setBounds(266, 320, 166, 45);
		TableStatus.add(Table7);
		Table7.setBorder(border);
		
		Table10 = new JButton("Table 10");
		//Table10.setBackground(Color.RED);
		Table10.setEnabled(false);
		Table10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table10.setBounds(494, 370, 166, 45);
		TableStatus.add(Table10);
		Table10.setBorder(border);
		
		
		Table8 = new JButton("Table 8");
		//Table8.setBackground(Color.RED);
		Table8.setEnabled(false);
		Table8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table8.setBounds(493, 269, 166, 45);
		TableStatus.add(Table8);
		Table8.setBorder(border);
		
		Table1 = new JButton("Table 1");
		//Table1.setBackground(Color.RED);
		Table1.setEnabled(false);
		Table1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table1.setBounds(266, 117, 166, 45);
		TableStatus.add(Table1);
		Table1.setBorder(border);
		
		//UIManager.put("ToggleButton.select", Color.GREEN);
		
		// ************************************
		// ************************************
		// End of main definitions (ignore)
		// ************************************
		// ************************************
		
		//test
		
		/*
		 waitersAtRow(0, Row1);
		 waitersAtRow(1, Row2);
		 waitersAtRow(2, Row3);
		 waitersAtRow(3, Row4);
		 waitersAtRow(4, Row5);
		 waitersAtRow(5, Row6);
		 waitersAtRow(6, Row7);
		 waitersAtRow(7, Row8);
		 waitersAtRow(8, Row9);
		 waitersAtRow(9, Row10);
		 */
		//*************************************
		//INITIAL CUSTOMER STATUSES (At table)
		//*************************************
		try {
			if(h.CustomerList().get(0).toString().equals("Occupied")){
				Table1.setBackground(Color.green);
				}else{Table1.setBackground(Color.red);}
			if(h.CustomerList().get(1).toString().equals("Occupied")){
				Table2.setBackground(Color.green);
				}else{Table2.setBackground(Color.red);}
			if(h.CustomerList().get(2).toString().equals("Occupied")){
				Table3.setBackground(Color.green);
				}else{Table3.setBackground(Color.red);}
			if(h.CustomerList().get(3).toString().equals("Occupied")){
				Table4.setBackground(Color.green);
				}else{Table4.setBackground(Color.red);}
			if(h.CustomerList().get(4).toString().equals("Occupied")){
				Table5.setBackground(Color.green);
				}else{Table5.setBackground(Color.red);}
			if(h.CustomerList().get(5).toString().equals("Occupied")){
				Table6.setBackground(Color.green);
				}else{Table6.setBackground(Color.red);}
			if(h.CustomerList().get(6).toString().equals("Occupied")){
				Table7.setBackground(Color.green);
				}else{Table7.setBackground(Color.red);}
			if(h.CustomerList().get(7).toString().equals("Occupied")){
				Table8.setBackground(Color.green);
				}else{Table8.setBackground(Color.red);}
			if(h.CustomerList().get(8).toString().equals("Occupied")){
				Table9.setBackground(Color.green);
				}else{Table9.setBackground(Color.red);}
			if(h.CustomerList().get(9).toString().equals("Occupied")){
				Table10.setBackground(Color.green);
				}else{Table10.setBackground(Color.red);}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		//*************************************
		//INITIAL WAITER INPUT (FROM DATABASE)
		//*************************************
		Waiter_List.add("Jimmy");
		Waiter_List.add("Michael");
		Waiter_List.add("Sarah");
		Waiter_List.add("John");
		Waiter_List.add("Wendy");
		
		//*********************************************
		//INITIAL WAITERS at table (FROM DATABASE)
		//*********************************************

		//addInitialWaiters(Waiters_for_Table_1);
		addInitialWaiters(Waiters_for_Table_1,0);
		addInitialWaiters(Waiters_for_Table_2,1);
		addInitialWaiters(Waiters_for_Table_3,2);
		addInitialWaiters(Waiters_for_Table_4,3);
		addInitialWaiters(Waiters_for_Table_5,4);
		addInitialWaiters(Waiters_for_Table_6,5);
		addInitialWaiters(Waiters_for_Table_7,6);
		addInitialWaiters(Waiters_for_Table_8,7);
		addInitialWaiters(Waiters_for_Table_9,8);
		addInitialWaiters(Waiters_for_Table_10,9);
		
		//*************************************
		//*************************************
		
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
		
		
		Help = new GradientButton("HELP");
		Help.addActionListener(this);
		Help.setText("HELP");
		Help.setFont(Help.getFont().deriveFont(16f));
		Help.setFocusPainted(false);
		Help.setBounds(418, 551, 371, 66);
		MainPanel.add(Help);
		
		Message = new GradientButton("MESSAGE");
		Message.setText("MESSAGE");
		Message.setFont(Message.getFont().deriveFont(16f));
		Message.setFocusPainted(false);
		Message.setBounds(817, 551, 371, 66);
		MainPanel.add(Message);
		
		
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
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
	Object a = e.getSource();
	if(a == logoutButton)
		{
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
			JOptionPane.showMessageDialog(rootPanel, "<htmL>For customer: Select assign to assign a customer to a table, unassign to unassign a customer from a table. <br><br>For waiter: Select a table, then select a waiter to occupy that table. If the indicator glows green, waiters occupy the table. To unnocpy a waiter, simply select the waiter and unassign him/her.<br></html>");
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
			removeDuplicatesAndAdd(Waiters_for_Table_1,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_1,1);
			Waiters_for_Table_1.setSelectedItem(WaiterList.getSelectedItem());
			}
		if(x == "Table 2"){
			removeDuplicatesAndAdd(Waiters_for_Table_2,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_2,2);
			Waiters_for_Table_2.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 3"){
			removeDuplicatesAndAdd(Waiters_for_Table_3,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_3,3);
			Waiters_for_Table_3.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 4"){
			removeDuplicatesAndAdd(Waiters_for_Table_4,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_4,4);
			Waiters_for_Table_4.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 5"){
			removeDuplicatesAndAdd(Waiters_for_Table_5,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_5,5);
			Waiters_for_Table_5.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 6"){
			removeDuplicatesAndAdd(Waiters_for_Table_6,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_6,6);
			Waiters_for_Table_6.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 7"){
			removeDuplicatesAndAdd(Waiters_for_Table_7,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_7,7);
			Waiters_for_Table_7.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 8"){
			removeDuplicatesAndAdd(Waiters_for_Table_8,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_8,8);
			Waiters_for_Table_8.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 9"){
			removeDuplicatesAndAdd(Waiters_for_Table_9,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_9,9);
			Waiters_for_Table_9.setSelectedItem(WaiterList.getSelectedItem());
		}
		if(x == "Table 10"){
			removeDuplicatesAndAdd(Waiters_for_Table_10,WaiterList);
			//CommunicateAssignedWaiter(Waiters_for_Table_10,10);
			Waiters_for_Table_9.setSelectedItem(WaiterList.getSelectedItem());
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
			removeItem(Waiters_for_Table_1,WaiterList);
			//Waiters_for_Table_1.removeItem((String) WaiterList.getSelectedItem());
			//deleteWaiterAtTable(WaiterList,Row1);
			//printVectorContents(Row1);
			//removeContentsForTableFromDatabase(Row1, 1);
			
		}
		if(x == "Table 2"){
			removeItem(Waiters_for_Table_2,WaiterList);
			
		}
		if(x == "Table 3"){
			removeItem(Waiters_for_Table_3,WaiterList);
			
		}
		if(x == "Table 4"){
			removeItem(Waiters_for_Table_4,WaiterList);
			
		}
		if(x == "Table 5"){
			removeItem(Waiters_for_Table_5,WaiterList);
			
		}
		if(x == "Table 6"){
			removeItem(Waiters_for_Table_6,WaiterList);
			
		}
		if(x == "Table 7"){
			removeItem(Waiters_for_Table_7,WaiterList);
			
		}
		if(x == "Table 8"){
			removeItem(Waiters_for_Table_8,WaiterList);
			
		}
		if(x == "Table 9"){
			removeItem(Waiters_for_Table_9,WaiterList);
			
		}
		if(x == "Table 10"){
			removeItem(Waiters_for_Table_10,WaiterList);
			
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
	
	

	}
	
	public void removeDuplicatesAndAdd(JComboBox WaitersAtTables, JComboBox WaitersToBeSelected){
		boolean exists = false;
		 for (int index = 0; index < WaitersAtTables.getItemCount() && !exists; index++) { 
			   if (WaitersToBeSelected.getSelectedItem().equals(WaitersAtTables.getItemAt(index))) { 
			     exists = true;
			     JOptionPane.showMessageDialog(rootPanel, "Waiter already exists at selected table!");
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
	
	public void removeItem(JComboBox WaitersAtTables, JComboBox WaitersToBeSelected){
		String Selected = (String) WaitersToBeSelected.getSelectedItem();
		for(int index = 0; index < WaitersAtTables.getItemCount();index++){
			if(WaitersAtTables.getItemAt(index).equals(Selected)){
				WaitersAtTables.removeItemAt(index);
				WaitersAtTables.addItem("-"); 
				break;
			}
		}
		//WaitersAtTables.removeItem((String) WaitersToBeSelected.getSelectedItem());
	}
	
	public void CheckColorAndSetRed(JButton x ){
		if (x.getBackground() == Color.RED){
				System.out.println("Cannot unassign customer(s) from a table that has no customers!");
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Cannot unassign customer(s) from a table that has no customers! </html>");
		} else {x.setBackground(Color.RED);}
	}
	public void CheckColorAndSetGreen(JButton x ){
		if (x.getBackground() == Color.GREEN){
				System.out.println("Customer(s) already assigned to table!");
				JOptionPane.showMessageDialog(rootPanel, "<htmL> Customer(s) already assigned to table! </html>");
		} else {x.setBackground(Color.GREEN);}
	}
	
	
	
	 public void CommunicateAssignedWaiter(JComboBox Waiters_for_table,int Table_ID){ 
	 if(Waiters_for_table.getItemCount() == 1){
			String NameOfWaiter_1 = Waiters_for_table.getItemAt(0).toString();
			h.updateTablesOccupiedByWaiter(1,Table_ID,NameOfWaiter_1);
	 }
	 if(Waiters_for_table.getItemCount() == 2){
			String NameOfWaiter_2 = Waiters_for_table.getItemAt(1).toString();
			h.updateTablesOccupiedByWaiter(2,Table_ID,NameOfWaiter_2);
	 }
	 if(Waiters_for_table.getItemCount() == 3){
		 	String NameOfWaiter_3 = Waiters_for_table.getItemAt(2).toString();
			h.updateTablesOccupiedByWaiter(3,Table_ID,NameOfWaiter_3);
	 }
	 if(Waiters_for_table.getItemCount() == 4){
			String NameOfWaiter_4 = Waiters_for_table.getItemAt(3).toString();
			h.updateTablesOccupiedByWaiter(4,Table_ID,NameOfWaiter_4);
	 }
	 if(Waiters_for_table.getItemCount() == 5){
			String NameOfWaiter_5 = Waiters_for_table.getItemAt(4).toString();
			h.updateTablesOccupiedByWaiter(5,Table_ID,NameOfWaiter_5);
	 } 
	 }
	 
	 public void CommunicateUnassignedWaiter(JComboBox Waiters_for_table,int Table_ID ){
		
		
	 }
	
	 public void addInitialWaiters(JComboBox WaitersAtTables,int index){
		 try {
				 if(h.Emp_ID_1().get(index) != null){
					 WaitersAtTables.addItem(h.Emp_ID_1().get(index));
				 }
				 if(h.Emp_ID_2().get(index) != null){
					 WaitersAtTables.addItem(h.Emp_ID_2().get(index));
				 }
				 if(h.Emp_ID_3().get(index) != null){
					 WaitersAtTables.addItem(h.Emp_ID_3().get(index));
				 }
				 if(h.Emp_ID_4().get(index) != null){
					 WaitersAtTables.addItem(h.Emp_ID_4().get(index));
				 }
				 if(h.Emp_ID_5().get(index) != null){
					 WaitersAtTables.addItem(h.Emp_ID_5().get(index));
				 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
		 
	 }
	public void WaitersAtRow(int row){
		/*
		try {
			System.out.print(h.Emp_ID_1().elementAt(row).toString());
			System.out.print(", " +h.Emp_ID_2().elementAt(row).toString());
			System.out.print(", " +h.Emp_ID_3().elementAt(row).toString());
			System.out.print(", " +h.Emp_ID_4().elementAt(row).toString());
			System.out.println(", " +h.Emp_ID_5().elementAt(row).toString());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		*/
	}
	public void waitersAtRow(int row, Vector<String> v){
		/*
		try {
			v.add(h.Emp_ID_1().elementAt(row).toString());
			v.add(h.Emp_ID_2().elementAt(row).toString());
			v.add(h.Emp_ID_3().elementAt(row).toString());
			v.add(h.Emp_ID_4().elementAt(row).toString());
			v.add(h.Emp_ID_5().elementAt(row).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public void printVectorContents(Vector<String> v){
		System.out.print("Contents: ");
		for(int i = 0; i < v.size(); i++){
			System.out.print(" " + v.elementAt(i));
		}
		System.out.println();
	}
	
	public void removeContentsForTableFromDatabase(Vector<String> List, int Table){
		String s = (String) WaiterList.getSelectedItem();
		for(int i = 0; i < List.size(); i ++){
			for(int j = 1; j <= 5;j++){
				if(s.equals(List.elementAt(i))){
					h.update("Update Table_Statuses set Emp_ID_"+j+" = '-' where Table_ID = "+Table+";");
				}
				else{i++;}
			}
		}
	}
	
	public void checkIfFull(JComboBox WaitersAtTables,JButton W){
		if (WaitersAtTables.getItemAt(0).equals("-") && WaitersAtTables.getItemAt(1).equals("-") && WaitersAtTables.getItemAt(2).equals("-")
				&& WaitersAtTables.getItemAt(3).equals("-") && WaitersAtTables.getItemAt(4).equals("-")){
				W.setBackground(Color.RED);
		}else{W.setBackground(Color.GREEN);}
	}
	
	
	
	}
		
	

