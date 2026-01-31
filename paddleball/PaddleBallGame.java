
     
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class PaddleBallGame extends JPanel implements ActionListener, KeyListener {

    // Ball properties
    int ballX = 100,ballY = 100;
    int ballSize = 20;
    int ballSpeedX = 3, ballSpeedY = 3;

    //paddle properties
    int paddleX = 150;
    int paddleY = 260;
    int paddleWidth = 100;
    int paddleHeight = 10;
    int paddleSpeed = 20;

    //game
    // Score and game control
    int score = 0;
    boolean gameOver = false;
    Timer timer;

    //player name
    String playerName;


    // JDBC variables
    Connection con = null;


    public PaddleBallGame(String playerName) {
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
             String dbPath = "E:\\learning java\\bouncingball\\GameDb.accdb"; // change path
            String url = "jdbc:ucanaccess://" + dbPath;
            con = DriverManager.getConnection(url);
            System.out.println("Database Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ----------------- PAINT GRAPHICS -------------------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, ballSize, ballSize);
        
        //Draw Paddle
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 20);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over!", 100, 150);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press ENTER to Restart", 80, 200);
        }
    }

    // -------------------- GAME LOOP (TIMER) ---------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
           // Move ball
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            // Bounce on top
            if (ballY <= 0) {
                ballSpeedY = -ballSpeedY;
                score += 5;
            }

            // Bounce on left or right walls
            if(ballX <= 0 || ballX+ballSize >= getWidth()){
              ballSpeedX = -ballSpeedX;
            }
           
           //paddle collision
           if(ballY + ballSize >= paddleY && ballX + ballSize >= paddleX && ballX <= paddleX + paddleWidth ){
            ballSpeedY = -ballSpeedY;
            score += 10;
          
           }

           //missed the paddle ->GameOver
           if(ballY > getHeight()){
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
            String sql = "INSERT INTO Players (PlayerName, Score) VALUES (?, ?)";
           PreparedStatement pstmt  = con.prepareStatement(sql);
           pstmt.setString(1,playerName);
           pstmt.setInt(2,score);
           pstmt.executeUpdate();
           System.out.println("Score Saved!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ----------------- KEY EVENTS -------------------
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //move paddle left 
        if(key == KeyEvent.VK_LEFT){
          paddleX -= paddleSpeed;
          if(paddleX < 0) paddleX = 0;
        }
        //move paddle right 
        if(key == KeyEvent.VK_RIGHT){
          paddleX += paddleSpeed;
          if(paddleX + paddleWidth > getWidth()){
            paddleX = getWidth() - paddleWidth;
          }
        }

        //restart event
        if(key == KeyEvent.VK_ENTER && gameOver){
          resetGame();
        }
    }
    void resetGame(){
      ballX = 100;
      ballY = 100;
      ballSpeedX = 3;
      ballSpeedY = 3;
      paddleX = 150;

      score = 0;
      gameOver = false;
      timer.start();
      repaint();
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

        JFrame frame = new JFrame("Paddle Ball Game");
        PaddleBallGame gamePanel = new PaddleBallGame(player);

        frame.add(gamePanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

 