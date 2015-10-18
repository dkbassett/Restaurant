package system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;

public class MainTester {

	public static void main(String[] args) {
		SystemDAOOracleImpl.printFromTable(SystemDAOOracleImpl.getDaysTakings());
		

	}

}
