package phonebook;

import java.util.ArrayList;
import java.util.List;


public class PhoneDirectory {
    List<Record> records = new ArrayList<Record>();

    // Add a record to PhoneDirectory
    public void addRecord(Record record) {
        this.records.add(record);
    }

    // Find first Record by name
    public Record find(String name) {
        Record found = null;
        for (Record record : records) {
            if (name.equals(record.name)) {
                found = record;
                break;
            }
        }
        return found;
    }

    // Find all Records by name
    public List<Record> findAll(String name) {
        List<Record> found = null;
        for (Record record : records) {
            if (name.equals(record.name)) {
                found.add(record);
            }
        }
        return found;
    }


    public PhoneDirectory() {
    }

    public PhoneDirectory(List<Record> records) {
        this.records = records;
    }

}
