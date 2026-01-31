import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class BouncingBallGame extends JPanel implements ActionListener, KeyListener {

    // Ball properties
    int x = 50, y = 50, diameter = 40;
    int xSpeed = 4, ySpeed = 4;

    // Score and game control
    int score = 0;
    boolean gameOver = false;

    Timer timer;
    String playerName;

    // JDBC variables
    Connection con = null;
    PreparedStatement pstmt = null;

    public BouncingBallGame(String playerName) {
        this.playerName = playerName;

        // Timer for animation (refresh every 20ms)
        timer = new Timer(20, this);
        timer.start();

        // Add KeyListener to move or restart game
        setFocusable(true);
        addKeyListener(this);

        // Set background color
        setBackground(Color.BLACK);

        // Setup Database Connection
        connectToDB();
    }

    // ----------------- JDBC CONNECTION -------------------
    void connectToDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbPath = "E:/JavaProjects/GameDB.accdb";  // change path
            String url = "jdbc:ucanaccess://" + dbPath;
            con = DriverManager.getConnection(url);
            System.out.println("✅ Database Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ----------------- PAINT GRAPHICS -------------------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw ball
        g2.setColor(Color.CYAN);
        g2.fillOval(x, y, diameter, diameter);

        // Draw score
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 18));
        g2.drawString("Score: " + score, 10, 20);

        if (gameOver) {
            g2.setColor(Color.RED);
            g2.setFont(new Font("Arial", Font.BOLD, 30));
            g2.drawString("Game Over!", 100, 150);
            g2.drawString("Press ENTER to Restart", 60, 200);
        }
    }

    // ----------------- ANIMATION -------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            x += xSpeed;
            y += ySpeed;

            // Bounce off walls
            if (x <= 0 || x + diameter >= getWidth()) {
                xSpeed = -xSpeed;
                score += 10;
            }
            if (y <= 0 || y + diameter >= getHeight()) {
                ySpeed = -ySpeed;
                score += 10;
            }

            // Random game over condition (optional for demo)
            if (score >= 200) {
                gameOver = true;
                timer.stop();
                saveScoreToDB();
            }

            repaint();
        }
    }

    // ----------------- SAVE SCORE -------------------
    void saveScoreToDB() {
        try {
            String insert = "INSERT INTO Players (PlayerName, Score) VALUES (?, ?)";
            pstmt = con.prepareStatement(insert);
            pstmt.setString(1, playerName);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
            System.out.println("✅ Score saved for " + playerName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ----------------- KEY EVENTS -------------------
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ENTER && gameOver) {
            // Restart the game
            gameOver = false;
            score = 0;
            x = 50;
            y = 50;
            xSpeed = 4;
            ySpeed = 4;
            timer.start();
            repaint();
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    // ----------------- MAIN -------------------
    public static void main(String[] args) {
        String player = JOptionPane.showInputDialog("Enter your name:");
        if (player == null || player.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name is required!");
            return;
        }

        JFrame frame = new JFrame("🎮 Bouncing Ball Game");
        BouncingBallGame gamePanel = new BouncingBallGame(player);

        frame.add(gamePanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
