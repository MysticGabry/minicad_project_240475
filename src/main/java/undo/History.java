package undo;

import java.util.Stack;

public class History { // CareTaker
    private Stack<Memento> history = new Stack<>();


    public Stack<Memento> getHistory() {
        return history;
    }


    public void push(Memento m) {
        history.push(m);
    }

    public void reloadLast() {
        if (!history.isEmpty()) {
            Memento memento = history.pop();
            memento.restore();
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
