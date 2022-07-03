package task_4;

public class Triangle extends Shape {


    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    Double area() {
        return (double) base * (double) height / 2;
    }
}
