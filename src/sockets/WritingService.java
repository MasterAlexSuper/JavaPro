package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WritingService implements Runnable {
    private final Socket socket;

    public WritingService(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            output.println(Messages.message.greetings.send());
            String serverMessege;
            while (true) {
                serverMessege = scanner.nextLine();
                if (serverMessege.equals("exit")) {
                    socket.close();
                    break;
                }
                output.println("Server: " + serverMessege);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
