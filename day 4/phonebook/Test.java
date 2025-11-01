//modren code for address book
import java.util.*;
import java.io.*;
import javax.swing.*;
class PersonInfo {
    private final String name;
    private final String address;
    private final String phoneNum;

    public PersonInfo(String name, String address, String phoneNum) {
        this.name = name.trim();
        this.address = address.trim();
        this.phoneNum = phoneNum.trim();
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhn() {
        return phoneNum;
    }

    public void printPersonInfo() {
        JOptionPane.showMessageDialog(
            null,
            "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNum,
            "Person Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
     @Override
    public String toString() {
        return name + "," + address + "," + phoneNum;
    }
}
class AddressBook {
    private final ArrayList<PersonInfo> persons= new ArrayList<>();
    private static final String FILE_NAME = "input.txt";
    public AddressBook() {
        loadPerson();
    }
    
    public void loadPerson(){
        
        try(
          BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        ){
         String line ;

         while((line = br.readLine())!= null){
          String[] tokens = line.split(",");
           if(tokens.length == 3){
            persons.add(new PersonInfo(tokens[0],tokens[1],tokens[2]));
           }
         }
         JOptionPane.showMessageDialog(null, "Data loaded successfully from " + FILE_NAME);
        }catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "No existing data file found. Starting fresh.");
        }catch(IOException e){
           JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }
    public void addPerson() {
        String name = JOptionPane.showInputDialog("Enter name of the person:");
        if (name == null || name.isEmpty()) return; // user cancelled

        String address = JOptionPane.showInputDialog("Enter address:");
        if (address == null || address.isEmpty()) return;

        String phoneNum = JOptionPane.showInputDialog("Enter phone number:");
        if (phoneNum == null || phoneNum.isEmpty()) return;

        persons.add(new PersonInfo(name, address, phoneNum));
        JOptionPane.showMessageDialog(null, "Person added successfully!");
    }

    public void searchPerson(String name) {
        boolean found = false;
        for (PersonInfo p : persons) {
            if (name.equalsIgnoreCase(p.getName())) {
                p.printPersonInfo();
                found = true;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Person not found!");
        }
    }

    public void deletePerson(String name) {
        boolean deleted = persons.removeIf(p->name.equalsIgnoreCase(p.getName()));
        String message = deleted ? "Person deleted successfully!" : "Person not found!";
        JOptionPane.showMessageDialog(null, message);
    }

    public void savePerson(){
        try(
         PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))
        ){
            for(PersonInfo p: persons){
                pw.println(p.toString());
            }
            JOptionPane.showMessageDialog(null, "Data saved to " + FILE_NAME);
        }catch(IOException ex){
            System.out.println("Error saving File: "+ex.getMessage());
        }
    }
}

public class Test {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        while (true) {
            String input = JOptionPane.showInputDialog(
                "Choose an option:\n"
                + "1 - Add Person\n"
                + "2 - Search Person\n"
                + "3 - Delete Person\n"
                + "4 - Quit"
            );

            if (input == null) break; // user pressed Cancel
            if(input.isEmpty()) continue;


            char choice = input.charAt(0);

            switch (choice) {
                case '1' -> addressBook.addPerson(); 
                case '2' -> {
                    String name = JOptionPane.showInputDialog("Enter name to search:");
                    if (name != null) addressBook.searchPerson(name);
                    break;
                }
                case '3'->{
                    String name = JOptionPane.showInputDialog("Enter name to delete:");
                    if (name != null) addressBook.deletePerson(name);
                    break;
                }
                case '4' -> {
                    addressBook.savePerson();
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.");
                
            }
        }
    }
}


// import java.util.*;
// import java.io.*;
// import javax.swing.*;

// class PersonInfo {
//     private String name;
//     private String address;
//     private String phoneNum;

//     public PersonInfo(String n, String a, String p) {
//         this.name = n;
//         this.address = a;
//         this.phoneNum = p;
//     }

//     public String getName() {
//         return name;
//     }
//     public String getAddress() {
//         return address;
//     }
//     public String getPhn() {
//         return phoneNum;
//     }

//     public void printPersonInfo() {
//         JOptionPane.showMessageDialog(
//             null,
//             "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNum,
//             "Person Information",
//             JOptionPane.INFORMATION_MESSAGE
//         );
//     }
// }

// class AddressBook {
//     private ArrayList<PersonInfo> persons;

//     public AddressBook() {
//         persons = new ArrayList<>();
//         loadPerson();
//     }
    
//     public void loadPerson(){
//         String tokens[] = null;
//         String name,adr,phn;
//         try(
//           FileReader fr = new FileReader("input.txt");
//           BufferedReader br = new BufferedReader(fr);
//         ){
//          String line = br.readLine();
//          while(line != null){
//           tokens = line.split(",");
//           line = br.readLine();
//           name=tokens[0];
//           adr  = tokens[1];
//           phn = tokens[2];
//           PersonInfo p = new PersonInfo(name,adr,phn);
//           persons.add(p);
//          }
//         }catch(IOException ex){
//             System.out.println("Error: "+ex.getMessage());
//         }
//     }
//     public void addPerson() {
//         String name = JOptionPane.showInputDialog("Enter name of the person:");
//         if (name == null) return; // user cancelled

//         String address = JOptionPane.showInputDialog("Enter address:");
//         if (address == null) return;

//         String phoneNum = JOptionPane.showInputDialog("Enter phone number:");
//         if (phoneNum == null) return;

//         persons.add(new PersonInfo(name, address, phoneNum));
//         JOptionPane.showMessageDialog(null, "Person added successfully!");
//     }

//     public void searchPerson(String n) {
//         boolean found = false;
//         for (PersonInfo p : persons) {
//             if (n.equalsIgnoreCase(p.getName())) {
//                 p.printPersonInfo();
//                 found = true;
//             }
//         }
//         if (!found) {
//             JOptionPane.showMessageDialog(null, "Person not found!");
//         }
//     }

//     public void deletePerson(String n) {
//         Iterator<PersonInfo> it = persons.iterator();
//         boolean deleted = false;
//         while (it.hasNext()) {
//             PersonInfo p = it.next();
//             if (n.equalsIgnoreCase(p.getName())) {
//                 it.remove();
//                 deleted = true;
//             }
//         }
//         if (deleted) {
//             JOptionPane.showMessageDialog(null, "Person deleted successfully!");
//         } else {
//             JOptionPane.showMessageDialog(null, "Person not found!");
//         }
//     }

//     public void savePerson(){
//         try(FileWriter fr = new FileWriter("input.txt")){
//            PrintWriter pw = new PrintWriter(fr);
//            String s = " ";
//            for (int i =0; i< persons.size(); i++){
//             PersonInfo p = persons.get(i);
//             s = p.getName() + ","+p.getAddress()+","+p.getPhn();
//             pw.println(s);
//            }
//         }catch(IOException ex){
//             System.out.println("Error: "+ex.getMessage());
//         }
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         AddressBook addressBook = new AddressBook();

//         while (true) {
//             String input = JOptionPane.showInputDialog(
//                 "Choose an option:\n"
//                 + "1 - Add Person\n"
//                 + "2 - Search Person\n"
//                 + "3 - Delete Person\n"
//                 + "4 - Quit"
//             );

//             if (input == null) break; // user pressed Cancel
//             char choice = input.charAt(0);

//             switch (choice) {
//                 case '1': {
//                     addressBook.addPerson();
//                     break;
//                 }
//                 case '2': {
//                     String name = JOptionPane.showInputDialog("Enter name to search:");
//                     if (name != null) addressBook.searchPerson(name);
//                     break;
//                 }
//                 case '3': {
//                     String name = JOptionPane.showInputDialog("Enter name to delete:");
//                     if (name != null) addressBook.deletePerson(name);
//                     break;
//                 }
//                 case '4': {
//                     addressBook.savePerson();
//                     JOptionPane.showMessageDialog(null, "Goodbye!");
//                     System.exit(0);
//                     break;
//                 }
//                 default: {
//                     JOptionPane.showMessageDialog(null, "Invalid choice! Please try again.");
//                 }
//             }
//         }
//     }
// }


// // import java.util.*;
// // import javax.swing.*;
// // class PersonInfo{
// //   String name;
// //   String address;
// //   String phoneNum;

// //   public PersonInfo(String n,String a,String p){
// //     this.name = n;
// //     this.address = a;
// //     this.phoneNum = p;
// //   }
// //   public void printPersonInfo(){
// //     JOptionPane.ShowMessageDialog(null,"Name:"+name+",Address:"+address+",Phone Number:"+phoneNum);
// //   }
// // }
// // class AddressBook{
// //   ArrayList<PersonInfo> persons;
// //   public AddressBook(){
// //     persons = new ArrayList();
// //   }
// //   public void addPerson(){
// //    String name =  JOptionPane.ShowInputDialog("Enter name of a person");
// //    String address =  JOptionPane.ShowInputDialog("Enter Address of a person");
// //    String phoneNum =  JOptionPane.ShowInputDialog("Enter Phone number of a person");
// //    PersonInfo p = new PersonInfo(name,address,phoneNum);
// //    persons.add(p);
// //   }
// //   public void searchPerson(String n){
// //    for(int i = 0; i<persons.size(); i++){
// //      PersonInfo p = persons.get(i);
// //      if(n.equals(p.name)){
// //        p.printPersonInfo();
// //      }
// //    }
// //   }
// //   public void deletePerson(String n){
// //    for(int i = 0; i<persons.size(); i++){
// //      PersonInfo p = persons.get(i);
// //      if(n.equals(p.name)){
// //        persons.remove(i);
// //      }
// //    }
// //   }
// // }

// // public class Test{
// //   public static void main(String args[]){
// //     AddressBook add = new AddressBook();
// //     while(true){
// //      String input =  JOptionPane.ShowInputDialog("Enter 1 to add \n Enter 2 to search\n Enter 3 to Delete \n Enter 4 to quit \n"); 
// //     }
// //     char in = input.charAt(0);
// //     switch (in){
// //       case '1':
// //           add.addPerson();
// //           break;
// //       case '2':
// //         String name =  JOptionPane.ShowInputDialog("Enter name of a person to search");
// //           add.searchPerson(name);
// //           break;
// //       case '3':
// //         String name =  JOptionPane.ShowInputDialog("Enter name of a person to delete");
// //           add.deletePerson(name);
// //           break;
// //       case '4':
// //       System.exit(0);
// //     }
// //   }
// // }