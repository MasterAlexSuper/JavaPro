import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String hello = "Hello World!";
        ans(2);
        findSymbolOccurance(hello, 'h');
        ans(3);
        System.out.println(findWordPosition("Apple", "Plant"));
        ans(4);
        System.out.println(stringReverse(hello));
        ans(5);
        System.out.println(isPalindrome("ERE"));
        System.out.println(isPalindrome("Allo "));
        System.out.println();
        System.out.println("THE GAME");
        game();
    }


    public static void findSymbolOccurance(String str, char letter) {
        int occurance = 0;

        char[] chars = str.toLowerCase().toCharArray();
        for (char character : chars) {
            if (letter == character) {
                occurance += 1;
            }
        }
        System.out.println("Occurrence \"" + letter + "\" in " + str + " = " + occurance);

    }

    public static int findWordPosition(String source, String target) {
        int pos;

        pos = source.toLowerCase().indexOf(target.toLowerCase());
        return pos;
    }

    public static String stringReverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        return reversed.toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = stringReverse(str);
        return reversed.equals(str);
    }

    public static void game() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int rundomNum = random.nextInt(words.length);

//        System.out.println(rundomNum);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Let`s play a game, try to guess the word I thought");
        System.out.println("It`s one of these:");
        for (String fruit : words) {
            System.out.print(fruit + ", ");
        }
        boolean isGuessed = false;

        char[] secretArr = new char[15];
        Arrays.fill(secretArr, '#');

        while (!isGuessed) {

            String secret = words[rundomNum];
//            System.out.println(secret);
            System.out.println("\nNow type your guess");
            String guess = scanner.next();
            guess = guess.trim();


            if (guess.equals(secret)) {
                System.out.println("Congrats, you won this game");
                isGuessed = true;
            } else {
                helper(guess, secret, secretArr);
            }
        }

    }

    public static void helper(String guess, String ans, char[] secretArr) {

        char[] guessarr = guess.toCharArray();
        char[] ansArr = ans.toCharArray();
        int minLength = Math.min(guessarr.length, ansArr.length);
        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (guessarr[i] == ansArr[i] && secretArr[i] == '#') {
                secretArr[i] = ansArr[i];
            }
        }
        for (char letter : secretArr) {
            hint.append(letter);
        }

        System.out.println("Wrong look at the hint: " + hint);

    }

    public static void ans(int n) {
        System.out.println("\nAnswer to task " + n);
    }
}