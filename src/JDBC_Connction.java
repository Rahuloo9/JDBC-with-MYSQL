import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connction {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 


		 try {
		    String url = "jdbc:mysql://localhost:3306/tree";
		    Connection con = DriverManager.getConnection(url, "root", "Rahul@123");
		    System.out.println("Succefull Ping");
		    Statement stm=con.createStatement();
		    String sql="Insert into friut values(2)";
		    stm.executeLargeUpdate(sql);
		}
		catch (Exception e){
		    e.printStackTrace();
		}
	}

}
