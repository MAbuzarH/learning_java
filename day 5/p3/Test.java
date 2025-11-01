
/*
//abstract classes and there example
abstract class Shape{
  public abstract void calculateArea();
   public void displayType() {
        System.out.println("This is a shape.");
    }
}
class Circle extends Shape{
  private final int x;
  private final int y;
  private final double radius;

  // Parameterized constructor (more flexible)
  public Circle(int x, int y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }


  @Override
  public void calculateArea() {
   double area = Math.PI * Math.pow(radius, 2);
   System.out.printf("Area of Circle (center=(%d,%d)): %.2f%n", x, y, area);
    }
}

class Rectangle extends Shape{
  private final double length;
  private final double width;

  public Rectangle(double length,double width){
    this.length = length;
    this.width = width;
  }

  @Override
  public void calculateArea(){
    double area = length*width;
    System.out.printf("Area of Rectangle: %.2f%n", area);
  }
}
public class Test{
  public static void main(String[] args){
  Shape s1 = new Circle(5, 5, 10);
  Shape s2 = new Rectangle(4, 6);

  s1.displayType();
  s1.calculateArea();

  s2.displayType();
  s2.calculateArea();
  }
}
*/
//interfaces and their example
//classes impliment interfaces
//-implimenting an interface is like signing a contract
//-all classes that impliment interface will have to provide defination of  all the method that are present inside interface
//-if class does not provide defination of all methods class would not compile we have to diclare it as an abstract class in order to get it compiled
//"responds to" Relationship
//- relationship between class and interface
//-interface imposes a design strcture on any class taht uses it.
//-leaves the implementation detail to the implimenting class and hides that implimentation from the client
//-A class can impliment more than 1 interface but it can inharet only from 1 class 
//-interfaces inhearets from interfaces and classes impliment interfaces
//-object of interfaces and abstruct classes cannot be insatiated 
interface Speaker{
  // public void speak();
   void speak(); // 'public' is redundant in interfaces — all methods are public & abstract by default
}

class Politician implements Speaker{
  @Override
  public void speak(){
    System.out.println("Talk politics");
  }
}
class Teacher implements Speaker{
  @Override
  public void speak(){
    System.out.println("Talk about aducation");
  }
}
class Coach implements Speaker{
  @Override
  public void speak(){
    System.out.println("Talk Sport");
  }
}

public class Test{

   public static void main(String[] args) {
        // Modern: use polymorphism instead of creating separate variables
        Speaker[] speakers = { new Politician(), new Teacher(), new Coach() };

     for (Speaker s : speakers) {
       s.speak(); // dynamic dispatch (runtime polymorphism)
      }
    }

  // public static void main(String[] args){
  //   Politician p1 = new Politician();
  //   p1.speak();
  //   Teacher t1 = new Teacher();
  //   t1.speak();
  //   Coach c1 = new Coach();
  //   c1.speak();
  // }

}