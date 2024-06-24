import myUtils.Position;
import org.junit.jupiter.api.Test;
import type.Circle;
import type.CirclePanel;

public class TestCircle {

    @Test
    public void testArea() {
        Circle c1 = new Circle(10, new Position(0, 0));
        Circle c2 = new Circle(20, new Position(0, 0));
        assert c2.calculateArea() == 4 * c1.calculateArea();
        c2.setRadius(10);
        assert c1.calculateArea() == c2.calculateArea() : "Different area";
    }

    @Test
    public void testPerimeter() {
        Circle c1 = new Circle(10, new Position(0, 0));
        Circle c2 = new Circle(20, new Position(0, 0));
        assert c1.calculatePerimeter() < c2.calculatePerimeter();
        c2.setRadius(10);
        assert c1.calculatePerimeter() == c2.calculatePerimeter() : "Different perimeter";
    }

    @Test
    public void testCirclesList() {
        assert CirclePanel.getCircles().isEmpty();
        Circle c1 = new Circle(10, new Position(0, 0));
        CirclePanel cp=new CirclePanel(c1);
        assert !CirclePanel.getCircles().isEmpty();
    }

    @Test
    public void testCirclePanel() {
        assert CirclePanel.getCircles().isEmpty();
        Circle c = new Circle(10, new Position(0, 0));
        CirclePanel cp=new CirclePanel(c);
        assert CirclePanel.getCircles().size()==1;
    }

}
