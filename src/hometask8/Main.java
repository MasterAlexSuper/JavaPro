package hometask8;


import java.time.Year;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Product> products = new LinkedList<>();
        products.add(new Product("Book", 300, 2));
        Thread.sleep(1000);
        products.add(new Product("Book", 10, 10));
        Thread.sleep(1000);
        products.add(new Product("Bike", 200, 15));
        Thread.sleep(1000);
        products.add(new Product("Book", 150, 7));
        Thread.sleep(1000);
        products.add(new Product("Car", 250, 3));
        Thread.sleep(1000);
        products.add(new Product("Book", 30, 4));
        Thread.sleep(1000);
        products.add(new Product("toy", 250, 20));

        sumOfCertainProducts(products);
    }

    // Method for 1.2
    public static LinkedList<Product> findBooks1(LinkedList<Product> products) {
        return products.stream()
                .filter(item -> (item.getType().equals("Book") && item.getPrice() > 250))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    // Method for 2.2
    public static LinkedList<Product> findBooks2(LinkedList<Product> products) {
        return products.stream()
                .filter(item -> (item.getType().equals("Book") && item.getDiscount() == 10))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    //Method for 3.3
    public static void findCheapestBook(LinkedList<Product> products) {
        Optional<Product> cheapestBook = products.stream()
                .filter(item -> item.getType().equals("Book"))
                .min(Comparator.comparingInt(Product::getPrice));
        cheapestBook.ifPresentOrElse(System.out::println, () -> System.out.println("Product Book did not found"));
    }

    // Method for 4.2
    public static void findThreeLatestProducts(LinkedList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found");
        }
        products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    // Method for 5.2
    public static void sumOfCertainProducts(LinkedList<Product> products) {
        Year currentYear = Year.now();
        int totalPrice = products.stream()
                .filter(item -> (item.getType().equals("Book") && item.getPrice() <= 75 && item.getCreationDate().getYear() == currentYear.getValue()))
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println("Total price: " + totalPrice);
    }

}
