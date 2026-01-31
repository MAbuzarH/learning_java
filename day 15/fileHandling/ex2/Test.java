import java.io.*;
public class Test{
  public static void main(String[] args) throws IOException {
    File f1 = new File("a.txt");
    // try{
    //  f1.createNewFile();
    // }catch(Exception ex){

    // }
    String s1 = "coding Sekho";
    char ch[] = s1.toCharArray();
    FileOutputStream fo = new FileOutputStream(f1,true);
    // fo.write('A');
    for(int i = 0; i<ch.length; i++){
      fo.write(ch[i]);
      // System.out.println(i);
    }
    fo.close();
    System.out.println("Written ss");
  }
}