import java.util.*;
class Account{
  int bal;
  Account(int x){
    bal = x;
  }
  boolean isSuffeicentBal(int w){
    if(bal>w){
      return true;
    }
    return false;
  }

  public void withdraw(int amount){
    bal = bal - amount;
    System.out.println("Amount Widraw Sucessfully Remaning bal is: "+bal);
  }

}
class Customer implements Runnable{
  Account a1;
  String name;
  Customer(Account x1,String n){
    a1 = x1;
    name = n;
  }

  public void run(){
    
   Scanner s1 = new Scanner(System.in);
   synchronized(a1){
   System.out.println(name +": Enter Amount to Widraw ");
   int amt =  s1.nextInt();

   if(a1.isSuffeicentBal(amt)){
     a1.withdraw(amt);
   }
   else{
    System.out.println(name +":Insufficient balance ");
   }
   }
  }
}
class Test{
  public static void main(String[] args){
    Account a1 = new Account(5000);
    Customer c1 = new Customer(a1,"ali");
    Customer c2 = new Customer(a1,"jafar");
    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    t1.start();
    t2.start();
  }
}