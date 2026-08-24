package refactorings;

public class Circle {

    private final int radius;

    public Circle() {
        radius = 10;
    }

    public void printInfo() {
        System.out.println(diameter());
        System.out.println(area());
    }


    public double area() {
        return Math.PI * radius * radius;
    }

    public double diameter() {
        return 2 * Math.PI * radius;
    }
    
    
}
