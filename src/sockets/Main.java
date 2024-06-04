package sockets;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


public class Main {


    public static void main(String[] args) {
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(Message.text.START.get());

            Socket socket = serverSocket.accept();
            System.out.println(Message.text.CONNECTED.get());

            WritingService output = new WritingService(socket);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String msg = input.readLine();
            while (msg == null || msg.isEmpty()) {
                output.write(words.GREET.getWord());
                msg = input.readLine();
            }

            if (hasRussianChar(msg) || msg.equalsIgnoreCase(words.BAD_TIME.getWord())) {
                if (!doStrawberryCheck(output, input)) {
                    output.write(Message.text.RESTRICTED.get());
                    socket.close();
                }
                output.write(Message.text.RIGHT.get());
            } else {
                doWork(output, socket);
            }
            doWork(output, socket);

        } catch (IOException e) {
            System.out.println(Message.text.ERROR.get() + e.getMessage());
        }
    }

    public static boolean hasRussianChar(String message) {
        final Set<Character> russianChars = Set.of('ъ', 'ё', 'ы');
        for (char letter : message.toCharArray()) {
            if (russianChars.contains(letter)) return true;
        }
        return false;
    }

    public static boolean doStrawberryCheck(WritingService writer, BufferedReader reader) {
        writer.write(Message.text.STRAWBERRY.get());
        try {
            return reader.readLine().equalsIgnoreCase(words.BERRY.getWord());
        } catch (IOException e) {
            System.out.println(Message.text.ERROR.get() + e.getMessage());
        }
        return false;
    }

    public static void doWork(WritingService output, Socket socket) throws IOException {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern(words.FORMATTER.getWord());
        String dataTime = LocalDateTime.now().format(formater);

        output.write(dataTime);
        output.write(Message.text.GOODBYE.get());
        socket.close();
    }
}

enum words {
    GREET("Привітайся!"),
    FORMATTER("yyyy-MM-dd HH:mm:ss"),
    BAD_TIME("время"),
    BERRY("ягода"),
    EXIT("exit"),
    CLOSE("close");

    final String word;

    words(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}