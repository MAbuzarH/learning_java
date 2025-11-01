import java.io.*;
import java.util.*;
public class Employee{

  private int id;
  private String name;
  private double salary;

  public Employee(){
    this.id = 0;
    this.name = "Default";
    this.salary = 0.0;
  }

  public Employee(int id,String name,double salary){
    this.id = id;
    this.name = name;
    this.salary = salary;
  }
  
  public void display(){
    System.out.println("In Employee display method");
    System.out.println("Employee Id: "+this.id+",Name: "+this.name+",Salary: "+this.salary);
  }

  public String toString(){
    return "Employee Id: "+this.id+",Name: "+this.name+",Salary: "+this.salary;
  }

}