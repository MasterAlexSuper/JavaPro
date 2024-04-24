import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[14];
        Arrays.fill(words, "apple");
        System.out.println("Occurance " + countOccurance(words, "apple"));
        System.out.println(toList(words));
        Integer[] integers = {3, 4, 5, 2, 4, 66, 3, 23, 6, 4};
        System.out.println("Only unique ints: " + findUnique(integers));
        List<String> words2 = List.of("apple", "bird", "fox", "fox", "apple", "apple", "bird", "bear", "bear", "cat", "frog", "frog", "frog", "frog", "frog");
        calcOccurance(words2);
        System.out.println(findOccurance(words2));
    }


    public static int countOccurance(String[] words, String target) {
        int occurance = 0;
        for (String word : words) {
            if (word.equals(target)) {
                occurance++;
            }
        }
        return occurance;
    }

    public static List<Object> toList(Object[] toConvert) {
        List<Object> converted = new ArrayList<Object>(Arrays.asList(toConvert));
        return converted;
    }

    public static List<Object> findUnique(Integer[] integers) {
        Set<Object> unique = new HashSet<>(toList(integers));
        return new ArrayList<>(unique);
    }

    public static void calcOccurance(List<String> words) {
        Set<String> unique = new HashSet<>(words);

        for (String word : unique) {
            int currentOccurance = 0;
            for (String word2 : words) {
                if (word.equals(word2)) {
                    currentOccurance++;
                }
            }
            System.out.println("\"" + word + "\"" + " occurance: " + currentOccurance);
        }
    }

    public static List<OccuranceItem> findOccurance(List<String> words) {
        Set<String> unique = new HashSet<>(words);
        List<OccuranceItem> occuranceItems = new ArrayList<>();
        for (String word : unique) {
            int currentOccurance = 0;
            for (String word2 : words) {
                if (word.equals(word2)) {
                    currentOccurance++;
                }
            }
            occuranceItems.add(new OccuranceItem(currentOccurance, word));
        }
        return occuranceItems;
    }
}