package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import myUtils.Group;
import type.Circle;
import type.Image;
import type.Rectangle;
import undo.Memento;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScaleCommand implements GenericCommand {
    Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 2) throw new IllegalArgumentException("The arguments provided are invalid");
        if (!CostantValues.figuresID.contains(tokensList.get(0))) throw new IllegalArgumentException("Invalid ID");
        CostantValues.history.push(m);
        if (tokensList.get(0).toLowerCase().contains("group"))
            scaleGroup(tokensList.get(0), Float.parseFloat(tokensList.get(1)));
        else
            scaleFromId(tokensList.get(0), Float.parseFloat(tokensList.get(1)));
    }

    private void scaleFromId(String id, float val) {
        for (Object o : CostantValues.allFiguresList) {
            if (o instanceof Circle c) {
                if (c.getId().equals(id)) {
                    c.setRadius(val);
                    System.out.println("Scaled " + id + " to " + val);
                    break;
                }
            } else if (o instanceof Rectangle r) {
                if (r.getId().equals(id)) {
                    r.setScale(val);
                    System.out.println("Scaled " + id + " to " + val);
                    break;
                }
            } else if (o instanceof Image img) {
                if (img.getId().equals(id)) {
                    String path = img.getPath();
                    try {
                        BufferedImage bi = ImageIO.read(new File(path));
                        int newWidth = bi.getWidth() * (int) val;
                        int newHeight = bi.getHeight() * (int) val;
                        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g2d = newImage.createGraphics();
                        g2d.drawImage(newImage, (int) img.getCenter().getX(), (int) img.getCenter().getY(), null);
                        g2d.dispose();
                        GraphicFrame.getInstance().getCenterPanel().revalidate();
                        GraphicFrame.getInstance().getCenterPanel().repaint();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void scaleGroup(String id, float val) {
        Group groupToRemove = null;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(id)) {
                groupToRemove = g;
                break;
            }
        }
        if (groupToRemove != null) {
            for (String s : groupToRemove.getGroupComponents()) {
                scaleFromId(s, val);
            }
            CostantValues.groups.remove(groupToRemove);
        }
        System.out.println("Scaled " + id + " to " + val);
    }
}
