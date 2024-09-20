package Tree;

import java.awt.*;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MorseTree<T> extends Tree<T>  {
    private HashMap<String, String> morseMap;

    public MorseTree(Node<T> root, HashMap<String, String> morseMap) {
        super(root);
        this.morseMap = morseMap;
    }

    public void createTree() {
        for (String key : morseMap.keySet()) {
            insert((T) key);
        }
        showTreeInPanel(new JFrame());
    }

    @Override
    public void insert(T key) {
        Node<T> newNode = new Node<>(key);
        Node<T> current = getRoot();
        Node<T> parent = null;

        while (true) {
            if (morseMap.get(key.toString()).charAt(0) == '.') {
                if (current.getLeft() == null) {
                    current.setLeft(newNode);
                    return;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    current.setRight(newNode);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    @Override
    public void remove(T value) {
        
    }

    @Override
    public boolean contains(T value) {
        if (getRoot().getValue() == value) {
            return true;
        }
        Node<T> current = getRoot();
        while (current.getValue() != value) {
            if (value.hashCode() < current.getValue().hashCode()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public void showTreeInPanel(JFrame frame) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, getRoot(), getWidth() / 2, 30, getWidth() / 4);
            }
        };
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void drawTree(Graphics g, Node<T> node, int x, int y, int xOffset) {
        if (node != null) {
            g.setColor(Color.BLACK);
            g.fillOval(x - 10, y - 10, 20, 20);
            g.setColor(Color.WHITE);
            g.drawString(node.getValue().toString(), x - 5, y + 5);
            
            if (node.getLeft() != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x - xOffset, y + 50);
                drawTree(g, node.getLeft(), x - xOffset, y + 50, xOffset / 2);
            }
            
            if (node.getRight() != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x + xOffset, y + 50);
                drawTree(g, node.getRight(), x + xOffset, y + 50, xOffset / 2);
            }
        }
    }
}
