package Host;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Manager.EmpObj;
import Shared.Communicator.DatabaseCommunicator;

public class Host_Handler extends DatabaseCommunicator{

	public Host_Handler()
	{
		super();
		connect("admin","gradMay17");
		tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
	}
	public int Order_Identity_Generator(int Identity){
		return Identity++;
	}
	
	public int Orderr_Identity(int Updated){
		
		return Updated;
	}
	
	public void updateTableUnoccupiedByCustomer(int Table_ID){
	this.tell("use MAINDB;");
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Unoccupied' WHERE TABLE_ID = " + Table_ID +";");
	//this.disconnect();
	}
	
	public void updateTableOccupiedByCustomer(int Table_ID){
	this.tell("use MAINDB;");
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Occupied' WHERE TABLE_ID = " + Table_ID +";");	
	//this.disconnect();

	}
	public void updateTablesOccupiedByWaiter(int index,int Table_ID,String NameofWaiter){
		//connect("admin","gradMay17");
		//this.tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		if (index == 1){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_1 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 2){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_2 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 3){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_3 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 4){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_4 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 5){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_5 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		//this.disconnect();
	}
	public void updateTablesUnoccipiedByWaiter(int size,int Table_ID){
		//connect("admin","gradMay17");
		//this.tell("use MAINDB;");
		tell("Select * from MAINDB.Table_Statuses Order by Table_ID;");
		
		
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
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
		//this.disconnect();
		return T_STATUS_LIST;
	}
	
}
