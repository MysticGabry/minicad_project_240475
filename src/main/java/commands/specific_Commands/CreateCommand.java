package commands.specific_Commands;

import commands.GenericCommand;
import costants.CostantValues;
import costants.TokenSigns;
import exceptions.UnknownTypeException;
import graphicsViewComponent.GraphicFrame;
import myUtils.MyUtils;
import myUtils.Position;
import type.*;
import type.Image;
import type.Rectangle;
import undo.Memento;
import java.util.List;

public class CreateCommand implements GenericCommand {
    private Memento m = new Memento(GraphicFrame.getInstance().getCenterPanel().getComponents());

    @Override
    public void execute(List<String> tokensList) {
        if (tokensList.size() != 3)
            throw new IllegalArgumentException("The arguments provided are invalid");
        GraphicFrame mainFrame = GraphicFrame.getInstance();
        switch (tokensList.get(0)) {
            case TokenSigns.CIRCLE:
                CostantValues.history.push(m);
                tokensList.remove(0);
                String radiusString = tokensList.get(0).replace("(", "").replace(")", "");
                float radius = Float.parseFloat(radiusString);
                tokensList.remove(0);
                List<String> temp = MyUtils.getValFromToken(tokensList.get(0));
                float circleX = Float.parseFloat(temp.get(0));
                float circleY = Float.parseFloat(temp.get(1));
                Position circleCenter = new Position(circleX, circleY);
                Circle circle = new Circle(radius, circleCenter);
                CirclePanel cp = new CirclePanel(circle);
                mainFrame.addCirclePanel(cp);
                System.out.println("Created circle with ID: " + circle.getId() + " in position: " + circleX + ", " + circleY);
                CostantValues.figuresID.add(circle.getId());
                break;
            case TokenSigns.RECTANGLE:
                CostantValues.history.push(m);
                tokensList.remove(0);
                List<String> whList = MyUtils.getValFromToken(tokensList.get(0));
                float width = Float.parseFloat(whList.get(0));
                float height = Float.parseFloat(whList.get(1));
                tokensList.remove(0);
                List<String> posRecList = MyUtils.getValFromToken(tokensList.get(0));
                float rectX = Float.parseFloat(posRecList.get(0));
                float rectY = Float.parseFloat(posRecList.get(1));
                Position rectCenter = new Position(rectX, rectY);
                Rectangle rectangle = new Rectangle(width, height, rectCenter);
                RectanglePanel rp = new RectanglePanel(rectangle);
                mainFrame.addRectanglePanel(rp);
                System.out.println("Created rectangle with ID: " + rectangle.getId() + " in position: " + rectX + ", " + rectY);
                CostantValues.figuresID.add(rectangle.getId());
                break;
            case TokenSigns.IMG:
                CostantValues.history.push(m);
                tokensList.remove(0);
                String path = tokensList.get(0);
                tokensList.remove(0);
                List<String> posImgList = MyUtils.getValFromToken(tokensList.get(0));
                float imgX = Float.parseFloat(posImgList.get(0));
                float imgY = Float.parseFloat(posImgList.get(1));
                Position imgCenter = new Position(imgX, imgY);
                Image img = new Image(path, imgCenter);
                ImagePanel ip = new ImagePanel(img);
                mainFrame.addImagePanel(ip);
                System.out.println("Created image with ID: " + img.getId() + " in position: " + imgX + ", " + imgY);
                CostantValues.figuresID.add(img.getId());
                break;
            default:
                try {
                    throw new UnknownTypeException(tokensList.get(0));
                } catch (UnknownTypeException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}
