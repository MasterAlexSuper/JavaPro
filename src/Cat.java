public class Cat extends Animal {
    public static int catCount = 0;
    public Cat(String name) {
                super(name, 200, 0);
                catCount++;
    }
}
