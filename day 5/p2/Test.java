//take input from console
//write that text input to text file with line number
//program should only exit when user press enter without entering any text
//modren code:
import java.io.*;
public class Test{
  public static void main(String[] args){

    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
    ){
     System.out.println("Enter text (press Enter on empty line to stop):");
     String inputLine;
     int lineCount=1;
     while((inputLine = br.readLine()) != null && !inputLine.isEmpty()){
      String outputLine = lineCount +": "+inputLine;
      pw.println(outputLine);
      lineCount++;
     }
      System.out.println(" Data written to output.txt successfully.");

    }catch(IOException ex){
       System.out.println("Error: " + ex.getMessage());
    }

  }
}
// import java.io.*;
// public class Test{
//   public static void main(String[] args){
//     try(FileReader fr = new FileReader(FileDescriptor.in)){
//       BufferedReader br = new BufferedReader(fr);
//       FileWriter fw = new FileWriter("output.txt");
//       PrintWriter pw = new PrintWriter(fw);
//       int lineCount = 1;
//       String inputLine,outputLine;
//       do{
//         inputLine = br.readLine();
//         if(inputLine.equals(""))
//         break;
//         outputLine = lineCount +": "+inputLine;
//         pw.println(outputLine);
//         lineCount++;
//       }while(true);
//       fw.close();
//       pw.close();
//       br.close();

//     }catch(IOException ex){
//       System.out.println("Error reading file: " + ex.getMessage());
//     }
//   }
// }
