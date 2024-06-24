package type;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CirclePanel extends JPanel {
    private static List<Circle> circles = new ArrayList<>();
    private Circle circle;

    public CirclePanel(Circle circle) {
        this.circle = circle;
        circles.add(circle);
        int diameter = (int) (2 * circle.getRadius());
        Dimension size = new Dimension(diameter, diameter);
        setPreferredSize(size);
        setSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public static List<Circle> getCircles() {
        return circles;
    }

    public Circle getCircle() {
        return circle;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int diameter = (int) (2 * circle.getRadius());
        int x = 1;
        int y = 1;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, diameter, diameter);
    }
}
