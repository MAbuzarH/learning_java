//Example of checked or compile time exception
import java.io.*;
// public class Test{
//   public static void main(String[] args) throws IOException{
//     // throw new IOException(); //this line show error on compile time so we must write throws keyword that java catch this exception

    
//   }
// }
public class Test{
  public static void main(String[] args) {


    // code to handle exception by self
    try{
      throw new IOException("Sending Io exception");
    }catch(IOException e1){
     System.out.println( e1.getMessage());
    }
  }
}