package undo;

import costants.CostantValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class History { // CareTaker
    private Stack<Memento> history = new Stack<>();
    private List<Object> figuresListBackup = new ArrayList<>();
    private List<String> figuresIdBackup = new ArrayList<>();

    public Stack<Memento> getHistory() {
        return history;
    }


    public void push(Memento m) {
        history.push(m);
        System.out.println("pushed");
    }

    public void reloadLast() {
        if (!history.isEmpty()) {
            Memento memento = history.pop();

            memento.restore();
            System.out.println(this);
        } else {
            System.out.println("History is empty");
        }
    }

    public int getSize() {
        return history.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        for (Memento m : history) {
            sb.append(m + "\n");
        }
        return sb.toString();
    }
}
