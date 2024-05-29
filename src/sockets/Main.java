package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {


    public static void main(String[] args) {
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(Messages.message.start.send());


            Socket socket = serverSocket.accept();
            System.out.println(Messages.message.connected.send());

            Thread writer = new Thread(new WritingService(socket));
            writer.start();

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String msg;
            while (!(msg = input.readLine()).equals("exit") && !(msg.equals("close"))) {
                System.out.println("Client: " + msg);
            }
            socket.close();

        } catch (IOException e) {
            System.out.println(Messages.message.error.send() + e.getMessage());
        }
    }
}
