import java.sql.*;

public class Test{
  public static void main(String[] args){
   Connection con = null;
   Statement stmt = null;
   ResultSet rs = null; 
   PreparedStatment pstmt = null;
   try{
    // 1️⃣ Load Driver
    Class.forName("net.ucanaccessDriver");
    
   }catch(Exception e){

   }finally{

   }
  }
}