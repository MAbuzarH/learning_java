//adapter classes
//for listner interfaces containing more than one event handling method java defines adapter classes Example are
// For WindowListener adapter class is WindowAdapter
//for MouseMotionListener use MouseMotionadapter
//these classes provides empty bodies for all method of their corresponding interface 


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowEeEx extends WindowAdapter {
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
        // myFrame.addMouseMotionListener(this);
        myFrame.addWindowListener(this);
        myFrame.setVisible(true);
    }

    // WindowListener methods
    @Override
    public void windowActivated(WindowEvent we) {
        System.out.println("Window Activated");
    }

    @Override
    public void windowClosed(WindowEvent we) {
        JOptionPane.showMessageDialog(null, "Goodbye!");
        System.exit(0);
    }
}

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WindowEeEx::new);
    }
}
