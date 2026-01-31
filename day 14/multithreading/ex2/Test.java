//threading using Thread class

class Process1 extends Thread{
public void fun(){
  int i;
  for(i=0;i<=10;i++){
    System.out.println("Process1's I: "+ i);
  }
}
//overriding function of Thread
public void run(){
  fun();
}
}
class Process2 extends Thread{
public void fun(){
  int i;
  for(i=0;i<=10;i++){
    System.out.println("Process2's I: "+ i);
  }
}
//overriding function of Thread
public void run(){
  fun();
}
}

public class Test{
  public static void main(String[] args){
     Process1 p1 = new Process1();
     Process2 p2 = new Process2();
     p1.start();
     p2.start();
 }
}