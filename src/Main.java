
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        app();
    }

    public static void app() {
        System.out.println("Hello, I will help you to get statistic about any book you want");
        // app scans src/ directory for the txt files
        boolean runnig = true;
        while (runnig) {
            List<Path> books = getBooks();
            // app ask user to a book he wants to parse and returns its path
            Path pathToBook = getBookPath(books);
            runnig = parsBook(pathToBook);
        }
    }

    public static boolean parsBook(Path path) {
        // first app reads the book and exact all words and creating a map to calculate amount of words
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            Map<String, Long> wordsCount = br.lines()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .map(String::toLowerCase)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            // app receives unique words
            Set<String> uniqueWords = wordsCount.keySet();
            // hear app counts words that have more than two symbols and make 10 the most popular
            Map<String, Long> top10Words = wordsCount.entrySet().stream()
                    .filter(pair -> pair.getKey().length() > 2)
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            // app creates file with all the statistic we need
            String newFileName = path.getFileName().toString().replaceFirst("[.][^.]+$", "") + "_statistic.txt";
            Path newPath = path.getParent().resolve(newFileName);
            File statisticFile = newPath.toFile();

            // app writes all the info about book in file
            try (PrintWriter pw = new PrintWriter(statisticFile)) {
                pw.println("Number of unique words: " + uniqueWords.size());
                pw.println("Top 10 words:");
                top10Words.forEach((word, count) -> pw.println(word + " " + count));
                System.out.println("Top 10 popular words:");
                top10Words.forEach((word, count) -> System.out.println(word + " " + count));
                System.out.println("Number of unique popular words: " + uniqueWords.size());

            } catch (IOException e) {
                System.out.println("Something went wrong");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to parse any other book? (y/n)");
            String answer = scanner.next();
            return answer.equalsIgnoreCase("y");
        } catch (IOException e) {
            System.out.println("Book not found");
            return true;
        }
    }


    // This method asks user to put number of book he wants to parse and returns path to the book
    public static Path getBookPath(List<Path> books) {
        Scanner scanner = new Scanner(System.in);
        int bookNumber;
        while (true) {
            System.out.println("Please enter the book number");
            String number = scanner.nextLine();
            try {
                bookNumber = Integer.parseInt(number);
                if (bookNumber < 1 || bookNumber > books.size()) {
                    throw new NoBookException("The book number is invalid");
                }
                return books.get(bookNumber - 1);

            } catch (NoBookException | NumberFormatException e) {
                System.out.println("You entered an invalid book number");
            }
        }
    }

    // We are getting all the txt files from src/ and return their paths
    public static List<Path> getBooks() {
        List<Path> txtFiles = new ArrayList<>();
        String directoryPath = "src";

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            txtFiles = paths
                    .filter(path -> path.toString().endsWith(".txt"))
                    .toList();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        // if there is no txt files found we close application
        // in case we found it we are printing all the names in console
        if (txtFiles.isEmpty()) {
            System.out.println("Unfortunately no files found");
            System.exit(0);
        } else {
            System.out.println("Found " + txtFiles.size());
            for (int i = 0; i < txtFiles.size(); i++) {
                System.out.println(i + 1 + ": " + txtFiles.get(i).getName(1));
            }
        }
        return txtFiles;
    }
}