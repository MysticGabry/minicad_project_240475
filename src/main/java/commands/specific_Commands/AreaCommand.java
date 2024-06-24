package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import costants.TokenSigns;
import myUtils.Group;
import type.Circle;
import type.Rectangle;

import java.util.List;

public class AreaCommand implements GenericCommand {

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 1) throw new IllegalArgumentException("The arguments provided are invalid");
        if (!CostantValues.figuresID.contains(tokensList.get(0))) throw new IllegalArgumentException("Invalid ID");
        if (tokensList.get(0).toLowerCase().equals("circles")) {
            System.out.println("Area of Circles = " + calculateCirclesArea());
        } else if (tokensList.get(0).toLowerCase().equals("rectangles")) {
            System.out.println("Area of Rectangles = " + calculateRectanglesArea());
        } else if (tokensList.get(0).toLowerCase().equals("images")) {
            throw new IllegalArgumentException("Can't calculate the area of an image");
        } else if (tokensList.get(0).contains("Group")) {
            System.out.println("Area of " + tokensList.get(0) + " = " + calculateGroupArea(tokensList.get(0)));
        } else if (tokensList.get(0).toLowerCase().contains(TokenSigns.ALL)) {
            System.out.println("Total area of the figures = " + calculateTotalArea());
        } else {
            System.out.println("Area of " + tokensList.get(0) + " = " + calculateAreaFromId(tokensList.get(0)));
        }
    }

    private double calculateCirclesArea() {
        double area = 0;
        for (Circle c : Circle.getCirclesList()) {
            area += c.calculateArea();
        }
        return area;
    }

    private double calculateRectanglesArea() {
        double area = 0;
        for (Rectangle r : Rectangle.getRectanglesList()) {
            area += r.calculateArea();
        }
        return area;
    }

    private double calculateGroupArea(String gid) {
        double area = 0;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(gid)) {
                for (String typeId : g) {
                    for (Object o : CostantValues.allFiguresList) {
                        if (o instanceof Circle c) {
                            if (c.getId().equals(typeId)) area += c.calculateArea();
                        } else if (o instanceof Rectangle r) {
                            if (r.getId().equals(typeId)) area += r.calculateArea();
                        }
                    }
                }
            }
        }
        return area;
    }

    private double calculateTotalArea() {
        double area = 0;
        for (Circle c : Circle.getCirclesList()) {
            area += c.calculateArea();
        }
        for (Rectangle r : Rectangle.getRectanglesList()) {
            area += r.calculateArea();
        }
        return area;
    }

    private double calculateAreaFromId(String id) {
        for (Object o : CostantValues.allFiguresList) {
            if (o instanceof Circle c) {
                if (c.getId().equals(id)) {
                    return c.calculateArea();
                }
            } else if (o instanceof Rectangle r) {
                if (r.getId().equals(id)) {
                    return r.calculateArea();
                }
            }
        }
        return -1;
    }
}