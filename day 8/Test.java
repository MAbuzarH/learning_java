//inner class, adapter class event handler and interface learning 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// =================== Main GUI Class ===================
class MainWindow extends JFrame {

    private JButton clickButton;
    private JLabel infoLabel;
    private JTextField inputField;

    public MainWindow() {
        setTitle("Event Handling Demo - Main Window");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clickButton = new JButton("Click Me");
        infoLabel = new JLabel("Interact with the window!");
        inputField = new JTextField(15);

        add(clickButton);
        add(inputField);
        add(infoLabel);

        // Register event handlers
        clickButton.addActionListener(new ButtonHandler()); // Interface-based inner class
        addMouseListener(new MyMouseHandler());             // Interface-based inner class
        addWindowListener(new MyWindowHandler());           // Adapter-based inner class

        // Anonymous inner class for KeyAdapter
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char ch = ke.getKeyChar();
                infoLabel.setText("You typed: " + ch);
            }
        });

        setVisible(true);
    }

    // ============ Inner class 1: ActionListener ============
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            infoLabel.setText("Button clicked!");
            JOptionPane.showMessageDialog(MainWindow.this, "Button was clicked!");
        }
    }

    // ============ Inner class 2: MouseListener ============
    private class MyMouseHandler implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            infoLabel.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {
            infoLabel.setText("Mouse entered window");
        }
        @Override public void mouseExited(MouseEvent e) {
            infoLabel.setText("Mouse exited window");
        }
    }

    // ============ Inner class 3: WindowAdapter ============
    private class MyWindowHandler extends WindowAdapter {
        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Main window activated.");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Main window closing.");
        }
    }
}

// =================== Second GUI Class ===================
class ExtraWindow extends JFrame {

    public ExtraWindow() {
        setTitle("Extra Window - Adapter Example");
        setSize(300, 200);
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Close this window to see event handling");
        add(label);

        // Using an anonymous adapter class
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(ExtraWindow.this, "Extra window closing...");
                dispose();
            }
        });

        setVisible(true);
    }
}

// =================== Test / Entry Class ===================
public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainWindow();
            new ExtraWindow();
        });
    }
}
