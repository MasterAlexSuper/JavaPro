public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String name = "Alex";
        int age = 21;
        System.out.println("My name is " + name + " and I`m " + age + " years old");
        int[] numbers = {1, 2, 3, 4, 5};
        for(int i = 0; i < numbers.length;i++){
            System.out.println("Number " + i + ": " + numbers[i]);
        }
    }
}