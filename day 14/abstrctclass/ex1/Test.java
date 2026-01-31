//Interview question : does Abstract class have constrcture? yes
abstract class Person{

 private String name;
 int yearOfbirth;
 
 Person(String name,int yearOfbirth){
  this.name = name;
  this.yearOfbirth = yearOfbirth;
 }

 abstract public int getLisence();
 public void display(){
  System.out.println(name + " has " + yearOfbirth + " Birth year" );
 }
}

class BikeRider extends Person{
  private String city;

  BikeRider(String name,int yearOfbirth,String city){
    super(name,yearOfbirth);
    this.city = city;
  }

  // @override
  public int getLisence(){
    if( 2022 - super.yearOfbirth  > 18){
      return 1;
    }
    return 0;
  }
  
  public void display(){
    super.display();
    if(getLisence() == 1){
      System.out.println("Lives in: "+ city + "and Can drive bike");
    }else{
  System.out.println("Lives in: "+ city + " and Can not drive bike");
    }
  
  }
}

public class Test{
  public static void main (String[] args){
    BikeRider b1 = new BikeRider("ali",2000,"Lahore");
    b1.display();
    BikeRider b2 = new BikeRider("ali",2021,"Lahore");
    b2.display();
  }
}