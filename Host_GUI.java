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
import java.text.DateFormat;
import java.util.Date;

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
import Shared.GUITemplates.SubframeTemplate;
import Shared.Gradients.GradientButton;
import Shared.Gradients.GradientPanel;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
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
			private Timer timer;
			private JPanel TableStatus;
			public JButton Waiter1,Waiter2,Waiter3,Waiter4,Waiter5;
			public JButton Table1,Table2,Table3,Table4,Table5,Table6,Table7,Table8,Table9,Table10;
			public JButton t1w1,t1w2,t1w3,t1w4,t1w5;
			public JButton t2w1,t2w2,t2w3,t2w4,t2w5;
			public JButton t3w1,t3w2,t3w3,t3w4,t3w5;
			public JButton t4w1,t4w2,t4w3,t4w4,t4w5;
			public JButton t5w1,t5w2,t5w3,t5w4,t5w5;
			public JButton t6w1,t6w2,t6w3,t6w4,t6w5;
			public JButton t7w1,t7w2,t7w3,t7w4,t7w5;
			public JButton t8w1,t8w2,t8w3,t8w4,t8w5;
			public JButton t9w1,t9w2,t9w3,t9w4,t9w5;
			public JButton t10w1,t10w2,t10w3,t10w4,t10w5;
			public JButton Assign,Unassign;
			public JComboBox combobox_customer,combobox_waiter;
	public Host_GUI() {
		
		super();
		initialize();
		
	}

	
	private void initialize() {
		this.setTitle("Your GUI");
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
		Assign_Waiters.setBounds(909, 13, 279, 58);
		TableStatus.add(Assign_Waiters);
		
		Assign = new JButton("Assign");
		Assign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Assign.setBounds(55, 223, 172, 68);
		TableStatus.add(Assign);
		
		Unassign = new JButton("Unassign");
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
		combobox_waiter.setBounds(980, 87, 151, 51);
		TableStatus.add(combobox_waiter);
		//combobox_waiter.setSelectedIndex(0);
		Render(combobox_waiter);
		
		Waiter1 = new JButton("Waiter 1");
		Waiter1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiter1.setBounds(980, 166, 151, 45);
		TableStatus.add(Waiter1);
		
		Waiter2 = new JButton("Waiter 2");
		Waiter2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiter2.setBounds(980, 224, 151, 45);
		TableStatus.add(Waiter2);
		
		Waiter3 = new JButton("Waiter 3");
		Waiter3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiter3.setBounds(980, 282, 151, 45);
		TableStatus.add(Waiter3);
		
		Waiter4 = new JButton("Waiter 4");
		Waiter4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiter4.setBounds(980, 341, 151, 45);
		TableStatus.add(Waiter4);
		
		Waiter5 = new JButton("Waiter 5");
		Waiter5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Waiter5.setBounds(980, 399, 151, 45);
		TableStatus.add(Waiter5);
		
		Table1 = new JButton("Table 1");
		Table1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table1.setBounds(493, 87, 187, 45);
		TableStatus.add(Table1);
		
		Table2 = new JButton("Table 2");
		Table2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table2.setBounds(295, 166, 186, 45);
		TableStatus.add(Table2);
		
		Table3 = new JButton("Table 3");
		Table3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table3.setBounds(295, 252, 187, 45);
		TableStatus.add(Table3);
		
		Table4 = new JButton("Table 4");
		Table4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table4.setBounds(295, 330, 186, 51);
		TableStatus.add(Table4);
		
		Table5 = new JButton("Table 5");
		Table5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table5.setBounds(703, 166, 187, 45);
		TableStatus.add(Table5);
		
		Table6 = new JButton("Table 6");
		Table6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table6.setBounds(703, 246, 187, 45);
		TableStatus.add(Table6);
		
		Table7 = new JButton("Table 7");
		Table7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table7.setBounds(703, 327, 187, 51);
		TableStatus.add(Table7);
		
		Table8 = new JButton("Table 8");
		Table8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table8.setBounds(493, 179, 187, 68);
		TableStatus.add(Table8);
		
		Table9 = new JButton("Table 9");
		Table9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table9.setBounds(493, 282, 187, 58);
		TableStatus.add(Table9);
		
		Table10 = new JButton("Table 10");
		Table10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Table10.setBounds(493, 399, 187, 45);
		TableStatus.add(Table10);
		
		t1w1 = new JButton("");
		t1w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1w1.setBounds(493, 134, 37, 18);
		TableStatus.add(t1w1);
		
		t1w2 = new JButton("");
		t1w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1w2.setBounds(530, 134, 37, 18);
		TableStatus.add(t1w2);
		
		t1w3 = new JButton("");
		t1w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1w3.setBounds(569, 134, 37, 18);
		TableStatus.add(t1w3);
		
		t1w4 = new JButton("");
		t1w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1w4.setBounds(606, 134, 37, 18);
		TableStatus.add(t1w4);
		
		t1w5 = new JButton("");
		t1w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t1w5.setBounds(643, 134, 37, 18);
		TableStatus.add(t1w5);
		
		t2w1 = new JButton("");
		t2w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2w1.setBounds(295, 210, 37, 18);
		TableStatus.add(t2w1);
		
		t2w2 = new JButton("");
		t2w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2w2.setBounds(332, 210, 37, 18);
		TableStatus.add(t2w2);
		
		t2w3 = new JButton("");
		t2w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2w3.setBounds(371, 210, 37, 18);
		TableStatus.add(t2w3);
		
		t2w4 = new JButton("");
		t2w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2w4.setBounds(408, 210, 37, 18);
		TableStatus.add(t2w4);
		
		t2w5 = new JButton("");
		t2w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t2w5.setBounds(445, 210, 37, 18);
		TableStatus.add(t2w5);
		
		t3w1 = new JButton("");
		t3w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3w1.setBounds(294, 299, 37, 18);
		TableStatus.add(t3w1);
		
		t3w2 = new JButton("");
		t3w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3w2.setBounds(331, 299, 37, 18);
		TableStatus.add(t3w2);
		
		t3w3 = new JButton("");
		t3w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3w3.setBounds(370, 299, 37, 18);
		TableStatus.add(t3w3);
		
		t3w4 = new JButton("");
		t3w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3w4.setBounds(407, 299, 37, 18);
		TableStatus.add(t3w4);
		
		t3w5 = new JButton("");
		t3w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t3w5.setBounds(444, 299, 37, 18);
		TableStatus.add(t3w5);
		
		t5w1 = new JButton("");
		t5w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5w1.setBounds(703, 210, 37, 18);
		TableStatus.add(t5w1);
		
		t5w2 = new JButton("");
		t5w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5w2.setBounds(740, 210, 37, 18);
		TableStatus.add(t5w2);
		
		t5w3 = new JButton("");
		t5w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5w3.setBounds(779, 210, 37, 18);
		TableStatus.add(t5w3);
		
		t5w4 = new JButton("");
		t5w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5w4.setBounds(816, 210, 37, 18);
		TableStatus.add(t5w4);
		
		t5w5 = new JButton("");
		t5w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t5w5.setBounds(853, 210, 37, 18);
		TableStatus.add(t5w5);
		
		t6w1 = new JButton("");
		t6w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6w1.setBounds(703, 288, 37, 18);
		TableStatus.add(t6w1);
		
		t6w2 = new JButton("");
		t6w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6w2.setBounds(740, 288, 37, 18);
		TableStatus.add(t6w2);
		
		t6w3 = new JButton("");
		t6w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6w3.setBounds(779, 288, 37, 18);
		TableStatus.add(t6w3);
		
		t6w4 = new JButton("");
		t6w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6w4.setBounds(816, 288, 37, 18);
		TableStatus.add(t6w4);
		
		t6w5 = new JButton("");
		t6w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t6w5.setBounds(853, 288, 37, 18);
		TableStatus.add(t6w5);
		
		t7w1 = new JButton("");
		t7w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7w1.setBounds(703, 380, 37, 18);
		TableStatus.add(t7w1);
		
		t7w2 = new JButton("");
		t7w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7w2.setBounds(740, 380, 37, 18);
		TableStatus.add(t7w2);
		
		t7w3 = new JButton("");
		t7w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7w3.setBounds(779, 380, 37, 18);
		TableStatus.add(t7w3);
		
		t7w4 = new JButton("");
		t7w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7w4.setBounds(816, 380, 37, 18);
		TableStatus.add(t7w4);
		
		t7w5 = new JButton("");
		t7w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t7w5.setBounds(853, 380, 37, 18);
		TableStatus.add(t7w5);
		
		t10w1 = new JButton("");
		t10w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t10w1.setBounds(493, 442, 37, 18);
		TableStatus.add(t10w1);
		
		t10w2 = new JButton("");
		t10w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t10w2.setBounds(530, 442, 37, 18);
		TableStatus.add(t10w2);
		
		t10w3 = new JButton("");
		t10w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t10w3.setBounds(569, 442, 37, 18);
		TableStatus.add(t10w3);
		
		t10w4 = new JButton("");
		t10w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t10w4.setBounds(606, 442, 37, 18);
		TableStatus.add(t10w4);
		
		t10w5 = new JButton("");
		t10w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t10w5.setBounds(643, 442, 37, 18);
		TableStatus.add(t10w5);
		
		t4w1 = new JButton("");
		t4w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4w1.setBounds(295, 380, 37, 18);
		TableStatus.add(t4w1);
		
		t4w2 = new JButton("");
		t4w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4w2.setBounds(332, 380, 37, 18);
		TableStatus.add(t4w2);
		
		t4w3 = new JButton("");
		t4w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4w3.setBounds(371, 380, 37, 18);
		TableStatus.add(t4w3);
		
		t4w4 = new JButton("");
		t4w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4w4.setBounds(408, 380, 37, 18);
		TableStatus.add(t4w4);
		
		t4w5 = new JButton("");
		t4w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t4w5.setBounds(445, 380, 37, 18);
		TableStatus.add(t4w5);
		
		t8w1 = new JButton("");
		t8w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8w1.setBounds(493, 251, 37, 18);
		TableStatus.add(t8w1);
		
		t8w2 = new JButton("");
		t8w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8w2.setBounds(530, 251, 37, 18);
		TableStatus.add(t8w2);
		
		t8w3 = new JButton("");
		t8w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8w3.setBounds(569, 251, 37, 18);
		TableStatus.add(t8w3);
		
		t8w4 = new JButton("");
		t8w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8w4.setBounds(606, 251, 37, 18);
		TableStatus.add(t8w4);
		
		t8w5 = new JButton("");
		t8w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t8w5.setBounds(643, 251, 37, 18);
		TableStatus.add(t8w5);
		
		t9w1 = new JButton("");
		t9w1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t9w1.setBounds(493, 346, 37, 18);
		TableStatus.add(t9w1);
		
		t9w2 = new JButton("");
		t9w2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t9w2.setBounds(530, 346, 37, 18);
		TableStatus.add(t9w2);
		
		t9w3 = new JButton("");
		t9w3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t9w3.setBounds(569, 346, 37, 18);
		TableStatus.add(t9w3);
		
		t9w4 = new JButton("");
		t9w4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t9w4.setBounds(606, 346, 37, 18);
		TableStatus.add(t9w4);
		
		t9w5 = new JButton("");
		t9w5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t9w5.setBounds(643, 346, 37, 18);
		TableStatus.add(t9w5);
		TableStatus.setVisible(true);
		
		// ************************************
		// ************************************
		// End of main definitions (ignore)
		// ************************************
		// ************************************
		
		
		UIManager.put("ToggleButton.select", Color.GREEN);
		
		Help = new GradientButton("HELP");
		
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
		
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPanel, "Select a table to toggle its status. Red = Unclean, Green = Clean");
			}
		});
		/*
		combo.addItemListener(new ItemListener(){

	        public void itemStateChanged(ItemEvent e){
	            int ind = combo.getSelectedIndex();
	            System.out.println(ind); 
	            fontSize = Integer.parseInt(fontSizes[ind]);
	            editArea.setFont(new Font("Sans Serif",Font.PLAIN,fontSize));
	        }
	    });
	*/
		
		// Customer Combobox action listener
		
		combobox_customer.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent event){
	        	int ind = combobox_customer.getSelectedIndex();
	        	if(event.getStateChange() == ItemEvent.SELECTED ) {
	        		if(ind == 0){
	        			System.out.println("Table 1");
	        			if (Assign.isSelected()){
	        				System.out.println("Assign");
	        				Table1.setVisible(false);
	        			}
	        		}
	        		
	        	}
	        }
	    });
		
		
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
	
	public void actionPerformed(ActionEvent e) {
	Object a = e.getSource();
	if(a == logoutButton)
		{
			new LoginWindow();
			dispose();
		}
	if(a == timer)
		{
			updateClock();
		}
	if(a == Message)
		{
	
		}
	/*
	if(combobox_customer.getSelectedItem().equals("Table 1")){
		if(Assign.isSelected()){
			Table1.setBackground(Color.green);
		}
	}
	*/
	}
	
	
	public void itemStateChanged(ItemEvent ie){
		int index = combobox_customer.getSelectedIndex();
		System.out.println(index);
	
	}
	
	
	}
		


