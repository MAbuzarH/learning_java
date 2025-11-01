//class name{
//dicliration 
//constrcture defination
//method defination
//}
//pemitiv data type initilized with zero and user define data type initilized with null if we dont provid any value
//we have public private and protected and pakege acess modifire
class Student{
  private int roll;
  private String name;
  public static int studentCount =0;
 
  public Student(){
    name="ali" ;
    roll=12;
    studentCount++;
  }
  public Student(String name,int rn){
   setName(name);
   setRoll(rn);
   studentCount++;
  }

  public Student(Student s){
    name=s.name;
    roll=s.roll;
    studentCount++;
  }
  public static int getStudentCount(){
    return studentCount;
  }
  public int getRoll(){
    return roll;
  }
  public void setRoll(int n){
    if(n>0){
      roll = n;
    }else{
      roll = 100;
    }
   
  }
  public String getName(){
    return this.name;
  }
  public void setName(String name){
     this.name = name;
  }

  public void print(){
    System.out.println("Student name: "+name+",RollNomber: "+roll);
  }
  
  //overriding toString method of Object class
  public String toString(){
    return("name:"+name+"rollnumber:"+roll);
  }
  //overriding finalize method of Object class
  //  @Override
  // protected void finalize() throws Throwable {
  //   studentCount--;
  //   super.finalize();
  // }
}//end of class

public class Test{
  public static void main(String args[]){
    Student s1 = new Student();
    Student s2 = new Student("jafar",10);
    Student s3 = new Student(s1);

    s1.print();
    s2.print();
    s3.print();

    System.out.println("S2 using tostring:"+s2);

    s3.setName("qasam");
    s3.setRoll(12);
    System.out.print("s3 Name:"+s3.getName());
    System.out.println("s3 Name:"+s3.getRoll());

    int numObj = Student.getStudentCount();
    System.out.println("Total Students: " + numObj);
  }
}
