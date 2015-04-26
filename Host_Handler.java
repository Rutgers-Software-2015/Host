package Host;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import Manager.EmpObj;
import Manager.ManagerCommunicator.*;
import Manager.ManagerGUIs.*;
import Manager.ManagerCommunicator.*;
import Shared.Communicator.DatabaseCommunicator;

public class Host_Handler extends DatabaseCommunicator{

	public Host_Handler()
	{
		super();
		connect("admin","gradMay17");
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
	}
	
	public void updateTableUnoccupiedByCustomer(int Table_ID){
	this.tell("use MAINDB;");
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Unoccupied' WHERE TABLE_ID = " + Table_ID +";");
	}
	
	public void updateTableOccupiedByCustomer(int Table_ID){
	this.tell("use MAINDB;");
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Occupied' WHERE TABLE_ID = " + Table_ID +";");	

	}
	
	
	public ArrayList<String> Emp_ID_1() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> EMP_ID_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("EMP_ID_1");
			EMP_ID_LIST.add(temp);
		}
		return EMP_ID_LIST;
	}
	public ArrayList<String> Emp_ID_2() throws SQLException{
		tell("use MAINDB;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> EMP_ID_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("EMP_ID_2");
			EMP_ID_LIST.add(temp);
		}
		return EMP_ID_LIST;
	}
	public ArrayList<String> Emp_ID_3() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> EMP_ID_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("EMP_ID_3");
			EMP_ID_LIST.add(temp);
		}
		return EMP_ID_LIST;
	}
	public ArrayList<String> Emp_ID_4() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> EMP_ID_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("EMP_ID_4");
			EMP_ID_LIST.add(temp);
		}
		return EMP_ID_LIST;
	}
	public ArrayList<String> Emp_ID_5() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> EMP_ID_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("EMP_ID_5");
			EMP_ID_LIST.add(temp);
		}
		return EMP_ID_LIST;
	}
	public ArrayList<String> CustomerList() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> C_STATUS_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("C_Status");
			C_STATUS_LIST.add(temp);
		}
		return C_STATUS_LIST;
	}
	public ArrayList<String> ReservedList() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> R_STATUS_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("R_Status");
			R_STATUS_LIST.add(temp);
		}
		return R_STATUS_LIST;
	}
	public ArrayList<String> TableStatusList() throws SQLException{
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		ResultSet rs = tell("Select * from Table_Statuses Order by Table_ID;");
		ArrayList<String> T_STATUS_LIST = new ArrayList<String>();
		rs.beforeFirst();
		while(rs.next() == true){
			String temp = rs.getString("T_Status");
			T_STATUS_LIST.add(temp);
		}
		return T_STATUS_LIST;
	}
	
}
