//how to access private static data member outside the class whth out creating its object ?
//Answer:by making its geter function static example
//java has 4 access sepecefire default,public,private,protected
import java.io.*;
class Example{
  private static int x; //private  static member variable
  public int y;  //public  instance member variable
  protected int z; //protected  instance member variable
  int a; //default  instance member variable
  static int getX(){
    return x;
  }
  void setX(){
    x=22;
  }
  void fun3(){
    x=99;
  }
}
public class Test{
  public static void main(String[] args){

    Example e1 = new Example();
    Example e2 = new Example();
    e2.fun3();//set value of x =99;
    e1.setX();
    int y = Example.getX();
    int x = e1.getX();
    int z = e2.getX();
    System.out.println("Geting x by Class Name:"+ y);
    System.out.println("Geting x by e1 Hope print 22 b/c used setX():"+x);
     System.out.println("Geting x by e2 Hope print 95 b/c used fun3():"+z); //printed 22 b/c last operation was done using setX() which sets value of x = 22 as x is static member it created once in memory so its value is same for all object as last modified (22)
  }
}