package Tree;

import java.awt.*;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Queue.DynamicQueue;

public class CodeTree<T> extends Tree<T>  {
    private HashMap<String, String> morseMap;
    private char[] chars;
    private DynamicQueue<String> keysQueue = new DynamicQueue<>(10);

    public CodeTree(HashMap<String, String> morseMap, char[] chars, T rootValue) {
        super(new Node<T>(rootValue));
        this.morseMap = morseMap;
        this.chars = chars;
    }

    public void addCharsToStack() {
        for (String key : morseMap.keySet()) {
            keysQueue.store(key);
            System.out.println("Adicionando: " + key);
        }
    }

    public void createTree() {
        while (!keysQueue.isEmpty()) {
            T key = (T) keysQueue.retrieve();
            insert(key);
        }

        showTreeInPanel(new JFrame());
    }

    @Override
    public void insert(T key) {
        System.out.println("Inserindo: " + key);
        Node<T> newNode = new Node<>(key);
        Node<T> current = getRoot();
        Node<T> parent = null;
        String lr = null;

        String morseCode = morseMap.get(key);
        for (int j = 0; j < morseCode.length(); j++) {
            if (morseCode.charAt(j) == chars[0]) {
                parent = current;
                if (current.getLeft() == null) {
                    if (j == morseCode.length() - 1) {
                        parent.setLeft(newNode);
                    } else {
                        current.setLeft(new Node<>(null));
                    }
                }
                current = current.getLeft();
                lr = "0";
            } else {
                parent = current;
                if (current.getRight() == null) {
                    if (j == morseCode.length() - 1) {
                        parent.setRight(newNode);
                    } else {
                        current.setRight(new Node<>(null));
                    }
                }
                current = current.getRight();
                lr = "1";
            }
        }
        if (lr == "0" && lr != null) {
            parent.setLeft(newNode);
        } else if (lr == "1" && lr != null) {
            parent.setRight(newNode);
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
            if (node.getValue() != null) {
                g.drawString(node.getValue().toString(), x - 5, y + 5);
            }
            
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
