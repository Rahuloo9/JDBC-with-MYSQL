import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection2 {
	
	
	public static void main(String[] args) throws Exception {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver Load 
			
			String url = "jdbc:mysql://localhost:3306/tree";// 
			
			 Connection con = DriverManager.getConnection(url, "root", "Rahul@123");//Connection with Databases
			 
			 PreparedStatement pstm=con.prepareStatement("insert into Persons values(?,?,?,?,?)");//Query pass 
			 
			 BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); //runtime input 
			 
			 while(true) {
				 System.out.println("Enter Person Id ");
				 int personid=Integer.parseInt(br.readLine());
				 
				 System.out.println("Enter Person Last Name ");
				 String  LastName=br.readLine();
				 
				 System.out.println("Enter Person First Name ");
				 String  FirstName=br.readLine();
				 
				 System.out.println("Enter Person Address  ");
				 String  Address=br.readLine();
				 
				 System.out.println("Enter Person City ");
				 String City=br.readLine();
				 
				 pstm.setInt(1, personid);
				 pstm.setString(2,LastName );
				 pstm.setString(3,FirstName );
				 pstm.setString(4,Address );
				 pstm.setString(5,City );
				 
				 int count=pstm.executeUpdate();
				 
				 if(count>0) {
					 System.out.println(count+"Record Insertion... ");
				 }else {
					 System.out.println("Record Not Inserted.....");
				 }
				 System.out.println("Do you Want to More Record Inserted ..[YES/NO]");
				 String ch=br.readLine();
				 if(ch.equalsIgnoreCase("NO"))
				 break;
			 } 
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
			
			System.out.println(e);
		    e.printStackTrace();
		} 
	}
}
