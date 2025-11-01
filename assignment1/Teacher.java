import java.util.*;
public class Teacher extends Employee{
  private String education;

  public Teacher(){
    super();
    this.education = "Default Education";
  }
  public Teacher(int id,String name,double salary,String edu){
    super(id,name,salary);
    this.education = edu;
  }

  @Override
  public void display(){
    System.out.println("In Teacher display method");
    super.display();
    System.out.println("Teacher Qualifaction: "+this.education);
  }
 
  @Override
  public String toString(){
    return super.toString()+",Teacher Qualifaction "+this.education;
  }
}