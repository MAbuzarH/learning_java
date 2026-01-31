import java.net.*;
import java.io.*;
public class EchoServer{
  public static void main(String[] args){
    
    System.out.println("Server is started ...");

    try(ServerSocket serverSocket = new ServerSocket(8080)){
     System.out.println("Server is running on port 8080...");
     while(true){
     Socket clientSocket =serverSocket.accept();
     System.out.println("Client connected: " + clientSocket.getInetAddress());
     // Handle each client in separate thread
     new Thread(new ClientHandler(clientSocket)).start();
     }
    }catch(IOException ex){
     System.out.println("Server Error: " + ex.getMessage());
    }
  }
}
class ClientHandler implements Runnable{
  private final Socket socket;
  public ClientHandler(Socket socket){
    this.socket =socket;
  } 

  @Override
  public void run(){
   try(BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   PrintWriter pw = new PrintWriter(socket.getOutputStream(),true)
   ){
     String name = br.readLine();
     String reply = "Hello "+name+" Welcome to Modern Java Server!";
     pw.println(reply);  // Send reply to client
   }catch(IOException ex){
    System.out.println("Client Error: " + ex.getMessage());
   }finally{
    try{socket.close();}catch(IOException e){
      
    }
   }
  }
}
//my code 
// import java.net.*;
// import java.io.*;
// import javax.swing.*;

// public class EchoServer{
//   public static void main(String[] args){
//     try{
//      ServerSocket ss = new ServerSocket(8080);
//      system.out.println("Server started...");
//      while(true){
//       Socket s = ss.accept();
//       system.out.println("connection request recieved ");

//       InputStream is = s.getInputStream();
//       InputStreamReader isr=new InputStreamReader();
//       BufferedReader br = new BufferedReader(isr);

//       OutputStream os = s.getOutputStream();
//       PrintWriter pw = new PrintWriter(os,true);

//       String name = br.readline(); 
//       String msg = "Hello" + name + " from server";
//       pw.println(msg);
//        s.close();
       
//      }
//     }catch(Exception ex){
//       system.out.println(ex);
//     }
//   }
// }