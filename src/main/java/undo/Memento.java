package undo;

import costants.CostantValues;
import graphicsViewComponent.GraphicFrame;
import graphicsViewComponent.PromptPanel;
import type.Circle;
import java.awt.*;

public class Memento { // Memento
    private final Component[] components;

    public Memento(Component[] components) {
        this.components = components;
        PromptPanel.setStatusButtonEnabled(true);
    }


    public Component[] getComponents() {
        return components;
    }

    public void restore() {
        GraphicFrame.getInstance().restoreComponents2(components);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        if (CostantValues.allFiguresList.isEmpty()) return "Memento{ }";
        else {
            sb.append("Memento{ ");
            for (Object o : CostantValues.allFiguresList) {
                if (o instanceof Circle) {
                    sb.append(o.getClass().getSimpleName());
                    sb.append(", ");
                } else if (o instanceof Rectangle) {
                    sb.append(o.getClass().getSimpleName());
                    sb.append(", ");
                } else if (o instanceof Image) {
                    sb.append(o.getClass().getSimpleName());
                    sb.append(", ");
                }
            }
            sb.setLength(sb.length() - 2);
            sb.append(" }");
        }
        return sb.toString();
    }
}
