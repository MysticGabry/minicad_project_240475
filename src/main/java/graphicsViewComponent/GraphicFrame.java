package graphicsViewComponent;

import costants.CostantValues;
import type.CirclePanel;
import type.ImagePanel;
import type.RectanglePanel;
import verifiers.Verifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GraphicFrame extends JFrame {
    private static GraphicFrame instance = null;
    private PromptPanel promptPanel = new PromptPanel();
    private JPanel centerPanel = new JPanel(new BorderLayout());
    private ActionListener closingOrExeAL = a -> {
        String line = promptPanel.prompt.getText();
        if (line.equalsIgnoreCase("stop") || line.equalsIgnoreCase("break")) {
            dispose();
        }
        Verifier verifier = new Verifier(line);
        verifier.checkAndExecute();

        promptPanel.prompt.setText(null);
    };

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    private GraphicFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MiniCad");
        setPreferredSize(new Dimension(CostantValues.frameWidth, CostantValues.frameHeight));
        setLayout(new BorderLayout());
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        promptPanel.prompt.addActionListener(closingOrExeAL);
        setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(promptPanel, BorderLayout.SOUTH);
        centerPanel.setLayout(null);
        add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static GraphicFrame getInstance() {
        if (instance == null) {
            instance = new GraphicFrame();
        }
        return instance;
    }

    public void addCirclePanel(CirclePanel cp) {
        int x = (int) cp.getCircle().getCenter().getX();
        int y = (int) cp.getCircle().getCenter().getY();
        int diameter = (int) cp.getCircle().getRadius() * 2;
        cp.setBounds(x - cp.getWidth() / 2, y - cp.getHeight() / 2,
                diameter + CostantValues.consentedDeltaMaxBounds, diameter + CostantValues.consentedDeltaMaxBounds);
        cp.setOpaque(false);
        centerPanel.add(cp);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void addRectanglePanel(RectanglePanel rp) {
        int x = (int) rp.getRectangle().getCenter().getX();
        int y = (int) rp.getRectangle().getCenter().getY();
        int rWidth = (int) rp.getRectangle().getWidth();
        int rHeight = (int) rp.getRectangle().getHeight();
        rp.setBounds(x - rp.getWidth() / 2, y - rp.getHeight() / 2,
                rWidth + CostantValues.consentedDeltaMaxBounds, rHeight + CostantValues.consentedDeltaMaxBounds);
        rp.setOpaque(false);
        centerPanel.add(rp);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void addImagePanel(ImagePanel ip) {
        int x = (int) ip.getImage().getCenter().getX();
        int y = (int) ip.getImage().getCenter().getY();
        int width = (int) ip.getPreferredSize().getWidth();
        int height = (int) ip.getPreferredSize().getHeight();
        int finX = (int) (x - ip.getPreferredSize().getWidth() / 2);
        int finY = (int) (y - ip.getPreferredSize().getHeight() / 2);
        ip.setBounds(finX, finY,
                width + CostantValues.consentedDeltaMaxBounds, height + CostantValues.consentedDeltaMaxBounds);
        ip.setOpaque(false);
        centerPanel.add(ip);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void restoreComponents(Component[] components) {
        centerPanel.removeAll();
        for (Component c : components) {
            centerPanel.add(c);
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }
    public void restoreComponents2(Component[] components){
        centerPanel.removeAll();
        for (Component c : components) {
            if(c instanceof ImagePanel imagePanel){
                addImagePanel(imagePanel);
            }else if(c instanceof RectanglePanel rectanglePanel){
                addRectanglePanel(rectanglePanel);
            }
            else if(c instanceof CirclePanel circlePanel){
                addCirclePanel(circlePanel);
            }
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }
}
