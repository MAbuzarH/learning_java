//streams
//it is a data chanale where data flows
// node stream
// the stream which is directly connected with IO
//filter stream
//a stream on node stream to filter data 
// data flow in streams
// some stream take byte but some stream take character also called reader or writer on the basis of work they do
//InputStream/OutputStream
//base class stream with few feature
//FileInputStream /FileOutputStream
// speccifically for connecting to files 
//ByteArrayInputStream /ByteArrayOutputStream
//use an in memory array of bytes for storage 
//BufferefInputStream/BufferefOutputStream
//improve performance by adding buffers
// BufferReader / BufferWriter
//-converts bytes to unicode char and string data
//-probably most useful for what we needed 
//source :From where we get data
//sync : where we placed data 


// modren code
import java.io.*;
public class Test{
  public static void readFile(){
    try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))){
      String line;
      while((line = br.readLine()) != null){
        System.out.println(line);
      }
    }catch(IOException ex){
      System.out.println("Error reading file: " + ex.getMessage());
    }
  }
  public static void main(String[] args){
    readFile();

    try(PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))){
      String s1 = "Hello world";
      String s2 = "Buffered write we use";

      pw.println(s1);
      pw.println(s2);
      System.out.println("Data successfully written to output.txt");
    }catch(IOException ex){
      System.out.println("Error reading file: " + ex.getMessage());
    }
  }
}
// import java.io.*;
// public class Test{
//   // code to read from file
//   public void ReadFile(){
//     FileReader fr = null;
//     BufferedReader br = null;
//     try{
//       fr = new FileReader("input.txt");
//       br = new BufferedReader(fr);
//       String s = br.readLine();
//       while(s != null){
//         System.out.println(s);
//         s = br.readLine();
//       }
//       br.close();
//       fr.close();

//     }catch(IOException ex){
//       System.out.println(ex);
//     }
//   }

//   public static void main(String args[]){
//     ReadFile();
//     FileWriter fw = null;
//     PrintWriter pw = null;
//     try{
//       //if file does not exist it atomaticaly create it
//       fw = new FileWriter("output.txt");
//       pw = new PrintWriter(fw);
//       String s1 = "hellow world";
//       String s2 = "Buffered write we use";

//       pw.println(s1);
//       pw.println(s2);
      
//       pw.flush();
//       pw.close();
//       fw.close();
//     }catch(IOException ex){
//       System.out.println(ex);
//     }
//   }
// }
