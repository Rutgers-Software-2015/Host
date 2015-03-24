package	HostandBusboy;
import ADT.EmployeeHandler;
import HostDefinitions.*;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;

import java.awt.SystemColor;
import javax.swing.Timer;

import javax.swing.UIManager;

@SuppressWarnings("unused")
public class Host_GUI extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JPanel Waiter_status_at_table;
	private JPanel Customer_status_at_table;
	private JPanel Waiter_Status;
	private JPanel Customer_Status;
	private JPanel Select_waiter_to_occupy_table_1;
	private JPanel Select_waiter_to_occupy_table_2;
	private JPanel Select_waiter_to_occupy_table_3;
	private JPanel Select_waiter_to_occupy_table_4;
	private JPanel Select_waiter_to_occupy_table_5;
	private JPanel Select_waiter_to_occupy_table_6;
	private JButton Waiter_1_toggle_1;
	private JButton Table1_w;
	private JButton toggle_w_1;
	private JButton toggle_w_2;
	private JButton toggle_w_3;
	private JButton toggle_w_4;
	private JButton toggle_w_5;
	private JButton toggle_w_6;
	private JButton toggle_c_1;
	private JButton toggle_c_2;
	private JButton toggle_c_3;
	private JButton toggle_c_4;
	private JButton toggle_c_5;
	private JButton toggle_c_6;
	private Timer timer;
	public BusboyProject busboy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Host_GUI window = new Host_GUI();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	
	
	public Host_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		
		//Create a timer to update the clock
		timer = new Timer(500,this);
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
		
		busboy=new BusboyProject();
		//System.out.println("In host: ");
		//System.out.println(busboy.table1_v.Table_Status);
		System.out.println("---------------------------------------------");
		System.out.println("NEW RUN FOR HOST");
		System.out.println("---------------------------------------------");
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 637);
		frame.setSize(900,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Host_GUI = new JPanel();
		Host_GUI.setBackground(UIManager.getColor("Panel.background"));
		frame.getContentPane().add(Host_GUI, "name_270639079158101");
		Host_GUI.setLayout(null);
		
		JLabel TITLE_OF_PROGRAM = new JLabel("Host Interface");
		TITLE_OF_PROGRAM.setForeground(Color.BLUE);
		TITLE_OF_PROGRAM.setFont(new Font("SketchFlow Print", Font.BOLD, 40));
		TITLE_OF_PROGRAM.setHorizontalAlignment(SwingConstants.CENTER);
		TITLE_OF_PROGRAM.setBounds(259, 13, 354, 113);
		Host_GUI.add(TITLE_OF_PROGRAM);
		
		JButton Place_Customer = new JButton("Place Customer");
		Place_Customer.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Place_Customer.setBounds(279, 184, 320, 74);
		Host_GUI.add(Place_Customer);
		
		JButton Send_Waiter = new JButton("Send Waiter");
		Send_Waiter.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Send_Waiter.setBounds(279, 282, 320, 74);
		Host_GUI.add(Send_Waiter);
		
		JButton Logout = new JButton("Logout");
		Logout.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Logout.setBounds(279, 379, 320, 74);
		Host_GUI.add(Logout);
		
		final JPanel Waiter_Status = new JPanel();
		frame.getContentPane().add(Waiter_Status, "name_270641016937602");
		Waiter_Status.setLayout(null);
		
		JLabel Waiter_Status_title = new JLabel("Waiter Status");
		Waiter_Status_title.setForeground(Color.BLUE);
		Waiter_Status_title.setHorizontalAlignment(SwingConstants.CENTER);
		Waiter_Status_title.setFont(new Font("Segoe Print", Font.BOLD, 36));
		Waiter_Status_title.setBounds(305, 39, 273, 44);
		Waiter_Status.add(Waiter_Status_title);
		
		JButton Next_WS = new JButton("Next ->");
		Next_WS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Next_WS.setBounds(652, 28, 180, 74);
		Waiter_Status.add(Next_WS);
		
		JButton Previous_WS = new JButton("<- Previous");
		Previous_WS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previous_WS.setBounds(51, 28, 180, 74);
		Waiter_Status.add(Previous_WS);
		
		JButton Table1_w = new JButton("");
		Table1_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table1_w.setEnabled(false);
		Table1_w.setBackground(Color.RED);
		Table1_w.setBounds(51, 255, 180, 25);
		Waiter_Status.add(Table1_w);
		
		JButton Table2_w = new JButton("");
		Table2_w.setEnabled(false);
		Table2_w.setBackground(Color.RED);
		Table2_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table2_w.setBounds(355, 255, 180, 25);
		Waiter_Status.add(Table2_w);
		
		JButton Table3_w = new JButton("");
		Table3_w.setEnabled(false);
		Table3_w.setBackground(Color.RED);
		Table3_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table3_w.setBounds(652, 255, 180, 25);
		Waiter_Status.add(Table3_w);
		
		JButton Table4_w = new JButton("");
		Table4_w.setEnabled(false);
		Table4_w.setBackground(Color.RED);
		Table4_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table4_w.setBounds(51, 391, 180, 25);
		Waiter_Status.add(Table4_w);
		
		JButton Table5_w = new JButton("");
		Table5_w.setEnabled(false);
		Table5_w.setBackground(Color.RED);
		Table5_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table5_w.setBounds(355, 391, 180, 25);
		Waiter_Status.add(Table5_w);
		
		JButton Table6_w = new JButton("");
		Table6_w.setEnabled(false);
		Table6_w.setBackground(Color.RED);

		Table6_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table6_w.setBounds(652, 391, 180, 25);
		Waiter_Status.add(Table6_w);
		
		JButton Help_w = new JButton("Help");
		Help_w.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Help_w.setBounds(196, 448, 180, 74);
		Waiter_Status.add(Help_w);

		JToggleButton toggle_w_1 = new JToggleButton("Table 1");
		toggle_w_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_1.setBounds(51, 185, 180, 74);
		Waiter_Status.add(toggle_w_1);
		
		JToggleButton toggle_w_2 = new JToggleButton("Table 2");
		toggle_w_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_2.setBounds(355, 185, 180, 74);
		Waiter_Status.add(toggle_w_2);
		
		JToggleButton toggle_w_3 = new JToggleButton("Table 3");
		toggle_w_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_3.setBounds(652, 185, 180, 74);
		Waiter_Status.add(toggle_w_3);
		
		JToggleButton toggle_w_4 = new JToggleButton("Table 4");
		toggle_w_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_4.setBounds(51, 319, 180, 74);
		Waiter_Status.add(toggle_w_4);
		
		JToggleButton toggle_w_5 = new JToggleButton("Table 5");
		toggle_w_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_5.setBounds(355, 319, 180, 74);
		Waiter_Status.add(toggle_w_5);
		
		JToggleButton toggle_w_6 = new JToggleButton("Table 6");
		toggle_w_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_w_6.setBounds(652, 319, 180, 82);
		Waiter_Status.add(toggle_w_6);
		
		JButton Return_WS = new JButton("Return");
		Return_WS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Return_WS.setBounds(511, 448, 180, 74);
		Waiter_Status.add(Return_WS);
		
		JButton INDICATOR_G_WS_2 = new JButton("");
		INDICATOR_G_WS_2.setEnabled(false);
		INDICATOR_G_WS_2.setBackground(Color.GREEN);
		INDICATOR_G_WS_2.setBounds(355, 255, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_2);
		
		JButton INDICATOR_G_WS_3 = new JButton("");
		INDICATOR_G_WS_3.setEnabled(false);
		INDICATOR_G_WS_3.setBackground(Color.GREEN);
		INDICATOR_G_WS_3.setBounds(652, 255, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_3);
		
		JButton INDICATOR_G_WS_4 = new JButton("");
		INDICATOR_G_WS_4.setEnabled(false);
		INDICATOR_G_WS_4.setBackground(Color.GREEN);
		INDICATOR_G_WS_4.setBounds(51, 391, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_4);
		
		JButton INDICATOR_G_WS_5 = new JButton("");
		INDICATOR_G_WS_5.setEnabled(false);
		INDICATOR_G_WS_5.setBackground(Color.GREEN);
		INDICATOR_G_WS_5.setBounds(355, 391, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_5);
		
		JButton INDICATOR_G_WS_6 = new JButton("");
		INDICATOR_G_WS_6.setEnabled(false);
		INDICATOR_G_WS_6.setBackground(Color.GREEN);
		INDICATOR_G_WS_6.setBounds(652, 391, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_6);
		
		JButton INDICATOR_G_WS_1 = new JButton("");
		INDICATOR_G_WS_1.setEnabled(false);
		INDICATOR_G_WS_1.setBackground(Color.GREEN);
		INDICATOR_G_WS_1.setBounds(51, 255, 180, 25);
		Waiter_Status.add(INDICATOR_G_WS_1);
		
		final JPanel Customer_Status = new JPanel();
		frame.getContentPane().add(Customer_Status, "name_270645762121747");
		Customer_Status.setLayout(null);
		
		JLabel Customer_status_title = new JLabel("Customer Status");
		Customer_status_title.setForeground(Color.BLUE);
		Customer_status_title.setHorizontalAlignment(SwingConstants.CENTER);
		Customer_status_title.setFont(new Font("Segoe Print", Font.BOLD, 36));
		Customer_status_title.setBounds(285, 45, 325, 44);
		Customer_Status.add(Customer_status_title);
		
		JButton Table_1_c = new JButton("");
		Table_1_c.setEnabled(false);
		Table_1_c.setBackground(new Color(255, 51, 0));
		Table_1_c.setForeground(new Color(255, 51, 0));
		Table_1_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_1_c.setBounds(43, 203, 180, 25);
		Customer_Status.add(Table_1_c);
		
		JButton Table_2_c = new JButton("");
		Table_2_c.setEnabled(false);
		Table_2_c.setBackground(new Color(255, 51, 0));
		Table_2_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_2_c.setBounds(345, 203, 180, 25);
		Customer_Status.add(Table_2_c);
		
		JButton Table_3_c = new JButton("");
		Table_3_c.setEnabled(false);
		Table_3_c.setBackground(new Color(255, 51, 0));
		Table_3_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_3_c.setBounds(638, 204, 180, 25);
		Customer_Status.add(Table_3_c);
		
		JButton Table_4_c = new JButton("");
		Table_4_c.setEnabled(false);
		Table_4_c.setBackground(new Color(255, 51, 0));
		Table_4_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_4_c.setBounds(43, 340, 180, 25);
		Customer_Status.add(Table_4_c);
		
		JButton Table_5_c = new JButton("");
		Table_5_c.setEnabled(false);
		Table_5_c.setBackground(new Color(255, 51, 0));
		Table_5_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_5_c.setBounds(345, 339, 180, 25);
		Customer_Status.add(Table_5_c);
		
		JButton Table_6_c = new JButton("");
		Table_6_c.setEnabled(false);
		Table_6_c.setBackground(new Color(255, 51, 0));
		Table_6_c.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Table_6_c.setBounds(638, 339, 180, 25);
		Customer_Status.add(Table_6_c);
		
		JButton Help_CS = new JButton("Help");
		Help_CS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Help_CS.setBounds(187, 426, 180, 74);
		Customer_Status.add(Help_CS);
		
		JButton Return_CS = new JButton("Return");
		Return_CS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Return_CS.setBounds(471, 426, 180, 74);
		Customer_Status.add(Return_CS);
		
		JButton Previous_CS = new JButton("<- Previous");
		Previous_CS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previous_CS.setBounds(43, 29, 180, 74);
		Customer_Status.add(Previous_CS);
		
		JButton Next_CS = new JButton("Next ->");
		Next_CS.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Next_CS.setBounds(638, 29, 180, 74);
		Customer_Status.add(Next_CS);
		
		JToggleButton toggle_c_1 = new JToggleButton("Table 1");
		toggle_c_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_1.setBounds(43, 132, 180, 74);
		Customer_Status.add(toggle_c_1);
		
		JToggleButton toggle_c_2 = new JToggleButton("Table 2");
		toggle_c_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_2.setBounds(345, 132, 180, 74);
		Customer_Status.add(toggle_c_2);
		
		JToggleButton toggle_c_3 = new JToggleButton("Table 3");
		toggle_c_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_3.setBounds(638, 132, 180, 74);
		Customer_Status.add(toggle_c_3);
		
		JToggleButton toggle_c_4 = new JToggleButton("Table 4");
		toggle_c_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_4.setBounds(43, 263, 180, 80);
		Customer_Status.add(toggle_c_4);
		
		JToggleButton toggle_c_5 = new JToggleButton("Table 5");
		toggle_c_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_5.setBounds(345, 263, 180, 80);
		Customer_Status.add(toggle_c_5);
		
		JToggleButton toggle_c_6 = new JToggleButton("Table 6");
		toggle_c_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		toggle_c_6.setBounds(638, 263, 180, 80);
		Customer_Status.add(toggle_c_6);
		
		JButton INDICATOR_G_CS_1 = new JButton("");
		INDICATOR_G_CS_1.setEnabled(false);
		INDICATOR_G_CS_1.setBackground(Color.GREEN);
		INDICATOR_G_CS_1.setBounds(43, 203, 180, 25);
		Customer_Status.add(INDICATOR_G_CS_1);
		
		JButton INDICATOR_G_CS_2 = new JButton("");
		INDICATOR_G_CS_2.setEnabled(false);
		INDICATOR_G_CS_2.setBackground(Color.GREEN);
		INDICATOR_G_CS_2.setBounds(345, 203, 180, 25);
		Customer_Status.add(INDICATOR_G_CS_2);
		
		JButton INDICATOR_G_CS_3 = new JButton("");
		INDICATOR_G_CS_3.setEnabled(false);
		INDICATOR_G_CS_3.setBackground(Color.GREEN);
		INDICATOR_G_CS_3.setBounds(638, 203, 180, 25);
		Customer_Status.add(INDICATOR_G_CS_3);
		
		JButton INDICATOR_G_CS_4 = new JButton("");
		INDICATOR_G_CS_4.setEnabled(false);
		INDICATOR_G_CS_4.setBackground(Color.GREEN);
		INDICATOR_G_CS_4.setBounds(43, 339, 180, 25);
		Customer_Status.add(INDICATOR_G_CS_4);
		
		JButton INDICATOR_G_CS_5 = new JButton("");
		INDICATOR_G_CS_5.setEnabled(false);
		INDICATOR_G_CS_5.setBackground(Color.GREEN);
		INDICATOR_G_CS_5.setBounds(345, 338, 180, 25);
		Customer_Status.add(INDICATOR_G_CS_5);
		
		JButton INDICATOR_G_CS_6 = new JButton("");
		INDICATOR_G_CS_6.setEnabled(false);
		INDICATOR_G_CS_6.setBackground(Color.GREEN);
		INDICATOR_G_CS_6.setBounds(638, 340, 180, 24);
		Customer_Status.add(INDICATOR_G_CS_6);
		
		final JPanel Customer_status_at_table = new JPanel();
		frame.getContentPane().add(Customer_status_at_table, "name_270647812657070");
		Customer_status_at_table.setLayout(null);
		
		JLabel Title_CSAT = new JLabel("Customer status at table");
		Title_CSAT.setForeground(Color.BLUE);
		Title_CSAT.setBackground(Color.BLUE);
		Title_CSAT.setHorizontalAlignment(SwingConstants.CENTER);
		Title_CSAT.setFont(new Font("Segoe Print", Font.BOLD, 36));
		Title_CSAT.setBounds(224, 33, 498, 44);
		Customer_status_at_table.add(Title_CSAT);
		
		JButton Occupied_Customer = new JButton("Table occupied by customer");
		Occupied_Customer.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Occupied_Customer.setBounds(234, 182, 401, 74);
		Customer_status_at_table.add(Occupied_Customer);
		
		JButton Unoccupied_Customer = new JButton("Table unoccupied by customer");
		Unoccupied_Customer.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Unoccupied_Customer.setBounds(234, 309, 423, 74);
		Customer_status_at_table.add(Unoccupied_Customer);
		
		JButton Return_cst = new JButton("Return");
		Return_cst.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Return_cst.setBounds(12, 22, 200, 74);
		Customer_status_at_table.add(Return_cst);
		
		final JPanel Select_waiter_to_occupy_table_1 = new JPanel();
		frame.getContentPane().add(Select_waiter_to_occupy_table_1, "name_276628794591931");
		Select_waiter_to_occupy_table_1.setLayout(null);
		
		JLabel lblSelectWaiterTo = new JLabel("Select Waiter: Table 1");
		lblSelectWaiterTo.setForeground(Color.BLUE);
		lblSelectWaiterTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTo.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTo.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_1.add(lblSelectWaiterTo);
		
		JButton Returnkey_1 = new JButton("Return");
		Returnkey_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_1.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_1.add(Returnkey_1);
		
		JToggleButton WaiterT_1_1 = new JToggleButton("Waiter 1");
		WaiterT_1_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_1_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_1.add(WaiterT_1_1);
		
		JToggleButton WaiterT_1_2 = new JToggleButton("Waiter 2");
		WaiterT_1_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_1_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_1.add(WaiterT_1_2);
		
		JToggleButton WaiterT_1_3 = new JToggleButton("Waiter 3");
		WaiterT_1_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_1_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_1.add(WaiterT_1_3);
		
		JButton Waiter_1_toggle_1 = new JButton("");
		Waiter_1_toggle_1.setEnabled(false);
		Waiter_1_toggle_1.setBackground(Color.RED);
		Waiter_1_toggle_1.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Waiter_1_toggle_1);
		
		JButton Waiter_2_toggle_1 = new JButton("");
		Waiter_2_toggle_1.setEnabled(false);
		Waiter_2_toggle_1.setBackground(Color.RED);
		Waiter_2_toggle_1.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Waiter_2_toggle_1);
		
		JButton Waiter_3_toggle_1 = new JButton("");
		Waiter_3_toggle_1.setEnabled(false);
		Waiter_3_toggle_1.setBackground(Color.RED);
		Waiter_3_toggle_1.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Waiter_3_toggle_1);
		
		JButton Previouskey_1 = new JButton("<- Previous");
		Previouskey_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_1.setBounds(22, 29, 181, 74);
		Select_waiter_to_occupy_table_1.add(Previouskey_1);
		
		JButton Nextkey_1 = new JButton("Next ->");
		Nextkey_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_1.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_1.add(Nextkey_1);
		
		JButton Helpkey_1 = new JButton("Help");
		Helpkey_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_1.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_1.add(Helpkey_1);
		
		JButton Green1a = new JButton("");
		Green1a.setEnabled(false);
		Green1a.setBackground(Color.GREEN);
		Green1a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Green1a);
		
		JButton Green1b = new JButton("");
		Green1b.setEnabled(false);
		Green1b.setBackground(Color.GREEN);
		Green1b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Green1b);
		
		JButton Green1c = new JButton("");
		Green1c.setEnabled(false);
		Green1c.setBackground(Color.GREEN);
		Green1c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_1.add(Green1c);
		
		final JPanel Select_waiter_to_occupy_table_2 = new JPanel();
		Select_waiter_to_occupy_table_2.setLayout(null);
		frame.getContentPane().add(Select_waiter_to_occupy_table_2, "name_322719236682902");
		
		JLabel lblSelectWaiterTable = new JLabel("Select Waiter: Table 2");
		lblSelectWaiterTable.setForeground(Color.BLUE);
		lblSelectWaiterTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTable.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTable.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_2.add(lblSelectWaiterTable);
		
		JButton Returnkey_2 = new JButton("Return");
		Returnkey_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_2.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_2.add(Returnkey_2);
		
		JToggleButton WaiterT_2_1 = new JToggleButton("Waiter 1");
		WaiterT_2_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_2_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_2.add(WaiterT_2_1);
		
		JToggleButton WaiterT_2_2 = new JToggleButton("Waiter 2");
		WaiterT_2_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_2_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_2.add(WaiterT_2_2);
		
		JToggleButton WaiterT_2_3 = new JToggleButton("Waiter 3");
		WaiterT_2_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_2_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_2.add(WaiterT_2_3);
		
		JButton Waiter_1_toggle_2 = new JButton("");
		Waiter_1_toggle_2.setEnabled(false);
		Waiter_1_toggle_2.setBackground(Color.RED);
		Waiter_1_toggle_2.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Waiter_1_toggle_2);
		
		JButton Waiter_2_toggle_2 = new JButton("");
		Waiter_2_toggle_2.setEnabled(false);
		Waiter_2_toggle_2.setBackground(Color.RED);
		Waiter_2_toggle_2.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Waiter_2_toggle_2);
		
		JButton Waiter_3_toggle_2 = new JButton("");
		Waiter_3_toggle_2.setEnabled(false);
		Waiter_3_toggle_2.setBackground(Color.RED);
		Waiter_3_toggle_2.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Waiter_3_toggle_2);
		
		JButton Previouskey_2 = new JButton("<- Previous");
		Previouskey_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_2.setBounds(22, 29, 180, 74);
		Select_waiter_to_occupy_table_2.add(Previouskey_2);
		
		JButton Nextkey_2 = new JButton("Next ->");
		Nextkey_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_2.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_2.add(Nextkey_2);
		
		JButton Helpkey_2 = new JButton("Help");
		Helpkey_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_2.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_2.add(Helpkey_2);
		
		JButton Green2a = new JButton("");
		Green2a.setEnabled(false);
		Green2a.setBackground(Color.GREEN);
		Green2a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Green2a);
		
		JButton Green2b = new JButton("");
		Green2b.setEnabled(false);
		Green2b.setBackground(Color.GREEN);
		Green2b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Green2b);
		
		JButton Green2c = new JButton("");
		Green2c.setEnabled(false);
		Green2c.setBackground(Color.GREEN);
		Green2c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_2.add(Green2c);
		
		final JPanel Select_waiter_to_occupy_table_3 = new JPanel();
		Select_waiter_to_occupy_table_3.setLayout(null);
		frame.getContentPane().add(Select_waiter_to_occupy_table_3, "name_322747318582867");
		
		JLabel lblSelectWaiterTable_1 = new JLabel("Select Waiter: Table 3");
		lblSelectWaiterTable_1.setForeground(Color.BLUE);
		lblSelectWaiterTable_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTable_1.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTable_1.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_3.add(lblSelectWaiterTable_1);
		
		JButton Returnkey_3 = new JButton("Return");
		Returnkey_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_3.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_3.add(Returnkey_3);
		
		JToggleButton Waiter_T_3_1 = new JToggleButton("Waiter 1");
		Waiter_T_3_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_3_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_3.add(Waiter_T_3_1);
		
		JToggleButton Waiter_T_3_2 = new JToggleButton("Waiter 2");
		Waiter_T_3_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_3_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_3.add(Waiter_T_3_2);
		
		JToggleButton Waiter_T_3_3 = new JToggleButton("Waiter 3");
		Waiter_T_3_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_3_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_3.add(Waiter_T_3_3);
		
		JButton Waiter_1_toggle_3 = new JButton("");
		Waiter_1_toggle_3.setEnabled(false);
		Waiter_1_toggle_3.setBackground(Color.RED);
		Waiter_1_toggle_3.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Waiter_1_toggle_3);
		
		JButton Waiter_2_toggle_3 = new JButton("");
		Waiter_2_toggle_3.setEnabled(false);
		Waiter_2_toggle_3.setBackground(Color.RED);
		Waiter_2_toggle_3.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Waiter_2_toggle_3);
		
		JButton Waiter_3_toggle_3 = new JButton("");
		Waiter_3_toggle_3.setEnabled(false);
		Waiter_3_toggle_3.setBackground(Color.RED);
		Waiter_3_toggle_3.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Waiter_3_toggle_3);
		
		JButton Previouskey_3 = new JButton("<- Previous");
		Previouskey_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_3.setBounds(22, 29, 180, 74);
		Select_waiter_to_occupy_table_3.add(Previouskey_3);
		
		JButton Nextkey_3 = new JButton("Next ->");
		Nextkey_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_3.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_3.add(Nextkey_3);
		
		JButton Helpkey_3 = new JButton("Help");
		Helpkey_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_3.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_3.add(Helpkey_3);
		
		JButton Green3a = new JButton("");
		Green3a.setEnabled(false);
		Green3a.setBackground(Color.GREEN);
		Green3a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Green3a);
		
		JButton Green3b = new JButton("");
		Green3b.setEnabled(false);
		Green3b.setBackground(Color.GREEN);
		Green3b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Green3b);
		
		JButton Green3c = new JButton("");
		Green3c.setEnabled(false);
		Green3c.setBackground(Color.GREEN);
		Green3c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_3.add(Green3c);
		
		final JPanel Select_waiter_to_occupy_table_4 = new JPanel();
		Select_waiter_to_occupy_table_4.setLayout(null);
		frame.getContentPane().add(Select_waiter_to_occupy_table_4, "name_322839590812485");
		
		JLabel lblSelectWaiterTable_2 = new JLabel("Select Waiter: Table 4");
		lblSelectWaiterTable_2.setForeground(Color.BLUE);
		lblSelectWaiterTable_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTable_2.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTable_2.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_4.add(lblSelectWaiterTable_2);
		
		JButton Returnkey_4 = new JButton("Return");
		Returnkey_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_4.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_4.add(Returnkey_4);
		
		JToggleButton WaiterT_4_1 = new JToggleButton("Waiter 1");
		WaiterT_4_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_4_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_4.add(WaiterT_4_1);
		
		JToggleButton WaiterT_4_2 = new JToggleButton("Waiter 2");
		WaiterT_4_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_4_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_4.add(WaiterT_4_2);
		
		JToggleButton WaiterT_4_3 = new JToggleButton("Waiter 3");
		WaiterT_4_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_4_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_4.add(WaiterT_4_3);
		
		JButton Waiter_1_toggle_4 = new JButton("");
		Waiter_1_toggle_4.setEnabled(false);
		Waiter_1_toggle_4.setBackground(Color.RED);
		Waiter_1_toggle_4.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Waiter_1_toggle_4);
		
		JButton Waiter_2_toggle_4 = new JButton("");
		Waiter_2_toggle_4.setEnabled(false);
		Waiter_2_toggle_4.setBackground(Color.RED);
		Waiter_2_toggle_4.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Waiter_2_toggle_4);
		
		JButton Waiter_3_toggle_4 = new JButton("");
		Waiter_3_toggle_4.setEnabled(false);
		Waiter_3_toggle_4.setBackground(Color.RED);
		Waiter_3_toggle_4.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Waiter_3_toggle_4);
		
		JButton Previouskey_4 = new JButton("<- Previous");
		Previouskey_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_4.setBounds(22, 29, 180, 74);
		Select_waiter_to_occupy_table_4.add(Previouskey_4);
		
		JButton Nextkey_4 = new JButton("Next ->");
		Nextkey_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_4.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_4.add(Nextkey_4);
		
		JButton Helpkey_4 = new JButton("Help");
		Helpkey_4.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_4.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_4.add(Helpkey_4);
		
		JButton Green4a = new JButton("");
		Green4a.setEnabled(false);
		Green4a.setBackground(Color.GREEN);
		Green4a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Green4a);
		
		JButton Green4b = new JButton("");
		Green4b.setEnabled(false);
		Green4b.setBackground(Color.GREEN);
		Green4b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Green4b);
		
		JButton Green4c = new JButton("");
		Green4c.setEnabled(false);
		Green4c.setBackground(Color.GREEN);
		Green4c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_4.add(Green4c);
		
		final JPanel Select_waiter_to_occupy_table_5 = new JPanel();
		Select_waiter_to_occupy_table_5.setLayout(null);
		frame.getContentPane().add(Select_waiter_to_occupy_table_5, "name_322846967922034");
		
		JLabel lblSelectWaiterTable_3 = new JLabel("Select Waiter: Table 5");
		lblSelectWaiterTable_3.setForeground(Color.BLUE);
		lblSelectWaiterTable_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTable_3.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTable_3.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_5.add(lblSelectWaiterTable_3);
		
		JButton Returnkey_5 = new JButton("Return");
		Returnkey_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_5.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_5.add(Returnkey_5);
		
		JToggleButton Waiter_T_5_1 = new JToggleButton("Waiter 1");
		Waiter_T_5_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_5_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_5.add(Waiter_T_5_1);
		
		JToggleButton Waiter_T_5_2 = new JToggleButton("Waiter 2");
		Waiter_T_5_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_5_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_5.add(Waiter_T_5_2);
		
		JToggleButton Waiter_T_5_3 = new JToggleButton("Waiter 3");
		Waiter_T_5_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Waiter_T_5_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_5.add(Waiter_T_5_3);
		
		JButton Waiter_1_toggle_5 = new JButton("");
		Waiter_1_toggle_5.setEnabled(false);
		Waiter_1_toggle_5.setBackground(Color.RED);
		Waiter_1_toggle_5.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Waiter_1_toggle_5);
		
		JButton Waiter_2_toggle_5 = new JButton("");
		Waiter_2_toggle_5.setEnabled(false);
		Waiter_2_toggle_5.setBackground(Color.RED);
		Waiter_2_toggle_5.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Waiter_2_toggle_5);
		
		JButton Waiter_3_toggle_5 = new JButton("");
		Waiter_3_toggle_5.setEnabled(false);
		Waiter_3_toggle_5.setBackground(Color.RED);
		Waiter_3_toggle_5.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Waiter_3_toggle_5);
		
		JButton Previouskey_5 = new JButton("<- Previous");
		Previouskey_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_5.setBounds(22, 29, 180, 74);
		Select_waiter_to_occupy_table_5.add(Previouskey_5);
		
		JButton Nextkey_5 = new JButton("Next ->");
		Nextkey_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_5.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_5.add(Nextkey_5);
		
		JButton Helpkey_5 = new JButton("Help");
		Helpkey_5.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_5.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_5.add(Helpkey_5);
		
		JButton Green5a = new JButton("");
		Green5a.setEnabled(false);
		Green5a.setBackground(Color.GREEN);
		Green5a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Green5a);
		
		JButton Green5b = new JButton("");
		Green5b.setEnabled(false);
		Green5b.setBackground(Color.GREEN);
		Green5b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Green5b);
		
		JButton Green5c = new JButton("");
		Green5c.setEnabled(false);
		Green5c.setBackground(Color.GREEN);
		Green5c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_5.add(Green5c);
		
		final JPanel Select_waiter_to_occupy_table_6 = new JPanel();
		Select_waiter_to_occupy_table_6.setLayout(null);
		frame.getContentPane().add(Select_waiter_to_occupy_table_6, "name_322870956571527");
		
		JLabel lblSelectWaiterTable_4 = new JLabel("Select Waiter: Table 6");
		lblSelectWaiterTable_4.setForeground(Color.BLUE);
		lblSelectWaiterTable_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectWaiterTable_4.setFont(new Font("Segoe Print", Font.BOLD, 36));
		lblSelectWaiterTable_4.setBounds(143, 40, 606, 44);
		Select_waiter_to_occupy_table_6.add(lblSelectWaiterTable_4);
		
		JButton Returnkey_6 = new JButton("Return");
		Returnkey_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Returnkey_6.setBounds(187, 382, 200, 74);
		Select_waiter_to_occupy_table_6.add(Returnkey_6);
		
		JToggleButton WaiterT_6_1 = new JToggleButton("Waiter 1");
		WaiterT_6_1.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_6_1.setBounds(42, 199, 180, 74);
		Select_waiter_to_occupy_table_6.add(WaiterT_6_1);
		
		JToggleButton WaiterT_6_2 = new JToggleButton("Waiter 2");
		WaiterT_6_2.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_6_2.setBounds(345, 199, 180, 74);
		Select_waiter_to_occupy_table_6.add(WaiterT_6_2);
		
		JToggleButton WaiterT_6_3 = new JToggleButton("Waiter 3");
		WaiterT_6_3.setFont(new Font("Segoe Print", Font.BOLD, 26));
		WaiterT_6_3.setBounds(639, 199, 180, 74);
		Select_waiter_to_occupy_table_6.add(WaiterT_6_3);
		
		JButton Waiter_1_toggle_6 = new JButton("");
		Waiter_1_toggle_6.setEnabled(false);
		Waiter_1_toggle_6.setBackground(Color.RED);
		Waiter_1_toggle_6.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Waiter_1_toggle_6);
		
		JButton Waiter_2_toggle_6 = new JButton("");
		Waiter_2_toggle_6.setEnabled(false);
		Waiter_2_toggle_6.setBackground(Color.RED);
		Waiter_2_toggle_6.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Waiter_2_toggle_6);
		
		JButton Waiter_3_toggle_6 = new JButton("");
		Waiter_3_toggle_6.setEnabled(false);
		Waiter_3_toggle_6.setBackground(Color.RED);
		Waiter_3_toggle_6.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Waiter_3_toggle_6);
		
		JButton Previouskey_6 = new JButton("<- Previous");
		Previouskey_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Previouskey_6.setBounds(22, 29, 180, 74);
		Select_waiter_to_occupy_table_6.add(Previouskey_6);
		
		JButton Nextkey_6 = new JButton("Next ->");
		Nextkey_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Nextkey_6.setBounds(698, 29, 161, 74);
		Select_waiter_to_occupy_table_6.add(Nextkey_6);
		
		JButton Helpkey_6 = new JButton("Help");
		Helpkey_6.setFont(new Font("Segoe Print", Font.BOLD, 26));
		Helpkey_6.setBounds(506, 382, 200, 74);
		Select_waiter_to_occupy_table_6.add(Helpkey_6);
		
		JButton Green6a = new JButton("");
		Green6a.setEnabled(false);
		Green6a.setBackground(Color.GREEN);
		Green6a.setBounds(42, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Green6a);
		
		JButton Green6b = new JButton("");
		Green6b.setEnabled(false);
		Green6b.setBackground(Color.GREEN);
		Green6b.setBounds(345, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Green6b);
		
		JButton Green6c = new JButton("");
		Green6c.setEnabled(false);
		Green6c.setBackground(Color.GREEN);
		Green6c.setBounds(639, 273, 180, 25);
		Select_waiter_to_occupy_table_6.add(Green6c);
		
		/*************************************************/
		/*************************************************/
					/// INITIAL VALUUES ///
		/*************************************************/
		/*************************************************/
		if (busboy.table1_v.Table_enable == false){
			toggle_w_1.setEnabled(false);
			toggle_c_1.setEnabled(false);
		}
		if (busboy.table2_v.Table_enable == false){
			toggle_w_2.setEnabled(false);
			toggle_c_2.setEnabled(false);
		}
		if (busboy.table3_v.Table_enable == false){
			toggle_w_3.setEnabled(false);
			toggle_c_3.setEnabled(false);
		}
		if (busboy.table4_v.Table_enable == false){
			toggle_w_4.setEnabled(false);
			toggle_c_4.setEnabled(false);
		}
		if (busboy.table5_v.Table_enable == false){
			toggle_w_5.setEnabled(false);
			toggle_c_5.setEnabled(false);
		}
		if (busboy.table6_v.Table_enable == false){
			toggle_w_6.setEnabled(false);
			toggle_c_6.setEnabled(false);
		}
		
		System.out.println("INITIAL STATUSES OF TABLES, CUSTOMERS, AND WAITERS");
		System.out.println("");
		if (Table_1_c.isVisible()){
			System.out.println("Table 1: Unoccupied by customer");	
		}
		if (Table_2_c.isVisible()){
			System.out.println("Table 2: Unoccupied by customer");	
		}
		if (Table_3_c.isVisible()){
			System.out.println("Table 3: Unoccupied by customer");	
		}
		if (Table_4_c.isVisible()){
			System.out.println("Table 4: Unoccupied by customer");	
		}
		if (Table_5_c.isVisible()){
			System.out.println("Table 5: Unoccupied by customer");	
		}
		if (Table_6_c.isVisible()){
			System.out.println("Table 6: Unoccupied by customer");	
		}
		System.out.println("");
		if (Table1_w.isVisible()){
			System.out.println("Table 1: Unoccupied by waiter");	
		}
		if (Table2_w.isVisible()){
			System.out.println("Table 2: Unoccupied by waiter");	
		}
		if (Table3_w.isVisible()){
			System.out.println("Table 3: Unoccupied by waiter");	
		}
		if (Table4_w.isVisible()){
			System.out.println("Table 4: Unoccupied by waiter");	
		}
		if (Table5_w.isVisible()){
			System.out.println("Table 5: Unoccupied by waiter");	
		}
		if (Table6_w.isVisible()){
			System.out.println("Table 6: Unoccupied by waiter");	
		}
		System.out.println("---------------------------------------------");
		/*************************************************/
		//Action Listeners
		/*************************************************/
				
		/////////////HOST GUI PANEL (PANEL 1)/////////////
		
		
		// Place Customer
		Place_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Host_GUI.setVisible(false);
				Customer_Status.setVisible(true);
			}
		});
		
		// Send Waiter
		Send_Waiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Host_GUI.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		
		
		
		/////////////Waiter Status (PANEL 2)/////////////
		
		// Previous
		Previous_WS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more tables present!");
			}
		});
		
		// Next
		Next_WS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more tables present!");
			}
		});
		
		// Table 1
		toggle_w_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_1.setVisible(true);
			}
		});
		
		// Table 2
		toggle_w_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_2.setVisible(true);
			}
			
		});
		
		// Table 3
		toggle_w_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_3.setVisible(true);
			}
		});	
		
		// Table 4
		toggle_w_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_4.setVisible(true);
			}
		});	
		
		// Table 5
		toggle_w_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_5.setVisible(true);
			}
		});	
		
		// Table 6
		toggle_w_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Select_waiter_to_occupy_table_6.setVisible(true);
			}
		});	
		
		
		//Help 
		Help_w.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Red = Table unoccupied by waiter(s)" + "\n" + "Green = Table occupied by waiter(s)");
			}
		});
		
		//Return
		Return_WS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiter_Status.setVisible(false);
				Host_GUI.setVisible(true);
			}
		});
		
		/////////////Customer Status (PANEL 3)/////////////

		// Previous
		Previous_CS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more tables present!");
			}
		});
		
		// Next
		Next_CS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more tables present!");
			}
		});
		
		// Table 1
		toggle_c_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		// Table 2
		toggle_c_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		// Table 3
		toggle_c_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		// Table 4
		toggle_c_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		// Table 5
		toggle_c_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		// Table 6
		toggle_c_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Customer_status_at_table.setVisible(true);
			}
		});
		
		
		
		//Help
		Help_CS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Table unoccupied by customer(s)" + "\n" + "Green = Table occupied by customer(s)");

			}
		});
		
		//Return
		Return_CS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Status.setVisible(false);
				Host_GUI.setVisible(true);
			}
		});
		
		/////////////Customer Status at a table (PANEL 4)/////////////
		
		//Return
		Return_cst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_status_at_table.setVisible(false);
				Customer_Status.setVisible(true);
				if(toggle_c_1.isSelected()){
					toggle_c_1.setSelected(false);
				}
				if(toggle_c_2.isSelected()){
					toggle_c_2.setSelected(false);
				}
				if(toggle_c_3.isSelected()){
					toggle_c_3.setSelected(false);
				}
				if(toggle_c_4.isSelected()){
					toggle_c_4.setSelected(false);
				}
				if(toggle_c_5.isSelected()){
					toggle_c_5.setSelected(false);
				}
				if(toggle_c_6.isSelected()){
					toggle_c_6.setSelected(false);
				}
			}
		});
		
		//Table Occupied by customer
		Occupied_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggle_c_1.isSelected()){
					toggle_c_1.setSelected(false);
					Table_1_c.setVisible(false);
					System.out.println("Table 1 Updated: Occupied by customer");
					
				}
				if(toggle_c_2.isSelected()){
					toggle_c_2.setSelected(false);
					Table_2_c.setVisible(false);
					System.out.println("Table 2 Updated: Occupied by customer");
				}
				if(toggle_c_3.isSelected()){
					toggle_c_3.setSelected(false);
					Table_3_c.setVisible(false);
					System.out.println("Table 3 Updated: Occupied by customer");
				}
				if(toggle_c_4.isSelected()){
					toggle_c_4.setSelected(false);
					Table_4_c.setVisible(false);
					System.out.println("Table 4 Updated: Occupied by customer");
				}
				if(toggle_c_5.isSelected()){
					toggle_c_5.setSelected(false);
					Table_5_c.setVisible(false);
					System.out.println("Table 5 Updated: Occupied by customer");
				}
				if(toggle_c_6.isSelected()){
					toggle_c_6.setSelected(false);
					Table_6_c.setVisible(false);
					System.out.println("Table 6 Updated: Occupied by customer");
				}
				Customer_status_at_table.setVisible(false);
				Customer_Status.setVisible(true);
			}
		});
		
		//Table Unoccupied by customer
		Unoccupied_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggle_c_1.isSelected()){
					toggle_c_1.setSelected(false);
					Table_1_c.setVisible(true);
					System.out.println("Table 1 Updated: Unoccupied by customer");
				}
				if(toggle_c_2.isSelected()){
					toggle_c_2.setSelected(false);
					Table_2_c.setVisible(true);
					System.out.println("Table 2 Updated: Unoccupied by customer");
				}
				if(toggle_c_3.isSelected()){
					toggle_c_3.setSelected(false);
					Table_3_c.setVisible(true);
					System.out.println("Table 3 Updated: Unoccupied by customer");
				}
				if(toggle_c_4.isSelected()){
					toggle_c_4.setSelected(false);
					Table_4_c.setVisible(true);
					System.out.println("Table 4 Updated: Unoccupied by customer");
				}
				if(toggle_c_5.isSelected()){
					toggle_c_5.setSelected(false);
					Table_5_c.setVisible(true);
					System.out.println("Table 5 Updated: Unoccupied by customer");
				}
				if(toggle_c_6.isSelected()){
					toggle_c_6.setSelected(false);
					Table_6_c.setVisible(true);
					System.out.println("Table 6 Updated: Unoccupied by customer");
				}
				Customer_status_at_table.setVisible(false);
				Customer_Status.setVisible(true);
			}
		});
		
		/////////////Select waiter to occupy  table (PANELS 6-11)/////////////
		
		// Panel 6 : Select waiter to occupy  table 1

		//Previous
		Previouskey_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more waiters!");
			}
		});
		
		//Next
		Nextkey_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more waiters!");
			}
		});
		
		//Return
		Returnkey_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_1.setSelected(false);
				Select_waiter_to_occupy_table_1.setVisible(false);
				Waiter_Status.setVisible(true);

			}
		});
		
		//Help
		Helpkey_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
			}
		});
		
		//Waiter 1
		WaiterT_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (WaiterT_1_1.isSelected()){
						Waiter_1_toggle_1.setVisible(false);System.out.println("Table 1 Update: Occupied by Waiter 1");
					}else{Waiter_1_toggle_1.setVisible(true);System.out.println("Table 1 Update: Unoccupied by Waiter 1");}
					TableStatusUpdate(Waiter_1_toggle_1,Table1_w);
					TableFix(Waiter_1_toggle_1, Waiter_2_toggle_1, Waiter_3_toggle_1, Table1_w);
			}
			
		});

		//Waiter 2
		WaiterT_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_1_2.isSelected()){
					Waiter_2_toggle_1.setVisible(false);System.out.println("Table 1 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_1.setVisible(true);System.out.println("Table 1 Update: Unoccupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_1,Table1_w);
				TableFix(Waiter_1_toggle_1, Waiter_2_toggle_1, Waiter_3_toggle_1, Table1_w);
			}
		});
		
		//Waiter 3
		WaiterT_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_1_3.isSelected()){
					Waiter_3_toggle_1.setVisible(false);System.out.println("Table 1 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_1.setVisible(true);System.out.println("Table 1 Update: Unoccupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_1,Table1_w);
				TableFix(Waiter_1_toggle_1, Waiter_2_toggle_1, Waiter_3_toggle_1, Table1_w);
			}
		});
		
		// Panel 7 : Select waiter to occupy  table 2
		
		//Previous
		Previouskey_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"No more waiters!");
			}
		});
		
		//Next
				Nextkey_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		//Return
		Returnkey_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_2.setSelected(false);
				Select_waiter_to_occupy_table_2.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		
		//Help
				Helpkey_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
					}
				});

		//Waiter 1
		WaiterT_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_2_1.isSelected()){
					Waiter_1_toggle_2.setVisible(false);System.out.println("Table 2 Update: Occupied by Waiter 1");
				}else{Waiter_1_toggle_2.setVisible(true);System.out.println("Table 2 Update: Unoccupied by Waiter 1");}
				TableStatusUpdate(Waiter_1_toggle_2,Table2_w);
				TableFix(Waiter_1_toggle_2, Waiter_2_toggle_2, Waiter_3_toggle_2, Table2_w);
				
			}
		});

		//Waiter 2
		WaiterT_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_2_2.isSelected()){
					Waiter_2_toggle_2.setVisible(false);System.out.println("Table 2 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_2.setVisible(true);System.out.println("Table 2 Update: Unoccupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_2,Table2_w);
				TableFix(Waiter_1_toggle_2, Waiter_2_toggle_2, Waiter_3_toggle_2, Table2_w);
			}
		});
		
		//Waiter 3
		WaiterT_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_2_3.isSelected()){
					Waiter_3_toggle_2.setVisible(false);System.out.println("Table 2 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_2.setVisible(true);System.out.println("Table 2 Update: Unoccupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_2,Table2_w);
				TableFix(Waiter_1_toggle_2, Waiter_2_toggle_2, Waiter_3_toggle_2, Table2_w);
			}
		});
		
		// Panel 8 : Select waiter to occupy  table 3
		
		//Next
				Nextkey_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		//Previous
				Previouskey_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
				
		//Return
		Returnkey_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_3.setSelected(false);
				Select_waiter_to_occupy_table_3.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		//Help
				Helpkey_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
					}
				});

		//Waiter 1
		Waiter_T_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_3_1.isSelected()){
					Waiter_1_toggle_3.setVisible(false);System.out.println("Table 3 Update: Occupied by Waiter 1");
				}else{Waiter_1_toggle_3.setVisible(true);System.out.println("Table 3 Update: Unoccupied by Waiter 1");}
				TableStatusUpdate(Waiter_1_toggle_3,Table3_w);
				TableFix(Waiter_1_toggle_3, Waiter_2_toggle_3, Waiter_3_toggle_3, Table3_w);
				
			}
		});

		//Waiter 2
		Waiter_T_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_3_2.isSelected()){
					Waiter_2_toggle_3.setVisible(false);System.out.println("Table 3 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_3.setVisible(true);System.out.println("Table 3 Update: Unoccupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_3,Table3_w);
				TableFix(Waiter_1_toggle_3, Waiter_2_toggle_3, Waiter_3_toggle_3, Table3_w);
			}
		});
		
		//Waiter 3
		Waiter_T_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_3_3.isSelected()){
					Waiter_3_toggle_3.setVisible(false);System.out.println("Table 3 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_3.setVisible(true);System.out.println("Table 3 Update: Unoccupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_3,Table3_w);
				TableFix(Waiter_1_toggle_3, Waiter_2_toggle_3, Waiter_3_toggle_3, Table3_w);
			}
		});
		
		// Panel 9 : Select waiter to occupy  table 4
		
		//Next
				Nextkey_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		//Previous
				Previouskey_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		// Return
		Returnkey_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_4.setSelected(false);
				Select_waiter_to_occupy_table_4.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		
		//Help
				Helpkey_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
					}
				});
				
		//Waiter 1
		WaiterT_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_4_1.isSelected()){
					Waiter_1_toggle_4.setVisible(false);System.out.println("Table 4 Update: Occupied by Waiter 1");
				}else{Waiter_1_toggle_4.setVisible(true);System.out.println("Table 4 Update: Unoccupied by Waiter 1");}
				TableStatusUpdate(Waiter_1_toggle_4,Table4_w);
				TableFix(Waiter_1_toggle_4, Waiter_2_toggle_4, Waiter_3_toggle_4, Table4_w);
			}
		});

		//Waiter 2
		WaiterT_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_4_2.isSelected()){
					Waiter_2_toggle_4.setVisible(false);System.out.println("Table 4 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_4.setVisible(true);System.out.println("Table 4 Update: Unoccupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_4,Table4_w);
				TableFix(Waiter_1_toggle_4, Waiter_2_toggle_4, Waiter_3_toggle_4, Table4_w);
			}
		});
		
		//Waiter 3
		WaiterT_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_4_3.isSelected()){
					Waiter_3_toggle_4.setVisible(false);System.out.println("Table 4 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_4.setVisible(true);System.out.println("Table 4 Update: Unoccupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_4,Table4_w);
				TableFix(Waiter_1_toggle_4, Waiter_2_toggle_4, Waiter_3_toggle_4, Table4_w);
			}
		});
		
		// Panel 10 : Select waiter to occupy  table 5
		
		//Next
				Nextkey_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		//Previous
				Previouskey_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		//Return
		Returnkey_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_5.setSelected(false);
				Select_waiter_to_occupy_table_5.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		
		//Help
				Helpkey_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
					}
				});

		//Waiter 1
		Waiter_T_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_5_1.isSelected()){
					Waiter_1_toggle_5.setVisible(false);System.out.println("Table 5 Update: Occupied by Waiter 1");
				}else{Waiter_1_toggle_5.setVisible(true);System.out.println("Table 5 Update: Unoccupied by Waiter 1");}
				TableStatusUpdate(Waiter_1_toggle_5,Table5_w);
				TableFix(Waiter_1_toggle_5, Waiter_2_toggle_5, Waiter_3_toggle_5, Table5_w);
			}
		});

		//Waiter 2
		Waiter_T_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_5_2.isSelected()){
					Waiter_2_toggle_5.setVisible(false);System.out.println("Table 5 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_5.setVisible(true);System.out.println("Table 5 Update: Occupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_5,Table5_w);
				TableFix(Waiter_1_toggle_5, Waiter_2_toggle_5, Waiter_3_toggle_5, Table5_w);
			}
		});
		
		//Waiter 3
		Waiter_T_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Waiter_T_5_3.isSelected()){
					Waiter_3_toggle_5.setVisible(false);System.out.println("Table 5 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_5.setVisible(true);System.out.println("Table 5 Update: Occupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_5,Table5_w);
				TableFix(Waiter_1_toggle_5, Waiter_2_toggle_5, Waiter_3_toggle_5, Table5_w);
			}
		});

		// Panel 11 : Select waiter to occupy  table 6
		
		//Next
				Nextkey_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		
		//Previous
				Previouskey_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"No more waiters!");
					}
				});
		//Return
		Returnkey_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggle_w_6.setSelected(false);
				Select_waiter_to_occupy_table_6.setVisible(false);
				Waiter_Status.setVisible(true);
			}
		});
		
		//Help
				Helpkey_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Red = Waiter Unoccupied" + "\n" + "Green = Waiter Occupied");
					}
				});
				
		//Waiter 1
		WaiterT_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_6_1.isSelected()){
					Waiter_1_toggle_6.setVisible(false);System.out.println("Table 6 Update: Occupied by Waiter 1");
				}else{Waiter_1_toggle_6.setVisible(true);System.out.println("Table 6 Update: Unocupied by Waiter 1");}
				TableStatusUpdate(Waiter_1_toggle_6,Table6_w);
				TableFix(Waiter_1_toggle_6, Waiter_2_toggle_6, Waiter_3_toggle_6, Table6_w);
			}
		});

		//Waiter 2
		WaiterT_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_6_2.isSelected()){
					Waiter_2_toggle_6.setVisible(false);System.out.println("Table 6 Update: Occupied by Waiter 2");
				}else{Waiter_2_toggle_6.setVisible(true);System.out.println("Table 6 Update: Unocupied by Waiter 2");}
				TableStatusUpdate(Waiter_2_toggle_6,Table6_w);
				TableFix(Waiter_1_toggle_6, Waiter_2_toggle_6, Waiter_3_toggle_6, Table6_w);
			}
		});
		
		//Waiter 3
		WaiterT_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (WaiterT_6_3.isSelected()){
					Waiter_3_toggle_6.setVisible(false);System.out.println("Table 6 Update: Occupied by Waiter 3");
				}else{Waiter_3_toggle_6.setVisible(true);System.out.println("Table 6 Update: Unocupied by Waiter 3");}
				TableStatusUpdate(Waiter_3_toggle_6,Table6_w);
				TableFix(Waiter_1_toggle_6, Waiter_2_toggle_6, Waiter_3_toggle_6, Table6_w);
			}
		});
		
		
		//LOGOUTS
		
		// Logout Initial Panel
				Logout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Thank you for using the system!");
						/****************************/				
						// 	Final Outputs of program
						/****************************/		
						System.out.println("---------------------------------------------");
						System.out.println("CHANGES MADE TO SYSTEM");	
						
						// Update customer status	
						if (Table_1_c.isVisible()){
							System.out.println("Table 1 is not occupied by a customer");
						}else{System.out.println("Table 1 is occupied by a customer");}
						if (Table_2_c.isVisible()){
							System.out.println("Table 2 is not occupied by a customer");
						}else{System.out.println("Table 2 is occupied by a customer");}
						if (Table_3_c.isVisible()){
							System.out.println("Table 3 is not occupied by a customer");
						}else{System.out.println("Table 3 is occupied by a customer");}
						if (Table_4_c.isVisible()){
							System.out.println("Table 4 is not occupied by a customer");
						}else{System.out.println("Table 4 is occupied by a customer");}
						if (Table_5_c.isVisible()){
							System.out.println("Table 5 is not occupied by a customer");
						}else{System.out.println("Table 5 is occupied by a customer");}
						if (Table_6_c.isVisible()){
							System.out.println("Table 6 is not occupied by a customer");
						}else{System.out.println("Table 6 is occupied by a customer");}
						
						System.out.println("");
							
						// Update waiter status
						if (Waiter_1_toggle_1.isVisible()==false){
						// Waiter 1@Table1
							System.out.println("Waiter 1 occupies Table 1");
						}else{System.out.println("Waiter 1 does not occupy Table 1");}
						if (Waiter_2_toggle_1.isVisible()==false){
						// Waiter 2@Table1
							System.out.println("Waiter 2 occupies Table 1");
						}else{System.out.println("Waiter 2 does not occupy Table 1");}
						if (Waiter_3_toggle_1.isVisible()==false){
						// Waiter 3@Table1	
							System.out.println("Waiter 3 occupies Table 1");
						}else{System.out.println("Waiter 3 does not occupy Table 1");}
						if (Waiter_1_toggle_2.isVisible()==false){
						// Waiter 1@Table2	
							System.out.println("Waiter 1 occupies Table 2");
						}else{System.out.println("Waiter 1 does not occupy Table 2");}
						if (Waiter_2_toggle_2.isVisible()==false){
						// Waiter 2@Table2		
							System.out.println("Waiter 2 occupies Table 2");
						}else{System.out.println("Waiter 2 does not occupy Table 2");}
						if (Waiter_3_toggle_2.isVisible()==false){
						// Waiter 3@Table2	
							System.out.println("Waiter 3 occupies Table 2");
						}else{System.out.println("Waiter 3 does not occupy Table 2");}
						if (Waiter_1_toggle_3.isVisible()==false){
						// Waiter 1@Table3	
							System.out.println("Waiter 1 occupies Table 3");
						}else{System.out.println("Waiter 1 does not occupy Table 3");}
						if (Waiter_2_toggle_3.isVisible()==false){
						// Waiter 2@Table3	
							System.out.println("Waiter 2 occupies Table 3");
						}else{System.out.println("Waiter 2 does not occupy Table 3");}
						if (Waiter_3_toggle_3.isVisible()==false){
						// Waiter 3@Table3	
							System.out.println("Waiter 3 occupies Table 3");
						}else{System.out.println("Waiter 3 does not occupy Table 3");}
						if (Waiter_1_toggle_4.isVisible()==false){
						// Waiter 1@Table4	
							System.out.println("Waiter 1 occupies Table 4");
						}else{System.out.println("Waiter 1 does not occupy Table 4");}
						if (Waiter_2_toggle_4.isVisible()==false){
						// Waiter 2@Table4	
							System.out.println("Waiter 2 occupies Table 4");
						}else{System.out.println("Waiter 2 does not occupy Table 4");}
						if (Waiter_3_toggle_4.isVisible()==false){
						// Waiter 3@Table4	
							System.out.println("Waiter 3 occupies Table 4");
						}else{System.out.println("Waiter 3 does not occupy Table 4");}
						if (Waiter_1_toggle_5.isVisible()==false){
						// Waiter 1@Table5	
							System.out.println("Waiter 1 occupies Table 5");
						}else{System.out.println("Waiter 1 does not occupy Table 5");}
						if (Waiter_2_toggle_5.isVisible()==false){
						// Waiter 2@Table5	
							System.out.println("Waiter 2 occupies Table 5");
						}else{System.out.println("Waiter 2 does not occupy Table 5");}
						if (Waiter_3_toggle_5.isVisible()==false){
						// Waiter 3@Table5	
							System.out.println("Waiter 3 occupies Table 5");
						}else{System.out.println("Waiter 3 does not occupy Table 5");}
						if (Waiter_1_toggle_6.isVisible()==false){
						// Waiter 1@Table6	
							System.out.println("Waiter 1 occupies Table 6");
						}else{System.out.println("Waiter 1 does not occupy Table 6");}
						if (Waiter_2_toggle_6.isVisible()==false){
						// Waiter 2@Table6	
							System.out.println("Waiter 2 occupies Table 6");
						}else{System.out.println("Waiter 2 does not occupy Table 6");}
						if (Waiter_3_toggle_6.isVisible()==false){
						// Waiter 3@Table6	
							System.out.println("Waiter 3 occupies Table 6");
						}else{System.out.println("Waiter 3 does not occupy Table 6");}
						System.out.println("------------------------");
						System.out.println("RUN END");
								System.exit(0);
					}
				});		
				
		
		// FINAL OUTPUTS
				// Update customer status	
				if (Table_1_c.isVisible()){
					//Table 1 is not occupied by a customer
				}else{/*Table 1 is occupied by a customer)*/}
				
				if (Table_2_c.isVisible()){
					//Table 2 is not occupied by a customer
				}else{/*Table 2 is occupied by a customer)*/}
				
				if (Table_3_c.isVisible()){
					//Table 3 is not occupied by a customer
				}else{/*Table 3 is occupied by a customer)*/}
				
				if (Table_4_c.isVisible()){
					//Table 4 is not occupied by a customer
				}else{/*Table 4 is occupied by a customer)*/}
				
				if (Table_5_c.isVisible()){
					//Table 5 is not occupied by a customer
				}else{/*Table 5 is occupied by a customer)*/}
				
				if (Table_6_c.isVisible()){
					//Table 6 is not occupied by a customer
				}else{/*Table 6 is occupied by a customer)*/}
				
				
					
				// Update waiter status
				if (Waiter_1_toggle_1.isVisible()==false){
					//Waiter 1 occupies Table 1
					EmployeeHandler.AssignWaiterToTable(1,1);
				}else{/*Waiter 1 does not occupy Table 1*/
					EmployeeHandler.RemoveWaiterFromTable(1,1);
				}
				
				if (Waiter_2_toggle_1.isVisible()==false){
					//Waiter 2 occupies Table 1
					EmployeeHandler.AssignWaiterToTable(2,1);
				}else{/*Waiter 2 does not occupy Table 1*/
					EmployeeHandler.RemoveWaiterFromTable(2,1);
				}
				
				if (Waiter_3_toggle_1.isVisible()==false){
					//Waiter 3 occupies Table 1
					EmployeeHandler.AssignWaiterToTable(3,1);
				}else{/*Waiter 3 does not occupy Table 1*/
					EmployeeHandler.RemoveWaiterFromTable(3,1);
				}
				
				if (Waiter_1_toggle_2.isVisible()==false){
					//Waiter 1 occupies Table 2
					EmployeeHandler.AssignWaiterToTable(1,2);
				}else{/*Waiter 1 does not occupy Table 2*/
					EmployeeHandler.RemoveWaiterFromTable(1,2);
				}
				
				if (Waiter_2_toggle_2.isVisible()==false){
					//Waiter 2 occupies Table 2
					EmployeeHandler.AssignWaiterToTable(2,2);
				}else{/*Waiter 2 does not occupy Table 2*/
					EmployeeHandler.RemoveWaiterFromTable(2,2);
				}
				
				if (Waiter_3_toggle_2.isVisible()==false){
					//Waiter 3 occupies Table 2
					EmployeeHandler.AssignWaiterToTable(3,2);
				}else{/*Waiter 3 does not occupy Table 2*/
					EmployeeHandler.RemoveWaiterFromTable(3,2);
				}
				
				if (Waiter_1_toggle_3.isVisible()==false){
					//Waiter 1 occupies Table 3
					EmployeeHandler.AssignWaiterToTable(1,3);
				}else{/*Waiter 1 does not occupy Table 3*/
					EmployeeHandler.RemoveWaiterFromTable(1,3);
				}
				
				if (Waiter_2_toggle_3.isVisible()==false){
					//Waiter 2 occupies Table 3
					EmployeeHandler.AssignWaiterToTable(2,3);
				}else{/*Waiter 2 does not occupy Table 3*/
					EmployeeHandler.RemoveWaiterFromTable(2,3);
				}
				
				if (Waiter_3_toggle_3.isVisible()==false){
					//Waiter 3 occupies Table 3
					EmployeeHandler.AssignWaiterToTable(3,3);
				}else{/*Waiter 3 does not occupy Table 3*/
					EmployeeHandler.RemoveWaiterFromTable(3,3);
				}
				
				if (Waiter_1_toggle_4.isVisible()==false){
					//Waiter 1 occupies Table 4
					EmployeeHandler.AssignWaiterToTable(1,4);
				}else{/*Waiter 1 does not occupy Table 4*/
					EmployeeHandler.RemoveWaiterFromTable(1,4);
				}
				
				if (Waiter_2_toggle_4.isVisible()==false){
					//Waiter 2 occupies Table 4
					EmployeeHandler.AssignWaiterToTable(2,4);
				}else{/*Waiter 2 does not occupy Table 4*/
					EmployeeHandler.RemoveWaiterFromTable(2,4);
				}
				
				if (Waiter_3_toggle_4.isVisible()==false){
					//Waiter 3 occupies Table 4
					EmployeeHandler.AssignWaiterToTable(3,4);
				}else{/*Waiter 3 does not occupy Table 4*/
					EmployeeHandler.RemoveWaiterFromTable(3,4);
				}
				
				if (Waiter_1_toggle_5.isVisible()==false){
					//Waiter 1 occupies Table 5
					EmployeeHandler.AssignWaiterToTable(1,5);
				}else{/*Waiter 1 does not occupy Table 5*/
					EmployeeHandler.RemoveWaiterFromTable(1,5);
				}
				
				if (Waiter_2_toggle_5.isVisible()==false){
					//Waiter 2 occupies Table 5
					EmployeeHandler.AssignWaiterToTable(2,5);
				}else{/*Waiter 2 does not occupy Table 5*/
					EmployeeHandler.RemoveWaiterFromTable(2,5);
				}
				
				if (Waiter_3_toggle_5.isVisible()==false){
					//Waiter 3 occupies Table 5
					EmployeeHandler.AssignWaiterToTable(3,5);
				}else{/*Waiter 3 does not occupy Table 5*/
					EmployeeHandler.RemoveWaiterFromTable(3,5);
				}
				
				if (Waiter_1_toggle_6.isVisible()==false){
					//Waiter 1 occupies Table 6	
					EmployeeHandler.AssignWaiterToTable(1,6);
				}else{/*Waiter 1 does not occupy Table 6*/
					EmployeeHandler.RemoveWaiterFromTable(1,6);
				}
				
				if (Waiter_2_toggle_6.isVisible()==false){
					//Waiter 2 occupies Table 6	
					EmployeeHandler.AssignWaiterToTable(2,6);
				}else{/*Waiter 2 does not occupy Table 6*/
					EmployeeHandler.RemoveWaiterFromTable(2,6);
				}
				
				if (Waiter_3_toggle_6.isVisible()==false){
					//Waiter 3 occupies Table 6
					EmployeeHandler.AssignWaiterToTable(3,6);
				}else{/*Waiter 3 does not occupy Table 6*/
					EmployeeHandler.RemoveWaiterFromTable(3,6);
				}
				
	}
	
	// Fixing problem where if 1 waiter was reselected for a table, the table status would be unoccupied (even though other waiters still occupy the table)
	
	public void TableFix(JButton a, JButton b, JButton c, JButton d){
		if(a.isVisible() == false || b.isVisible() == false || c.isVisible() == false){
			d.setVisible(false);
		}
	}
	
	
	// Turns a table as occupied if a waiter occupies it, turns a table unoccupied if a waiter unoccupies it.
	
	public void TableStatusUpdate(JButton WaiterToggle,JButton TableToggle){
		if(WaiterToggle.isVisible() == false){
			TableToggle.setVisible(false);
		}
		if(WaiterToggle.isVisible() == true){
			TableToggle.setVisible(true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();
		if(a==timer){
			busboy.updateTables();
			UPDATEHOSTBUTTONS();
		}
		
	}
	
	public void UPDATEHOSTBUTTONS(){
		if (busboy.tablehandler.check(1)==0){
			toggle_w_1.setEnabled(false);
			toggle_c_1.setEnabled(false);
		}
		if (busboy.tablehandler.check(2)==0){
			toggle_w_2.setEnabled(false);
			toggle_c_2.setEnabled(false);
		}
		if (busboy.tablehandler.check(3)==0){
			toggle_w_3.setEnabled(false);
			toggle_c_3.setEnabled(false);
		}
		if (busboy.tablehandler.check(4)==0){
			toggle_w_4.setEnabled(false);
			toggle_c_4.setEnabled(false);
		}
		if (busboy.tablehandler.check(5)==0){
			toggle_w_5.setEnabled(false);
			toggle_c_5.setEnabled(false);
		}
		if (busboy.tablehandler.check(6)==0){
			toggle_w_6.setEnabled(false);
			toggle_c_6.setEnabled(false);
		}
	}
}
