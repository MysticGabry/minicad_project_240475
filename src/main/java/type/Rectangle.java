package type;

import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import myUtils.Position;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    public static List<Rectangle> rectanglesList = new ArrayList<>();
    private float height;
    private float width;
    private Position center;
    private String id;
    private static int cnt = 0;

    public Rectangle(float width, float height, Position center) {
        this.width = width;
        this.height = height;
        this.center = center;
        this.id = "Rectangle" + (++cnt);
        rectanglesList.add(this);
        CostantValues.allFiguresList.add(this);
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Position getCenter() {
        return center;
    }

    public String getId() {
        return id;
    }

    public static List<Rectangle> getRectanglesList() {
        return rectanglesList;
    }

    public void setScale(Float scale) {
        width += scale;
        height += scale;
        GraphicFrame.getInstance().getCenterPanel().revalidate();
        GraphicFrame.getInstance().getCenterPanel().repaint();
    }

    public double calculateArea() {
        return width * height;
    }

    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "\n" + "Rectangle{" +
                "Height=" + height +
                ", Width=" + width +
                ", center=" + center +
                ", ID:'" + id + '\'' +
                '}';
    }
}
