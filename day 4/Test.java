import java.io.*;
public class Test{
  // public static void main(String args[]){
  //   // //unchecked exception
  //   // System.out.println(args[0]);

  //   // checked exception
  //   // FileReader fr = new FileReader("input.txt");
  //   // BufferedReader bf = new  BufferedReader(fr);
  //   // String s = br.readLine();
  //   // System.out.println(s);

   
  //   // try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
  //   //   String s = br.readLine();
  //   //   System.out.println(s);
  //   // } 
  //   // catch (IOException e) {
  //   //   System.out.println("Error: " + e.getMessage());
  //   // }
  

  //   try {
  //     //checked exception
  //     FileReader fr = new FileReader("input.txt");
  //     BufferedReader br = new BufferedReader(fr);

  //     String s = br.readLine();
  //     System.out.println(s);

  //     br.close();
  //     fr.close();
  //   } 
  //   catch (FileNotFoundException e) {
  //     System.out.println("Error: File not found.");
  //   } 
  //   catch (IOException e) {
  //     System.out.println("Error while reading the file.");
  //   }finally{
  //      System.out.println("Program ended.");
  //   }

  //   // try{
  //   //   System.out.println(args[0]);
  //   // }catch(IndexOutOfBoundsException ex){
  //   //   System.out.println("you forget to pass cmd args");
  //   // }finally{
  //   //   System.out.println("Program ended.");
  //   // }
  // }
 public static void main(String[] args) {
    try {
      method1();
    } catch (IOException e) {
      System.out.println("File not found or could not be read.");
    }
  }

  public static void method1() throws IOException {
    System.out.println("Inside method1.");
    method2();
  }

  public static void method2() throws IOException {
    System.out.println("Inside method2.");
    BufferedReader br = new BufferedReader(new FileReader("inputt.txt"));
    String line = br.readLine();
    System.out.println("First line: " + line);
    br.close();
  }

}