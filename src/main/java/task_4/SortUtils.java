package task_4;

import java.util.Comparator;
import java.util.List;

public class SortUtils {

    static List<Shape> sortShapesByArea(List<Shape> shapeList) {
        shapeList.sort(Comparator.comparingDouble(Shape::area));
        return shapeList;
    }
}
