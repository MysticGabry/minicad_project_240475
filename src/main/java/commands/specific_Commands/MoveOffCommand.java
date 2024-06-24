package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import myUtils.Group;
import myUtils.MyUtils;
import type.CirclePanel;
import type.ImagePanel;
import type.RectanglePanel;
import undo.Memento;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MoveOffCommand implements GenericCommand {
    private final GraphicFrame mainFrame = GraphicFrame.getInstance();
    private final JPanel centerPanel = mainFrame.getCenterPanel();
    private Memento m=new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 2)
            throw new IllegalArgumentException("The arguments provided are invalid");

        List<String> temp = MyUtils.getValFromToken(tokensList.get(1));
        Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());
        CostantValues.history.push(m);
        float x = Float.parseFloat(temp.get(0));
        float y = Float.parseFloat(temp.get(1));
        moveOffFromId(tokensList.get(0), x, y);
        if (tokensList.get(0).toLowerCase().contains("group")) moveOffGroup(tokensList.get(0), (int) x, (int) y);
        else moveOffFromId(tokensList.get(0), x, y);
    }

    public void moveOffFromId(String id, float x, float y) {
        Component[] componentsList = centerPanel.getComponents();
        for (Component component : componentsList) {
            if (component instanceof CirclePanel circlePanel) {
                String movingId = circlePanel.getCircle().getId();
                if (movingId.equals(id)) {
                    int startX = (int) circlePanel.getCircle().getCenter().getX();
                    int startY = (int) circlePanel.getCircle().getCenter().getY();

                    int castedX = (int) ((x + startX) - circlePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel;
                    int castedY = (int) ((y + startY) - circlePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel;
                    circlePanel.setLocation(castedX, castedY);
                    circlePanel.repaint();
                    break;
                }
            } else if (component instanceof RectanglePanel rectanglePanel) {
                String movID = rectanglePanel.getRectangle().getId();
                if (movID.equals(id)) {
                    int startX = (int) rectanglePanel.getRectangle().getCenter().getX();
                    int startY = (int) rectanglePanel.getRectangle().getCenter().getY();

                    int castedX = (int) ((x + startX) - rectanglePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel;
                    int castedY = (int) ((y + startY) - rectanglePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel;
                    rectanglePanel.setLocation(castedX, castedY);
                    rectanglePanel.repaint();
                    break;
                }
            } else if (component instanceof ImagePanel imagePanel) {
                String movID = imagePanel.getImage().getId();
                if (movID.equals(id)) {
                    int startX = (int) imagePanel.getImage().getCenter().getX();
                    int startY = (int) imagePanel.getImage().getCenter().getY();

                    int castedX = (int) ((x + startX) - imagePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel;
                    int castedY = (int) ((y + startY) - imagePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel;
                    imagePanel.setLocation(castedX, castedY);
                    imagePanel.repaint();
                    break;
                }

            }

        }
    }

    public void moveOffGroup(String gid, int x, int y) {
        Group groupToMove = null;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(gid)) {
                groupToMove = g;
                break;
            }
        }
        if (groupToMove != null) {
            for (String s : groupToMove.getGroupComponents()) {
                moveOffFromId(s, x, y);
            }
            System.out.println("Moved " + gid + " on : " + x + ", " + y);
            CostantValues.groups.remove(groupToMove);
        }
    }
}
