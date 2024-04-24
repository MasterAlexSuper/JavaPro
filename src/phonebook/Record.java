package phonebook;

public class Record {
    String name = null;
    String phoneNumber = null;

    public Record(String name, String phoneNumber) {
        this.name = name.trim();
        this.phoneNumber = phoneNumber.trim();
    }
}
