package graphicsViewComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MousePosition extends JPanel {
    private static int mouseX = 0;
    private static int mouseY = 0;

    public MousePosition() {
        setPreferredSize(new Dimension(50,50));
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                repaint(); // aggiorna le coordinate del mouse
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Disegna il testo con la posizione del mouse
        g.drawString("Pointing at: (" + mouseX + ", " + mouseY + ")", 10, 20);
    }
}
