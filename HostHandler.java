package Host;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import Manager.ManagerCommunicator.*;
import Manager.ManagerGUIs.*;
import Manager.ManagerCommunicator.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



import Shared.Communicator.DatabaseCommunicator;
import Waiter.WaiterCommunicator;

public class HostHandler {
	 
	/**
	 * This class facilitates interaction between the Host GUI
	 * and the Host communicator for initial statuses
	 * 
	 * @author David Arakelyan
	 * @tester David Arakelyan
	 * @debugger David Arakelyan
	 * 
	 */
	
	public HostCommunicator h;
	/**
	 * Constructor
	 * 
	 * @return nothing
	 * 
	 */
		public HostHandler(){
			this.h = new HostCommunicator();
			this.h.connect("admin","gradMay17");
			this.h.tell("use MAINDB;");
		}
		
	/**
	 * This function is used to view the initial table statuses (Reserved or Not Reserved). 
	 * It sends the request from the GUI to the handler and then to the communication.
	 * 
	 * @param ListOfIndicators,
	 * @param index
	 * 
	 */
	
	public void reservedTableIndicator(ArrayList<JButton> ListOfIndicators ){
	
		h.reservedTableIndicator(ListOfIndicators.get(0),0);
		h.reservedTableIndicator(ListOfIndicators.get(1),1);
		h.reservedTableIndicator(ListOfIndicators.get(1),2);
		h.reservedTableIndicator(ListOfIndicators.get(2),3);
		h.reservedTableIndicator(ListOfIndicators.get(3),4);
		h.reservedTableIndicator(ListOfIndicators.get(4),5);
		h.reservedTableIndicator(ListOfIndicators.get(5),6);
		h.reservedTableIndicator(ListOfIndicators.get(6),7);
		h.reservedTableIndicator(ListOfIndicators.get(7),8);
		h.reservedTableIndicator(ListOfIndicators.get(8),9);
		
	}
	
	/**
	 * This function is used to view the initial customer statuses at a table. 
	 * It sends the request from the GUI to the handler and then to the communication.
	 * 
	 * @param ListOfTables
	 * @param index
	 * 
	 */
	
	public void CustomerStatus(ArrayList<JButton> ListOfTables){
		
		
		h.CustomerStatus(ListOfTables.get(0),0);
		h.CustomerStatus(ListOfTables.get(1),1);
		h.CustomerStatus(ListOfTables.get(2),2);
		h.CustomerStatus(ListOfTables.get(3),3);
		h.CustomerStatus(ListOfTables.get(4),4);
		h.CustomerStatus(ListOfTables.get(5),5);
		h.CustomerStatus(ListOfTables.get(6),6);
		h.CustomerStatus(ListOfTables.get(7),7);
		h.CustomerStatus(ListOfTables.get(8),8);
		h.CustomerStatus(ListOfTables.get(9),9);
		
	}	
	
	/**
	 * This function is used to view the initial customer statuses at a table. 
	 * It sends the request from the GUI to the handler and then to the communication.
	 * 
	 * @param ListOfJComboboxes
	 * @param index
	 * 
	 */
	
	public void addInitialWaiters(ArrayList<JComboBox> ListOfJComboboxes){
		
		h.addInitialWaiters(ListOfJComboboxes.get(0),0);
		h.addInitialWaiters(ListOfJComboboxes.get(1),1);
		h.addInitialWaiters(ListOfJComboboxes.get(2),2);
		h.addInitialWaiters(ListOfJComboboxes.get(3),3);
		h.addInitialWaiters(ListOfJComboboxes.get(4),4);
		h.addInitialWaiters(ListOfJComboboxes.get(5),5);
		h.addInitialWaiters(ListOfJComboboxes.get(6),6);
		h.addInitialWaiters(ListOfJComboboxes.get(7),7);
		h.addInitialWaiters(ListOfJComboboxes.get(8),8);
		h.addInitialWaiters(ListOfJComboboxes.get(9),9);
		
	}	

	
		
		 
	 
	  
	
	 
	
			
}
