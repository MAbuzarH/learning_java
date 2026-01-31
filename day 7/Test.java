//no outer class in java is private and protected 
//only one outer public class is in each file
//we can make a class inside a class that class is called inner class and we can make it protected and private
//main fuction called by JVM in this way className.main() 
//java is amost 100% oop  it is not completly 100% because we can access memory by writing int x = 5; without creating any object or any class  
//we can make java 100% object oriented jnguage using wrapper class
//why use wrapper class? to make java 100% oop 
class Nokia{
 private int mic;
 private int camera;

 void setValue(){//access spesifier is default
   mic = 2;
   camera =45;
 }
 void display(){
  System.out.println(mic);
  System.out.println(camera);
 }

}
public class Test{
 Nokia n1 = new Nokia();
n1.setValue();
ni.display();
}