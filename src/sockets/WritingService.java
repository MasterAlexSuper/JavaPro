package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WritingService {
    PrintWriter output;

    public WritingService(Socket socket) {
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println(Message.text.GREETINGS.get());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void write(String message) {
        output.println(message);
    }

}
