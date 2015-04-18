package Host;

import java.sql.ResultSet;

import Shared.Communicator.DatabaseCommunicator;

public class Host_Handler extends DatabaseCommunicator{

	public Host_Handler()
	{
		super();
		connect("admin","gradMay17");
	}
	public int Order_Identity_Generator(int Identity){
		return Identity++;
	}
	
	public int Orderr_Identity(int Updated){
		
		return Updated;
	}
	
	public void updateTableUnoccupiedByCustomer(int Table_ID){
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Unoccupied' WHERE TABLE_ID = " + Table_ID +";");
	//update("SELECT * FROM MAINDB.Table_Statuses ORDER BY Table_ID;");
	}
	public void updateTableOccupiedByCustomer(int Table_ID){
	update("UPDATE MAINDB.Table_Statuses SET C_Status = 'Occupied' WHERE TABLE_ID = " + Table_ID +";");	
	//update("SELECT * FROM MAINDB.Table_Statuses ORDER BY Table_ID;");

	}
	public void updateTablesOccupiedByWaiter(int index,int Table_ID,String NameofWaiter){
		if (index == 1){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_01 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 2){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_02 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 3){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_03 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 4){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_04 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 5){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_05 = '"+ NameofWaiter +"' WHERE TABLE_ID = "+Table_ID +";");
		}
		
		
	}
	public void updateTablesUnoccipiedByWaiter(int index,int Table_ID){
		if (index == 1){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_01 = 'None' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 2){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_02 = 'None' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 3){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_03 = 'None' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 4){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_04 = 'None' WHERE TABLE_ID = "+Table_ID +";");
		}
		if (index == 5){
			update("UPDATE MAINDB.Table_Statuses SET EMP_ID_05 = 'None' WHERE TABLE_ID = "+Table_ID +";");
		}
	}
	
	public void ShowValues(){
		
	}
}
