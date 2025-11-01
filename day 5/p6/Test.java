//1event generator//sorce
//swing and awt components 
//eg JButton JTextField JFrame etc
//generates an event object
//register listner with itself
//2Event object 
//Encapsulae information about event that accoured and source of that event
//eg if click a button action event is created
//3 event listener /handler 
//-received event objects when notify then respond
//-each event sourse can have multipal listner registered on it
//-conversily a single listner can register with multipal event source 
//4jvm
//recives an event where one is generoter
//looks for listner /handler for that event
//if exist deligate it for processing
//if not dicard event 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ActionEventTest implements ActionListener{
  private  JFrame frame;
  private  JButton bHello;

  public ActionEventTest(){
    initGUI();
  }

  private void initGUI(){
   frame = new JFrame("Hellow button event");
   //event generator
   bHello = new JButton("Hello");

   //add event listner
   bHello.addActionListener(this);
  //  bHello.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Hello is pressed"));
   

  //  Container con = frame.getContentPane();
  //  con.add(bHello);
   
  // Set up frame
  frame.setLayout(new FlowLayout());
  frame.add(bHello);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(200, 200);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
  }

  // @Override
  public void actionPerformed(ActionEvent ae){
   JOptionPane.showMessageDialog(frame,"Hello is pressed");
  }
}

public class Test{
  public static void main(String[] args){
     SwingUtilities.invokeLater(ActionEventTest::new);
  }
}