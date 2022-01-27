package databaseConn;
import java.sql.*;

public class ConnDB {
	public Connection con;
	public ConnDB() {
		try {
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
		}
		catch(Exception e){
			System.out.println(e);
		}  
	}

}
