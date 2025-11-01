import java.util.*;
public class Manager extends Employee{
  private String department;
  
  public Manager(){
    super();
    this.department = "Default Department";
  }

  public Manager(int id,String name,double salary,String dep){
    super(id,name,salary);
    this.department = dep;
  }

  @Override
  public void display(){
    System.out.println("In Manager display method");
    super.display();
    System.out.println("Manager Department: "+this.department);
  }

  @Override
  public String toString(){
    return super.toString()+",Manager Department:"+this.department;
  }
}