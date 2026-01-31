interface i1 {
    int x = 10;   // public static final by default

    void fun();   // public abstract by default

    static void fun1() {
        System.out.println("static fun 1");
    }
}
//in interface static member variable in harit but static function could not;
//we can override static variable in interface
interface i2 extends i1 {
    int y = 20;
    int x = 11; //overriding
    void fun2();
}

class C1 implements i2 {
    int z;

    public C1(int k) {
        z = k;
    }

    @Override
    public void fun() {
        System.out.println("Implementation of fun");
    }

    @Override
    public void fun2() {
        System.out.println("Implementation of fun2");
    }
}

public class Test {
    public static void main(String[] args) {
        C1 c = new C1(10);

        System.out.println(c.x);   // interface variable
        c.fun();
        c.fun2();
        // c.fun1(); //Error:Static member couldnot Inharit 
        i1.fun1(); // static interface method
        i1 i; //we can create refrence variable of interface  
    }
}
