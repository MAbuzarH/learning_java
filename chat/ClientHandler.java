import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {

    private Socket socket;
    private String welcomeMessage;
    private String logFile;

    public ClientHandler(Socket socket, String welcomeMessage, String logFile) {
        this.socket = socket;
        this.welcomeMessage = welcomeMessage;
        this.logFile = logFile;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // Send welcome message
            out.println(welcomeMessage);

            String message;
            while ((message = in.readLine()) != null) {

                if (message.equalsIgnoreCase("bye")) {
                    out.println("Goodbye!");
                    break;
                }

                System.out.println("Client says: " + message);

                // respond
                out.println("Server Received: " + message);

                // append message to chat log
                writeToLog("Client: " + message);
            }

        } catch (Exception e) {
            System.out.println("Error with client: " + e.getMessage());
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
            System.out.println("Client disconnected.");
        }
    }

    // append messages to log file
    private void writeToLog(String msg) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            bw.write(msg);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }
}
