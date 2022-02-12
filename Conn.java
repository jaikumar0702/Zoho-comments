package gyanshala.com;



import java.sql.*;

public class Conn{

	Connection c=null;
	Statement s=null;
	
	
     public Conn() {
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 c = DriverManager.getConnection("jdbc:mysql://localhost:3308/online?zeroDateTimeBehavior=convertToNull","root","");
    		 s =  c.createStatement();
    	 }
    	 catch(ClassNotFoundException | SQLException e){
             System.out.println(e);
         }
     }
	
}
