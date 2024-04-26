package phonebook;

public class Record {
    public String name; // Alexandr said it`s better to write null/0 to primitives, so i used it(((
    public String phoneNumber;

    public Record(String name, String phoneNumber) {
        this.name = name.trim();
        this.phoneNumber = phoneNumber.trim();
    }
}
