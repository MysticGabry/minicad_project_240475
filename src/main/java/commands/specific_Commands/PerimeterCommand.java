package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import costants.TokenSigns;
import myUtils.Group;
import type.Circle;
import type.Rectangle;

import java.util.List;

public class PerimeterCommand implements GenericCommand {
    @Override
    public void execute(List<String> tokensList) {

        if (tokensList.size() != 1)throw new IllegalArgumentException("The arguments provided are invalid");
        if (!CostantValues.figuresID.contains(tokensList.get(0))) throw new IllegalArgumentException("Invalid ID");
        if (tokensList.get(0).toLowerCase().equals("circles")) {
            System.out.println("Perimeter of Circles = " + calculateCirclesPerimeter());
        } else if (tokensList.get(0).toLowerCase().equals("rectangles")) {
            System.out.println("Perimeter of Rectangles = " + calculateRectanglesPerimeter());
        } else if (tokensList.get(0).toLowerCase().equals("images")) {
            throw new IllegalArgumentException("Can't calculate the perimeter of an image");
        } else if (tokensList.get(0).contains("Group")) {
            System.out.println("Perimeter of " + tokensList.get(0) + " = " + calculateGroupPerimeter(tokensList.get(0)));
        } else if (tokensList.get(0).toLowerCase().equals(TokenSigns.ALL)) {
            System.out.println("Total perimeter of the figures = " + calculateTotalPerimeter());
        } else {
            System.out.println("Perimeter of " + tokensList.get(0) + " = " + calculatePerimeterFromId(tokensList.get(0)));
        }
    }

    private double calculateCirclesPerimeter() {
        double perimeter = 0;
        for (Circle c : Circle.getCirclesList()) {
            perimeter += c.calculatePerimeter();
        }
        return perimeter;
    }

    private double calculateRectanglesPerimeter() {
        double perimeter = 0;
        for (Rectangle r : Rectangle.rectanglesList) {
            perimeter += r.calculatePerimeter();
        }
        return perimeter;
    }

    private double calculateGroupPerimeter(String gid) {
        double perimeter = 0;
        for (Group g : CostantValues.groups) {
            if (g.getGid().equals(gid)) {
                for (String typeId : g) {
                    for (Object o : CostantValues.allFiguresList) {
                        if (o instanceof Circle c) {
                            if (c.getId().equals(typeId)) perimeter += c.calculatePerimeter();
                        } else if (o instanceof Rectangle r) {
                            if (r.getId().equals(typeId)) perimeter += r.calculatePerimeter();
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    private double calculateTotalPerimeter() {
        double perimeter = 0;
        for (Circle c : Circle.getCirclesList()) {
            perimeter += c.calculatePerimeter();
        }
        for(Rectangle r : Rectangle.rectanglesList) {
            perimeter += r.calculatePerimeter();
        }
        return perimeter;
    }

    private double calculatePerimeterFromId(String id) {
        for (Object o : CostantValues.allFiguresList) {
            if (o instanceof Circle c) {
                if (c.getId().equals(id)) {
                    return c.calculatePerimeter();
                }
            } else if (o instanceof Rectangle r) {
                if (r.getId().equals(id)) {
                    return r.calculatePerimeter();
                }
            }
        }
        return -1;
    }
}