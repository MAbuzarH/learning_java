//FlowLayout
//-place components in line as long as they fit then start next line
//-uses best gudgment in spacing  components centers by default
//-lets assume each component assume its natural preffered size
//-often use on placing button on panels
//GridLayout
//-splits the grid into a grid with a given rows and colum 
//-place components into the grid cell
//-forces the each component to accoupy each cell
//-allows aditional spaces between cells

//BorderLayout
//-Divide area into 5 region
// |        North        |
// | west | center | East|
// |        South        |
//-add a component in specific region
//-forces a component to accoupy whole region

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
   
    c.setLayout(new GridLayout(3,2,10,20));
    
    //
    c.setLayout(new BorderLayout(3,2,10,20));
    JButton b2 = new JButton("next slide");
    JButton b3 = new JButton("Previous slide");
    JButton b4 = new JButton("Stop   slide");
    c.add(tf,BorderLayout.NORTH);
    c.add(b1,BorderLayout.SOUTH);
    c.add(b2,BorderLayout.EAST);
    c.add(b3,BorderLayout.WEST);
    c.add(b4,BorderLayout.CENTER);
    
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
