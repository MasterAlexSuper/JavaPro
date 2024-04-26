public class OccuranceItem {
    private int occurrence = 0;
    private String name = null;

    public OccuranceItem(int occurrence, String name) {
        this.occurrence = occurrence;
        this.name = name;
    }


    @Override
    public String toString() {
        return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
    }
}
