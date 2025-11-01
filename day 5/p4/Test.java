
// support gui
// abstract window toolkit (AWT) & swing packages
// -provides rich set of user interface componens
// -java.awt & java.swing
// -old(AWT) vs new(Swing) vs modren(javaFx);
// awt elements are havey weight the problem with this is when we run our app on
// window it showse diffrent element but when we put it on linux it change the design of that element
//Layout Manager
//FlowLayout
//Grid Layout
//Border Layout
//Box layout
//GridBag layout

import javax.swing.*;
import java.awt.*;

//class GUITest extends JFrame{} this is another way if we use this no need to create obj of Jframe,this methord is called inharitence

//this method is called composition
class GUITest {
  JFrame myFrame;
  JTextField tf;
  JButton b1;

  public GUITest() {
    initGUI();
  }

  public void initGUI() {
    myFrame = new JFrame("My swing App");

    Container c = myFrame.getContentPane();// get component area from JFrame()

    // apply layout 
    c.setLayout(new FlowLayout());

    
    // create and add components
    tf = new JTextField(10);
    b1 = new JButton("My Button");

    c.add(tf);
    c.add(b1);

    // set size and make it visiable
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setSize(500, 350);
    myFrame.setLocationRelativeTo(null); // center window
    myFrame.setVisible(true);

  }

}

public class Test {

  public static void main(String[] argv) {
    // GUITest gui = new GUITest();
    SwingUtilities.invokeLater(GUITest::new);
  }
}