import java.io.*;
class Process1 extends Thread{
  String pn;
  public Process1(String n){
    pn = n;
  }
  public void fun(){
    for(int i = 0; i<=5; i++){
      System.out.println(pn +"'s i:"+i);
    }
  }
  public void run(){
    fun();
  }
}
public class Test{
  public static void main(String[] args){
    Process1 p1 = new Process1("Ali");
    Process1 p2 = new Process1("jafar");
    p1.start();
    p2.start();
  }
}