import java.io.*;
import java.util.*;
public class Test{
  public static void main(String[] args){

    Employee e1[] ={new Teacher(104,"Bilal",65000.0,"Mphil"),new Manager(105,"Hina",80000.0,"HR")};

    System.out.println("\nCreating Employee, Teacher and Manager objects....\n");

    //creating objects
    Employee e2 = new Employee(101,"Ali",50000.0);
    Teacher t1 = new Teacher(102,"Sara",60000.0,"phd");
    Manager m1 = new Manager(101,"Ahamed",70000.0,"IT");
 
   //displaying objects
   e2.display();
   t1.display();
   m1.display();   

    System.out.println("\nDemonstrating Polimorphisim\n");
    for(Employee e:e1){
      e.display();
    } 

    //System.out.println(E1[0].toString());

  }
}