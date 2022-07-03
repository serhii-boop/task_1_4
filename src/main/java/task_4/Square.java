package task_4;

public class Square extends Shape{

    public Square(int side) {
        this.side = side;
    }

    @Override
    Double area() {
        return (double) (side * side);
    }
}
