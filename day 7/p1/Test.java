//mouse events
//listener interfaces are 
//MouseMotionListner
//used for processing mouse motion events  ,when mouse is move or draged 
//public void mouseDraged(MouseEvent me);
//public void mouseMoved(MouseEvent me);
//MouseListner
//generated when mouse is presses released ,clicked Enter(enter in bounds ofcomponent) Exit(enter in bounds ofcomponent)
//public void mousePressed(MouseEvent me);
//public void mouseClicked(MouseEvent me);
//public void mouseReleased(MouseEvent me);
//public void mouseEntered(MouseEvent me);
//public void mouseExit(MouseEvent me);
//here is an example
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseEeEx implements MouseMotionListener {
    private JFrame myFrame;
    private JLabel coord;

    public MouseEeEx() {
        initGUI();
    }

    void initGUI() {
        myFrame = new JFrame("Mouse Motion Detector");
        coord = new JLabel("Move or drag the mouse...");

        myFrame.setLayout(new FlowLayout());
        myFrame.add(coord);
        myFrame.setSize(400, 200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.addMouseMotionListener(this);
        myFrame.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        coord.setText("Dragged at [x = " + x + ", y = " + y + "]");
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        coord.setText("Moved at [x = " + x + ", y = " + y + "]");
    }
}

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseEeEx::new);
    }
}



// import java.util.*;
// import java.io.*;
// import java.swing.*;
// import java.swing.events.*;
// import java.awt.*;

// class MouseEeEx extends MouseMotionListener{
//  private JFrme myFrame ;
//  JLabel coord;


//  public MouseEeEx(){
//   initGUI();
//  }
//  void initGUI(){
//     myFrame = new JFrme("Mouse motion detector");
//     coord = new JLabel();

//     myFrame.add(coord);
//     myFrame.setSize(2000,2000);
//     myFrame.setLayout(new FlowLayout());
//     myFrame.addMouseMotionListener(this);

//  }
//  public void mouseDraged(MouseEvent me){
//   int x = me.getX();
//   int y = me.getY();

//   coord.setText("Dragged at [ x = "+x +", y ="+ y+"]");
//  }
//   public void mouseMoved(MouseEvent me){
//   int x = me.getX();
//   int y = me.getY();

//   coord.setText("Moved at [ x = "+ x +", y ="+ y+"]");
//  }
// } 
// public class Test{
//   public static void main(String[] args){
//     SwingUtilities.invokeLater(MouseEeEx::new);
//   } 
// }