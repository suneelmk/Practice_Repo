package DDTpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step2 connect to database
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/autoproject", "root", "root");
		//System.out.println("done");
		//step 3 create statement
		Statement stat= conn.createStatement();
		//step4 execute select query and get result
	    int x = stat.executeUpdate("insert into games values('q','w','r',2)");
		//step 5 close connection
		conn.close();

	}

}
