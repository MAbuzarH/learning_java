package B1;
public class Abuzar{
  private int age;
  private String qual;

  public Abuzar(int a,String q){
    age = a;
    qual = q;
  }
  public int getAge(){
   return age;
  }
  public String getQual(){
    return qual;
  }
  public String toString(){
    return "My age is "+ age + " and " + qual +"is my Qualification";
  }
}