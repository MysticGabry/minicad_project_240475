package type;

import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import myUtils.Position;

import java.util.List;
import java.util.ArrayList;

public class Circle {
    public static List<Circle> circlesList = new ArrayList<>();
    private float radius;
    private Position center;
    private String id;
    private static int cnt = 0;

    public Circle(float radius, Position center) {
        this.radius = radius;
        this.center = center;
        this.id = "Circle" + (++cnt);
        circlesList.add(this);
        CostantValues.allFiguresList.add(this);
    }

    public Circle() {
    }

    public float getRadius() {
        return radius;
    }

    public Position getCenter() {
        return center;
    }

    public String getId() {
        return id;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        GraphicFrame.getInstance().getCenterPanel().revalidate();
        GraphicFrame.getInstance().getCenterPanel().repaint();

    }

    public static List<Circle> getCirclesList() {
        return circlesList;
    }

    public double calculateArea() {
        return Math.PI * (getRadius() * getRadius());
    }

    public double calculatePerimeter() {
        return Math.PI * (2*getRadius());
    }
    @Override
    public String toString() {
        return "\n" + "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                ", ID:'" + id + '\'' +
                '}';
    }
}
