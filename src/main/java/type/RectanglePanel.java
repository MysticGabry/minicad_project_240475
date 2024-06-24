package type;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RectanglePanel extends JPanel {
    private static List<Rectangle> rectangles = new ArrayList<>();
    private Rectangle rectangle;

    public RectanglePanel(Rectangle rectangle) {
        this.rectangle = rectangle;
        rectangles.add(rectangle);
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public static List<Rectangle> getRectangles() {
        return rectangles;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 1;
        int y = 1;
        int width = (int) rectangle.getWidth();
        int height = (int) rectangle.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);
    }
}
