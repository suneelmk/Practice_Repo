package DDTpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcConnectionselectQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//step 1 load/register database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step2 connect to database
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/autoproject", "root", "root");
		//System.out.println("done");
		//step 3 create statement
		Statement stat= conn.createStatement();
		//step4 execute select query and get result
		ResultSet resultset= stat.executeQuery("select * from games");
		while(resultset.next())    //next()---->points to first row 
		{
			System.out.println(resultset.getString(1)+" "+resultset.getString(2)+" "+resultset.getString(3)+" "+resultset.getString(4));
		}
		//step 5 close connection
		conn.close();
      
	}

}
