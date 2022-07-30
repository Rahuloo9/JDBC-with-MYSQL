import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBC_Collection3 {
	
	public static void main(String[] args) throws Exception {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver Load 
			
			String url = "jdbc:mysql://localhost:3306/tree";// 
			
			 Connection con = DriverManager.getConnection(url, "root", "Rahul@123");//Connection with Databases
			 
			 Statement stm= con.createStatement();
			 
			ResultSet rs=stm.executeQuery("select * from Persons");
			
			while(rs.next()) {
				int pid=rs.getInt(1);
				String plast=rs.getString(2);
				String pname=rs.getString(3);
				String padd=rs.getString(4);
				String pcity=rs.getString(5);
				
				System.out.println("Persons ID = "+pid);
				System.out.println("Persons Last Name = "+plast);
				System.out.println("Persons First Name = "+pname);
				System.out.println("Persons Address = "+padd);
				System.out.println("Persons City = "+pcity);
				
			}
			 
	}catch(Exception e) {
		System.out.println(e);
		
	}
	}
}
