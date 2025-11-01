import java.util.*;

class Student {
    private int Id;
    private String Name;

    Student(int id, String name) {
        this.Id = id;
        this.Name = name;
    }

    public void display() {
        System.out.println("Id: " + Id + ", Name: " + Name);
    }
}

public class Test {
    public static void main(String args[]) {
        ArrayList<Student> al = new ArrayList<>();

        Student s1 = new Student(1, "Ali");
        Student s2 = new Student(2, "Jafar");

        al.add(s1);
        al.add(s2);

        boolean b = al.isEmpty();
        if (b == true) {
            System.out.println("ArrayList is empty");
        } else {
            int size = al.size();
            System.out.println("ArrayList size: " + size);
        }

        for (int i = 0; i < al.size(); i++) {
            Student s = al.get(i);
            s.display();
        }

        HashMap<String, Student> h = new HashMap<>();

        h.put("one", s1);
        h.put("two", s2);  // ✅ different key

        boolean hb = h.isEmpty();
        if (hb == true) {
            System.out.println("HashMap is empty");
        } else {
            int size = h.size(); // ✅ previously used al.size() by mistake
            System.out.println("HashMap size: " + size);
        }

        Student s = h.get("one");
        s.display();
    }
}



// //import java.util.HashMap;
// import java.util.*;


// class Student{
//   private int Id;
//   private String Name;
//   Student(int id,String name){
//     this.Id = id;
//     this.Name = name;
//   } 
//   public void display(){
//     System.out.println("Id"+Id+", Name"+Name);
//   }
// }

// public class Test{
//   public static void main(String args[]){
//    ArrayList al = new ArrayList();
//    Student s1 = new Student(1,"Ali");
//    Student s2 = new Student(2,"jafar");
//    al.add(s1);
//    al.add(s2);
//    boolean b = al.isEmpty();
//    if(b == true){
//     System.out.println("array is empty");
//    }else{
//     int size = al.size();
//     System.out.println("size:"+size);
//    }  
//    for(int i =0; i < al.size(); i++){
//     Student s = (Student) al.get(i); //down casting
//     s.display();
//    }

//    HashMap h = new HashMap();
//    h.put("one",s1);
//    h.put("one",s2);
//    boolean hb = h.isEmpty();
//    if(hb == true){
//     System.out.println("array is empty");
//    }else{
//     int size = al.size();
//     System.out.println("size:"+size);
//    } 
    
//     Student s = (Student) h.get("one"); //down casting
//     s.display();
   
//   }
// }