class Parent{
  public int x;
  public int y;

  Parent(int x,int y){
    this.x = x;
    this.y = y;
  } 

  public void display(){
    System.out.println("In parent:" + x +" "+ y);
  }
}
class Child extends Parent{
  public int x;
  public int y;
  Child(int x,int y){
    super(x,y);
    this.x = x;
    this.y = y;
  }
  public void f1(int x,int y){
    super.x = x;
    super.y = y;
  }

  public void display(){
    super.display();
   System.out.println("In Child:" + x +" "+ y);
  }
}
public class Test{
  public static void main(String [] args){
    Child c1= new Child(3,4);
    c1.display();
    c1.f1(9,11);
    c1.display();
    
  }
}