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
	public HostCommunicator(){
		super();
		connect("admin","gradMay17");
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		System.out.println("Host_Handler done");
	}
	
	public void updateTableUnoccupiedByCustomer(int Table_ID){
		this.tell("use MAINDB;");
		update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Unoccupied' WHERE TABLE_ID = " + Table_ID +";");
		System.out.println("updateTableUnoccupiedByCustomer done");
		}
		
		public void updateTableOccupiedByCustomer(int Table_ID){
		this.tell("use MAINDB;");
		update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Occupied' WHERE TABLE_ID = " + Table_ID +";");	
		System.out.println("updateTableOccupiedByCustomer done");

		}
		
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
				
		public void setBorderBlack_Not_Reserved(JButton Indicator,int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			Border border_BLACK = new LineBorder(Color.BLACK,3); 
			Indicator.setBorder(border_BLACK);
			update("UPDATE MAINDB.Table_Statuses SET R_Status = 'Not Reserved' WHERE TABLE_ID = "+Table_ID+";");
			}
				
		public void setBorderBlue_Reserved(JButton Indicator,int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			Border border_BLUE = new LineBorder(Color.BLUE,4); 
			Indicator.setBorder(border_BLUE);
			update("UPDATE MAINDB.Table_Statuses SET R_Status = 'Reserved' WHERE TABLE_ID = "+Table_ID+";");
			}
				
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

		public void markTableAsUnClean(int Table_ID){
			tell("USE MAINDB;");
			tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
			update("UPDATE MAINDB.Table_Statuses SET T_Status = 'Unclean' WHERE TABLE_ID = "+Table_ID+";");
			}
		
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
