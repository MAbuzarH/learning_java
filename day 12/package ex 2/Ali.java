package pack1;
public class Ali{
private int age;
private int salary;

public Ali(int a,int s){
  age = a;
  salary = s;
}
public int getAge(){
  return age;
}
public int getSalary(){
  return salary;
}
public String toString(){
  return "String:"+age + salary;
}
}