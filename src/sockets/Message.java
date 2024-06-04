package sockets;

public class Message {

    public enum text {
        START("Server started"),
        CONNECTED("Client connected"),
        ERROR("Error acquired, error message: "),
        STRAWBERRY("Ти хто? Що таке паляниця?"),
        RESTRICTED("Вам обмежено доступ"),
        GREETINGS("Привіт, друже"),
        RIGHT("Правильно!"),
        GOODBYE("До зустрічі!");

        private final String info;

        text(String value) {
            this.info = value;
        }

        public String get() {
            return info;
        }


    }

}
