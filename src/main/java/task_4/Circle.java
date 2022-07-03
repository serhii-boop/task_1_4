package task_4;

public class Circle extends Shape {
    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    Double area() {
        return radius * Math.PI;
    }
}
