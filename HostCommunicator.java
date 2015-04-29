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

public class HostCommunicator extends DatabaseCommunicator{
	/**
	 * Class created for using the Host Communicator
	 * Uses DB as required throughout the code
	 * 
	 * @author David Arakelyan
	 * @tester David Arakelyan
	 * @debugger David Arakelyan
	 * 
	 */

	public HostCommunicator(){
		super();
		connect("admin","gradMay17");
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		System.out.println("Host_Handler done");
	}
	
	

	/**
	 * Updates a table to unoccupied within the database, based on the inputted 
	 * Table_ID (which will be the table number).	
	 * 
	 * @return none
	 * @param int
	 * 
	 */
	
	public void updateTableUnoccupiedByCustomer(int Table_ID){
		this.tell("use MAINDB;");
		update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Unoccupied' WHERE TABLE_ID = " + Table_ID +";");
		System.out.println("updateTableUnoccupiedByCustomer done");
		}
		
	/**
	 * Updates a table to Occupied within the database, based on the inputted 
	 * Table_ID (which will be the table number).
	 * 
	 * @return none
	 * @param int
	 * 
	 */
	
		public void updateTableOccupiedByCustomer(int Table_ID){
		this.tell("use MAINDB;");
		update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Occupied' WHERE TABLE_ID = " + Table_ID +";");	
		System.out.println("updateTableOccupiedByCustomer done");

		}
		

	/**
	 * Pushes the contents of a column of a database into an Array List.
     * 
	 * @return ArrayList<String>
     * @param String
     * 
	 */
		
		public ArrayList<String> returnList(String NameOfListFromTable_Statuses) throws SQLException{
			tell("use MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
			ArrayList<String> LIST = new ArrayList<String>();
			rs.beforeFirst();
			while(rs.next() == true){
				String temp = rs.getString(NameOfListFromTable_Statuses);
				LIST.add(temp);
			}
			System.out.println(NameOfListFromTable_Statuses + " ... done calculating");
			return LIST;
		}

		/**
		 * Updates the waiters within a combobox specific to table based on the parameters 
	     * (Jcombobox and the table the waiters are updated at)
		 * 
		 * @return none
		 * @param JcomboBox,int
		 * 
		 */
		
		 public void CommunicateWaiterStatusChange(JComboBox Waiters_for_table,int Table_ID){ 
			
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			 update("UPDATE MAINDB.Table_Statuses SET EMP_ID_1 = '"+ Waiters_for_table.getItemAt(0)+"' WHERE TABLE_ID = "+Table_ID+";");
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			 update("UPDATE MAINDB.Table_Statuses SET EMP_ID_2 = '"+ Waiters_for_table.getItemAt(1)+"' WHERE TABLE_ID = "+Table_ID+";");
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			 update("UPDATE MAINDB.Table_Statuses SET EMP_ID_3 = '"+ Waiters_for_table.getItemAt(2)+"' WHERE TABLE_ID = "+Table_ID+";");
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			 update("UPDATE MAINDB.Table_Statuses SET EMP_ID_4 = '"+ Waiters_for_table.getItemAt(3)+"' WHERE TABLE_ID = "+Table_ID+";");
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			 update("UPDATE MAINDB.Table_Statuses SET EMP_ID_5 = '"+ Waiters_for_table.getItemAt(4)+"' WHERE TABLE_ID = "+Table_ID+";");
			 tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
				 
		 }
			 

			/**
			 * Adds the initial waiters to the combo box of a specific table based on the
	         * values (names of waiters) stored within the database.
			 * 
			 * @return none 
			 * @param JComboBox,int
			 * 
			 */
		 
		public void addInitialWaiters(JComboBox WaitersAtTables,int index){
			try {
			 if(returnList("EMP_ID_1").get(index) != null){
				 WaitersAtTables.addItem(returnList("EMP_ID_1").get(index));
					 }
			 if(returnList("EMP_ID_2").get(index) != null){
				 WaitersAtTables.addItem(returnList("EMP_ID_2").get(index));
					 }
			 if(returnList("EMP_ID_3").get(index) != null){
				 WaitersAtTables.addItem(returnList("EMP_ID_3").get(index));
			 		}
			 if(returnList("EMP_ID_4").get(index) != null){
				 WaitersAtTables.addItem(returnList("EMP_ID_4").get(index));
			 		}
			 if(returnList("EMP_ID_5").get(index) != null){
				 WaitersAtTables.addItem(returnList("EMP_ID_5").get(index));
			 		}
			 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 
			 }
		
		/**
		 * Updates the indicator for reserved table based on values within the database.
	     * If the value at the specific table (index is used to find table) is marked as
	     * "Reserved" the border will be sent to blue, else to black. This function is used
	     * for initial values.
		 * 
		 * @return none
		 * @param JButton, index
		 * 
		 */
		
			 
		public void reservedTableIndicator(JButton Indicator,int index){
			Border border_BLACK = new LineBorder(Color.BLACK,3); //Not Reserved
			Border border_BLUE = new LineBorder(Color.BLUE,4); //Reserved
			try {
				if(returnList("R_Status").get(index).toString().equals("Reserved")){
					Indicator.setBorder(border_BLUE);
					}
				if(returnList("R_Status").get(index).toString().equals("Not Reserved")){
					Indicator.setBorder(border_BLACK);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		
		/**
		 * Updates the status of a table to not reserved within the database once the
	     * change has been made within the GUI. 
		 * 
		 * @return none
		 * @param JButton
		 * 
		 */
				
		public void setBorderBlack_Not_Reserved(JButton Indicator,int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			Border border_BLACK = new LineBorder(Color.BLACK,3); 
			Indicator.setBorder(border_BLACK);
			update("UPDATE MAINDB.Table_Statuses SET R_Status = 'Not Reserved' WHERE TABLE_ID = "+Table_ID+";");
			}
		
		/**
		 * Updates the status of a table to reserved within the database once the
	     * change has been made within the GUI.
		 * 
		 * @return none
		 * @param JButton, Int
		 * 
		 */
				
		public void setBorderBlue_Reserved(JButton Indicator,int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			Border border_BLUE = new LineBorder(Color.BLUE,4); 
			Indicator.setBorder(border_BLUE);
			update("UPDATE MAINDB.Table_Statuses SET R_Status = 'Reserved' WHERE TABLE_ID = "+Table_ID+";");
			}

		/**
		 * Sets the customer status of a table initially based on the results for
	     * a specific table obtained form the database. If a table is occupied by
	     * a customer, the table is set to a red color, else to a green.
		 * 
		 * @return none
		 * @param JButton, int
		 * 
		 */
		
		public void CustomerStatus(JButton Table, int index){			
			try {
				if(returnList("C_Status").get(index).toString().equals("Occupied")){
					Table.setBackground(Color.green);
				}else{Table.setBackground(Color.red);}
						
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		/**
		 * Updates the table status of a specific table to unclean in the database
         * based on changes made to the GUI.
		 * 
		 * @return none
		 * @param int
		 * 
		 */

		public void markTableAsUnClean(int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			update("UPDATE MAINDB.Table_Statuses SET T_Status = 'Unclean' WHERE TABLE_ID = "+Table_ID+";");
			}

		/**
		 * Returns the name of employees from the EmployeeList table in the database and
	     * pushes them into an array for use.* 
	     * 
		 * @return ArrayList<String> 
		 * @param String
		 * 
		 */
		
		public ArrayList<String> returnFromEmployeeList(String NameOfListFromEmplyeeList) throws SQLException{
			tell("use MAINDB;");
			ResultSet rs = tell("Select * from EmployeeList;");
			ArrayList<String> LIST = new ArrayList<String>();
			rs.beforeFirst();
			while(rs.next() == true){
				String temp = rs.getString(NameOfListFromEmplyeeList);
				LIST.add(temp);
			}
			System.out.println(NameOfListFromEmplyeeList + " ... done calculating");
			return LIST;
		}
		
		/**
		 * Returns the employee list for a specific column of the database. This list is 
		 * pushed into an Array List. The list represents employees at a specific 
		 * point, ie. the all of the employees in the first spot of a table's waiter
		 * list, all of the employees in the second spot, etc.
		 * 
		 * @return ArrayList<String> 
		 * @param none
		 * 
		 */
		
		public ArrayList<String> initialEmployeeList(){
			
			ArrayList<String> List = new ArrayList<String>();
			ArrayList<String> position;
			try {
				position = returnFromEmployeeList("position");
				for (int i = 0; i < position.size(); i++){
					if(returnFromEmployeeList("position").get(i).toString().equals("Waiter")){
						String WaiterName = returnFromEmployeeList("firstname").get(i);
						List.add(WaiterName);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return List;
		}
	
}
