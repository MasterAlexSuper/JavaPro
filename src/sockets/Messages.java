package sockets;

public class Messages {

    public enum message {
        start("Server started"),
        connected("Client connected"),
        error("Error acquired, error message: "),
        greetings("Привіт друже");


        private final String info;

        message(String value) {
            this.info = value;
        }

        public String send() {
            return (info);
        }
    }

}
