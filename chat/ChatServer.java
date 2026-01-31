import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
  private static final int PORT =5000;
  private static final String LOG_FILE = "chatlog.txt";
  private static final String WELCOME_FILE = "welcome.txt";
  public static void main(String[] args){
    try(ServerSocket serverSocket = new ServerSocket(PORT)){
      System.out.println("Server started. Waiting for clients...");
      // Read welcome message from file
      String welcomeMessage = readWelcomMessage();

      while(true){
        Socket  clientSocket=serverSocket.accept();
         System.out.println("Client connected: " + clientSocket);
           // Create thread to handle client
         ClientHandler handler = new ClientHandler(clientSocket,welcomeMessage,LOG_FILE);
         Thread t = new Thread(handler);
         t.start(); // handle client in parallel   
      }
    }catch(Exception e){
       e.printStackTrace();
    }
  } 
  // Read welcome message from file
  private static String readWelcomMessage(){
    StringBuilder sb = new StringBuilder();
    try(BufferedReader br = new BufferedReader(new FileReader(WELCOME_FILE))){
     String line;
     while((line = br.readLine())!= null){
       sb.append(line).append("\n");
     }
    } catch(Exception e){
       sb.append("Welcome to the server!\n");
    }
    return sb.toString();
  }
}
