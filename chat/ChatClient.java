import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient{
  public static void main(String[] args){
    try(
      Socket socket = new Socket("localhost",5000);
      BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
      Scanner sc = new Scanner(System.in)
    ){
      // Print welcome message
      System.out.println("---- Server ----");
      String line;
      while(in.ready() && (line = in.readLine()) != null){
        System.out.println(line);
      }
       // Chat loop
       while(true){

        System.out.print("You: ");
        String msg = sc.nextLine();

        out.println(msg);  // send to server

        if (msg.equalsIgnoreCase("bye"))
          break;
        // Receive server reply
        System.out.println("Server: " + in.readLine());
       }
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}