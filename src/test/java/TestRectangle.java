import myUtils.Position;
import org.junit.jupiter.api.Test;
import type.Rectangle;
import type.RectanglePanel;

public class TestRectangle {

    @Test
    public void testArea() {
        Rectangle r1 = new Rectangle(10, 10, new Position(0, 0));
        Rectangle r2 = new Rectangle(20, 20, new Position(0, 0));
        assert r1.calculateArea() < r2.calculateArea();
    }

    @Test
    public void testPerimeter() {
        Rectangle r1 = new Rectangle(10, 10, new Position(0, 0));
        Rectangle r2 = new Rectangle(20, 20, new Position(0, 0));
        assert r1.calculatePerimeter() < r2.calculatePerimeter();
    }

    @Test
    public void testRectanglesList() {
        assert RectanglePanel.getRectangles().isEmpty();
        Rectangle r1 = new Rectangle(10, 20, new Position(0, 0));
        assert !Rectangle.getRectanglesList().isEmpty();
    }

}
