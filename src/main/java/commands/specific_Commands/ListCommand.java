package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import costants.TokenSigns;
import myUtils.Group;
import type.Circle;
import type.Image;
import type.Rectangle;

import java.lang.constant.Constable;
import java.util.List;

public class ListCommand implements GenericCommand {

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() < 2)
            throw new IllegalArgumentException("The command requires at least two arguments: command and type or ID.");
        if (!CostantValues.figuresID.contains(tokensList.get(1)) && !tokensList.get(1).equals(TokenSigns.ALL) &&
                !tokensList.get(1).equals("circles") && !tokensList.get(1).equals("rectangles") &&
                !tokensList.get(1).equals("images") && !tokensList.get(1).toLowerCase().contains("group"))
            throw new IllegalArgumentException("Invalid ID");
        tokensList.remove(0);
        String typeOrId = tokensList.get(0);
        if(typeOrId.toLowerCase().contains("group")) listGroup(typeOrId);
        else if (typeOrId.equals("circles") || typeOrId.equals("rectangles") ||
                typeOrId.equals("images") || typeOrId.equals(TokenSigns.ALL)) {
            listByType(typeOrId);
        } else {
            listById(typeOrId);
        }
    }

    private void listByType(String type) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (type.equals("circles")) {
            for (Circle c : Circle.getCirclesList()) {
                sb.append(c).append(", ");
            }
        } else if (type.equals("rectangles")) {
            for (Rectangle r : Rectangle.getRectanglesList()) {
                sb.append(r).append(", ");
            }
        } else if (type.equals("images")) {
            for (Image img : Image.getImagesList()) {
                sb.append(img).append(", ");
            }
        } else if (type.equals(TokenSigns.ALL)) {
            for (Object o : CostantValues.allFiguresList) {
                sb.append(o).append(", ");
            }
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("\n]");
        System.out.println(sb);
    }

    private void listById(String id) {
        for (Object o : CostantValues.allFiguresList) {
            if (o instanceof Circle c && c.getId().equals(id)) {
                System.out.println(c);
                return;
            } else if (o instanceof Rectangle r && r.getId().equals(id)) {
                System.out.println(r);
                return;
            } else if (o instanceof Image img && img.getId().equals(id)) {
                System.out.println(img);
                return;
            }
        }System.out.println("No figure found with ID: " + id);
    }

    private void listGroup(String gid) {
        for (Group g : CostantValues.groups) {
            if (gid.equals(g.getGid())){
                for(Object o:g){
                    listById(o.toString());
                }
            }
        }
    }
}
