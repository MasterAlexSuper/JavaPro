public class Square implements  AreaCalculator{
    double side;

    Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side*side;
    }
}
