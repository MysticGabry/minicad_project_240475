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

public class MoveCommand implements GenericCommand {
    private final GraphicFrame mainFrame = GraphicFrame.getInstance();
    private final JPanel centerPanel = mainFrame.getCenterPanel();
    private Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 2)
            throw new IllegalArgumentException("The arguments provided are invalid");
        if (!CostantValues.figuresID.contains(tokensList.get(0))) throw new IllegalArgumentException("Invalid ID");
        CostantValues.history.push(m);
        List<String> temp = MyUtils.getValFromToken(tokensList.get(1));
        Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());
        CostantValues.history.push(m);
        float x = Float.parseFloat(temp.get(0));
        float y = Float.parseFloat(temp.get(1));
        moveFromId(tokensList.get(0), x, y);
        if (tokensList.get(0).toLowerCase().contains("group")) moveGroup(tokensList.get(0), (int) x, (int) y);
        else moveFromId(tokensList.get(0), x, y);
    }

    private void moveFromId(String id, float x, float y) {
        Component[] componentsList = centerPanel.getComponents();
        for (Component component : componentsList) {
            if (component instanceof CirclePanel circlePanel) {
                String movingId = circlePanel.getCircle().getId();
                if (movingId.equals(id)) {
                    int castedX = (int) ((x - circlePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel);
                    int castedY = (int) ((y - circlePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel);
                    circlePanel.setLocation(castedX, castedY);
                    circlePanel.repaint();
                    break;
                }
            } else if (component instanceof RectanglePanel rectanglePanel) {
                String movID = rectanglePanel.getRectangle().getId();
                if (movID.equals(id)) {
                    int castedX = (int) ((x - rectanglePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel);
                    int castedY = (int) ((y - rectanglePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel);
                    rectanglePanel.setLocation(castedX, castedY);
                    rectanglePanel.repaint();
                    break;
                }
            } else if (component instanceof ImagePanel imagePanel) {
                String movID = imagePanel.getImage().getId();
                if (movID.equals(id)) {
                    int castedX = (int) ((x - imagePanel.getWidth() / 2) + CostantValues.deltaMaxforScalingPanel);
                    int castedY = (int) ((y - imagePanel.getHeight() / 2) + CostantValues.deltaMaxforScalingPanel);
                    imagePanel.setLocation(castedX, castedY);
                    imagePanel.repaint();
                    break;
                }
            }
        }
    }

    private void moveGroup(String gid, int x, int y) {
        Group groupToMove = null;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(gid)) {
                groupToMove = g;
                break;
            }
        }
        if (groupToMove != null) {
            for (String s : groupToMove.getGroupComponents()) {
                moveFromId(s, x, y);
            }
            System.out.println("Moved " + gid + " on : " + x + ", " + y);
            CostantValues.groups.remove(groupToMove);
        }
    }
}
