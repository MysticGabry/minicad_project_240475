package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import myUtils.Group;
import type.*;
import undo.Memento;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RemoveCommand implements GenericCommand {
    private GraphicFrame mainFrame = GraphicFrame.getInstance();
    private JPanel centerPanel = mainFrame.getCenterPanel();
    private Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 1)
            throw new IllegalArgumentException("The arguments provided are invalid");
        if (!CostantValues.figuresID.contains(tokensList.get(0))) throw new IllegalArgumentException("Invalid ID");

        CostantValues.history.push(m);
        if (tokensList.get(0).toLowerCase().contains("group")) removeGroup(tokensList.get(0));
        else removeFromId(tokensList.get(0));
    }

    private void removeFromId(String id) {
        Component[] componentsList = centerPanel.getComponents();
        for (Component component : componentsList) {
            if(component instanceof  RectanglePanel rectanglePanel){
                String removingID = rectanglePanel.getRectangle().getId();
                if (removingID.equals(id)) {
                    centerPanel.remove(rectanglePanel);
                    centerPanel.revalidate();
                    centerPanel.repaint();
                    System.out.println("Deleted " + id);
                    CostantValues.allFiguresList.remove(rectanglePanel.getRectangle());
                    break;
                }
            }
            else if (component instanceof CirclePanel circlePanel) {
                String removingID = circlePanel.getCircle().getId();
                if (removingID.equals(id)) {
                    centerPanel.remove(circlePanel);
                    centerPanel.revalidate();
                    centerPanel.repaint();
                    System.out.println("Deleted " + id);
                    Circle.circlesList.remove(circlePanel.getCircle());
                    CostantValues.allFiguresList.remove(circlePanel.getCircle());
                    break;
                }
            }
            else if(component instanceof ImagePanel imagePanel){
                String removingID = imagePanel.getImage().getId();
                if (removingID.equals(id)) {
                    centerPanel.remove(imagePanel);
                    centerPanel.revalidate();
                    centerPanel.repaint();
                    System.out.println("Deleted " + id);
                    CostantValues.allFiguresList.remove(imagePanel.getImage());
                    break;
                }
            }
        }
    }

    private void removeGroup(String groupName) {
        Group groupToRemove = null;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(groupName)) {
                groupToRemove = g;
                break;
            }
        }
        if (groupToRemove != null) {
            for (String s : groupToRemove.getGroupComponents()) {
                removeFromId(s);
            }
            System.out.println("Removed " + groupName);
            CostantValues.groups.remove(groupToRemove);
        }
    }
}
