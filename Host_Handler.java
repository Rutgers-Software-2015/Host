package Host;

import java.sql.ResultSet;

import Shared.Communicator.DatabaseCommunicator;

public class Host_Handler extends DatabaseCommunicator{

	public Host_Handler()
	{
		super();
		connect("admin","gradMay17");
	}
	
	public void updateTableStatus_unclean()
	{
		update("INSERT INTO MAINDB.Table_Status (Table_ID,Current_Table_Status, Assigned_Emp_ID) values (1, 0, 1);");
		//update("INSERT INTO <TABLE NAME> (COLUMN NAMES) VALUES (VALUE1, VALUE2, etc)");
	}
	
	public void readWaiterList()
	{
		ResultSet Table_Status = tell("SELECT * FROM MAINDB.Table_Status;");
		consolePrintTable(Table_Status);
	}
	
}
