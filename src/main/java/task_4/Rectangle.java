package task_4;

public class Rectangle extends Shape {

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    Double area() {
        return (double) (width * height);
    }
}
