class Employee{
  protected int id;
  protected String name;

  public Employee(int id,String name){
    setId(id);
    setName(name);
  } 
  public Employee(){
    setId(100);
    setName("Default");
  }
  public void setId(int id){
   this.id = id;
  }
  public void setName(String name){
   this.name = name;
  }
  public int getId(){
   return id;
  }
  public String getName(){
    return name;
  }
  public void display(){
    System.out.println("In Employee display");
    System.out.println("Id:"+id+",Name:"+name);
  }
  public String toString(){
    System.out.println("In Employee tostring");
    return "Id:"+id+",Name"+name;
  }
}

class Teacher extends Employee{
  // protected int id;
  private String qual;

  public Teacher(){
    
    this.qual = "";
  } 
  public Teacher(int i,String n,String q){
    super(i,n);
    this.qual = q;
  }
  public String getQualification(){
   return qual;
  }
  public void setQualification(String qual){
    this.qual = qual;
  }
  @Override
  public void display(){
    System.out.println("Teach in display");
    super.display();
    System.out.println("Teacher: Qualification: " + this.qual);
  }
}

public class Test{
  public static void main(String args[]){
    Teacher t1 = new Teacher(1,"Ali","BA");
    t1.display();

    Employee t2,t3;
    t2 = new Teacher(2,"qam","mBA");
    t2.display();
    t3 = new Employee(3,"jonas");
    t3.display();
   
  }
}
//type casting
//changing one data type to other
//up castaing: storing int varable info into double veriable(implicet);
// down csating: storing double type var into int