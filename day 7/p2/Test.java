import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class  WindowEeEx implements MouseMotionListener , WindowListener{
    private JFrame myFrame;
    private JLabel coord;

    public WindowEeEx() {
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
        myFrame.addWindowListener(this);
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
    @Override
    public void  windowActived(WindowEvent we){
      
    }
    @Override
    public void  windowClosed(WindowEvent we){
      JOptionPane.showMessageDialog(null,("good by"));
      System.exit();
    }
    @Override
    public void  windowClosing(WindowEvent we){
      
    }
    @Override
    public void  windowDeactived(WindowEvent we){
      
    }
    @Override
    public void  windowDeconfined(WindowEvent we){
      
    }
    @Override
    public void  windowIconifined(WindowEvent we){
      
    }

}

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( WindowEeEx::new);
    }
}