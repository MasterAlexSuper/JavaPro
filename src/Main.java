public class Main {
    public static void main(String[] args) {
        Cat catVasia = new Cat("Vasia cat");
        Dog dogVasia = new Dog("Vasia dog");
        Dog dogCasia = new Dog("Casia dog");
        Dog dogAnton = new Dog("Anton dog");
        System.out.println("Dogs amount: " + Dog.dogCount);
        System.out.println("Cats amount: " + Cat.catCount);
        catVasia.run(120);
        catVasia.run(420);
        dogVasia.run(599);
        catVasia.swim(10);
        dogVasia.swim(10);
        dogAnton.run(20);
        dogCasia.swim(250);
    }
}