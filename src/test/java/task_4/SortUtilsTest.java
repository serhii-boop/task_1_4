package task_4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortUtilsTest {

    private static int RADIUS = 3;
    private static int SIDE = 3;
    private static int BASE = 2;
    private static int HEIGHT = 4;
    private static int WIDTH = 5;

    private static double CIRCLE_AREA = RADIUS * Math.PI;
    private static int SQUARE_AREA = SIDE * SIDE;
    private static double TRIANGLE_AREA = BASE * (double) HEIGHT / 2;
    private static int RECTANGLE_AREA = WIDTH * HEIGHT;

    @Test
    void checkIfCorrectSolvedArea() {
        Shape circle = new Circle(RADIUS);
        Shape square = new Square(SIDE);
        Shape triangle = new Triangle(BASE, HEIGHT);
        Shape rectangle = new Rectangle(WIDTH, HEIGHT);

        assertEquals(circle.area(), CIRCLE_AREA);
        assertEquals(square.area(), SQUARE_AREA);
        assertEquals(triangle.area(), TRIANGLE_AREA);
        assertEquals(rectangle.area(), RECTANGLE_AREA);
    }

    @Test
    void checkIfCorrectSorting() {
        Shape circle = new Circle(RADIUS);
        Shape square = new Square(SIDE);
        Shape triangle = new Triangle(BASE, HEIGHT);
        Shape rectangle = new Rectangle(WIDTH, HEIGHT);

        List<Shape> shapeList = new ArrayList<>();
        List<Shape> sortedShapeList = new ArrayList<>();

        shapeList.add(circle);
        shapeList.add(square);
        shapeList.add(triangle);
        shapeList.add(rectangle);

        sortedShapeList.add(circle);
        sortedShapeList.add(square);
        sortedShapeList.add(triangle);
        sortedShapeList.add(rectangle);

        SortUtils.sortShapesByArea(shapeList);
        sortedShapeList.sort(Comparator.comparing(Shape::area));

        assertEquals(sortedShapeList, shapeList);
    }

}