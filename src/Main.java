public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        System.out.println("Area of circle is " + circle.calculateArea());
        Triangele triangele = new Triangele(10, 10);
        System.out.println("Area of Triangle is " + triangele.calculateArea());
        Square square = new Square(5);
        System.out.println("Area of Square is " + square.calculateArea());
        AreaCalculator[] figures = {circle, triangele, square};
        System.out.println("Sum of figures is " + getAreaSum(figures));


        Participant[] participants = {new Robot("Robot", 1000, 10), new Cat("Cat", 20, 0.8f), new Human("Human", 150, 1.2f)};
        Obstacle[] obstacles = {new Wall(0.5f), new Treadmill(40), new Treadmill(300), new Wall(10)};
        getOverObstacles(participants, obstacles);
    }

    public static double getAreaSum(AreaCalculator[] figures) {
        double sum = 0;
        for (AreaCalculator figure : figures) {
            sum += figure.calculateArea();
        }
        return sum;
    }

    public static void getOverObstacles(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                boolean next = obstacle.overcome(participant);
                if (!next) {
                    System.out.println(participant.name + " is out.");
                    break;
                }
            }
        }
    }
}