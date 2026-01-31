class Person{
 public String name;
 public int age;
 public Person(String n,int a){
    name = n;
    age = a;
  }

  public void display(){
    
    System.out.println("name: "+name);
    System.out.println("age: "+age);
  }
}
class Employee extends Person{
  String qual;
  int salary;
  public Employee(String name,int age,String q,int s){
  super(name,age);
   qual = q;
   salary = s;
  }

 
 public void display(){
  super.display();
    System.out.println("Qualification: "+qual);
    System.out.println("salary: "+salary);
  }
}
public class Test{
  public static void main(String[] args){
     Employee e1 = new Employee("ali",22,"BA",2000);
    // Person e1 = new Employee("ali",22,"BA",2000); //employ cannot be converted into person;
    //  Employee e1 = new Person("ali",22);//person cannot converted into employe
    e1.display();
  }
}