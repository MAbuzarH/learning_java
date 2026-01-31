/* 
Throwable class
children:
Error and exception

Exception chiledren:
Unchecked Exception (Run time Exception) , Checked Exception(IoException, Sqlconnectivity ,Class not found )

we handle these using:
try{
//code you think throw exception
}catch(){
//code run when exception thrown
}finally{
//code must run in any cae of probem
}
*/

public class Test{
  public static void main(String[] args){
    int crrBal = 10000;
    int wr = 11000;

   
    try{
      if(wr>crrBal){
        throw new ArithmeticException("insufficient Balance");

      }
       crrBal = crrBal - wr;
       System.out.println("Transition successful");
       System.out.println("Current bal is:" + crrBal);

    }catch(ArithmeticException e1){
      System.out.println(e1.getMessage());
      System.out.println("Current bal is:" + crrBal);
    }
  }
}