//types of file
//Text file
//Binary file(images,videos,...)
//3 logical steps of file handling
//-opening a file
//-processing
//-Closing a file
import java.io.*;
public class Test{
  public static void main(String[] args){
    File f1 = new File("inp.txt");//store info of metadata
    System.out.println("File Exists:"+f1.exists());
     System.out.println("File able to Write:"+f1.canWrite());
      System.out.println("File Length:"+f1.length());
      try{
        if(!f1.exists()){
          f1.createNewFile();
        }else{
          System.out.println("File Already created");
        }
      
      }catch (Exception ex){
        ex.getMessage();
      }
  }
}
