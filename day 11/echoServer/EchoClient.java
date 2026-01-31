import java.io.*;
import java.net.*;
import javax.swing.*;

public class EchoClient{
  public static void main(String[] args){
    try(Socket socket = new Socket("localhost",8080);
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)
    ){
     String name = JOptionPane.showInputDialog("Enter your name:");
     pw.println(name);

     String response = br.readLine();
      JOptionPane.showMessageDialog(null, response);
    }catch(IOException ex){
      System.out.println("Client Error: " + ex.getMessage());
    }
  }

}


//my code
// import java.net.*;
// import java.io.*;
// import javax.swing.*;

// public class EchoClient{
//   public static void main(String[] args){
//     try{
//      Socket s = new Socket("localhost",8080);
//      InputStream is=s.getInputStream();
//      InputStreamReader isr = new InputStreamReader(s);
//      BufferedReader br = new BufferedReader(isr);
//      OutputStream os = s.getOutputStream();
//      PrintWriter pw = new PrintWriter(os,true);
//      String msg = JOptionPane.showInputDialog("Enter your name");
//      pw.println(msg);

//      msg = br.readline();
//      JOptionPane.showMessageDialog(null,msg);
//      s.close();
      

//     }catch(Exception ex){
//       system.out.println(ex);
//     }
//   }
// }