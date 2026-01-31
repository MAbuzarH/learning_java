import java.sql.*;
import java.util.*;

public class Test{
 
  public static void main(String[] args){
   Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;
    try{
        // 1. Load Driver Class
     Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
      
       // 2. Set Database Path
     String dbPath = "E:\\learning java\\day 9\\project 1\\personDb.accdb";
      
      // 3. Create Connection
      String url = "jdbc:ucanaccess://" + dbPath;
      con = DriverManager.getConnection(url);

      System.out.println(" Connection Successful!");

      // 4. Create Statement

       stmt = con.createStatement();

      // 5. Execute Query
      String query = "SELECT * FROM personDB";

      rs = stmt.executeQuery(query);

       // 6. Process Results
        System.out.println("ID\tPname\tPaddress\tPphone\tPage");
      
     while (rs.next()) {
      int id = rs.getInt("ID");
      String name = rs.getString("Pname");
      String address = rs.getString("Paddress");
      String phone = rs.getString("Pphone");
      int age = rs.getInt("page");

      System.out.println(id + "\t" + name + "\t" + address + "\t" + phone + "\t"  + age);
     }


    }catch(Exception e){
      e.printStackTrace();
    }finally{
      try{
           // 7. Close Resources
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
          if (con != null) con.close();
          System.out.println("✅ Connection Closed.");
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
    } 
  }
}