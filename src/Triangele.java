public class Triangele implements AreaCalculator{
    public double base;
    public double height;

    public Triangele(double height, double base) {
        this.height = height;
        this.base = base;
    }


    @Override
    public double calculateArea() {
        return base*height/2;
    }
}
