//hirachical inheritence
class Parent{
  Parent(){
    System.out.println("Parensts constructer called");
  }
  public void f1(){
     System.out.println("Parensts f1 called");
  }
}
class Child1 extends Parent{
  Child1(){
    System.out.println("Child1 constructer called");
  }
  public void f2(){
     System.out.println("Child1 f2 called");
  }
}

class Child2 extends Parent{
  Child2(){
    System.out.println("Child2 constructer called");
  }
  public void f3(){
     System.out.println("Child2 f3 called");
  }
}
public class Test{
  public static void main(String[] args){
    System.out.println("Parent p1 = new Child1()");
    Parent p1 = new Child1();
    // called function in parent
    p1.f1();
    //called function in child
    // p1.f2(); //this is not working
    System.out.println("---------------------");
     System.out.println("Child1 c1 = new Child1()");
    Child1 c1 = new Child1();
    // called function in parent
    c1.f1();
    //called function in child
    c1.f2();
    System.out.println("---------------------");
     System.out.println("Parent p2 = new Child2()");
     Parent p2 = new Child2();
    System.out.println("---------------------");
     System.out.println("Parent p3 = new Parent()");
     Parent p3 = new Parent();
  }
}