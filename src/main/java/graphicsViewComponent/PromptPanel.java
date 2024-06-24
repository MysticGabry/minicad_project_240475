package graphicsViewComponent;

import costants.CostantValues;
import undo.History;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PromptPanel extends JPanel {
    public JTextField prompt = new JTextField();
    private History history = CostantValues.history;
    private static JButton button = new JButton("UNDO");
    private ActionListener undoAL = a -> {
        history.reloadLast();
    };

    public PromptPanel() {

        setLayout(new FlowLayout());
        prompt.setPreferredSize(new Dimension(650, 30));
        prompt.setBackground(Color.LIGHT_GRAY);
        add(prompt, BorderLayout.CENTER);
        button.setEnabled(false);
        button.addActionListener(undoAL);
        add(button, BorderLayout.SOUTH);
    }
    public static void setStatusButtonEnabled(boolean status) {
        button.setEnabled(status);
    }
}
