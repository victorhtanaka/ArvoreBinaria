package Tree;

import javax.swing.*;
import java.awt.*;

public class BinaryTree<T> extends Tree<T> {
    public BinaryTree() {
        super();
    }
    public BinaryTree(Node<T> root) {
        super(root);
    }

    @Override
    public void insert(T value) {
        if (contains(value)) {
            return;
        }
        Node<T> newNode = new Node<>(value);
        if (getRoot() == null) {
            setRoot(newNode);
            return;
        }
        Node<T> current = getRoot();
        Node<T> parent = null;
        while (true) {
            parent = current;
            if (value.hashCode() < current.getValue().hashCode()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    @Override
    public void remove(T value) {
        if (getRoot() == null || !contains(value)) {
            return;
        }
        Node<T> current = getRoot();
        Node<T> parent = getRoot();
        boolean isLeftChild = false;
        while (current.getValue() != value) {
            parent = current;
            if (value.hashCode() < current.getValue().hashCode()) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return;
            }
        }
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == getRoot()) {
                setRoot(null);
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getRight() == null) {
            if (current == getRoot()) {
                setRoot(current.getLeft());
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == getRoot()) {
                setRoot(current.getRight());
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else {
            Node<T> successor = getSuccessor(current);
            
            if (current == getRoot()) {
                setRoot(successor);
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
    }
    
    private Node<T> getSuccessor(Node<T> node) {
        Node<T> successor = null;
        Node<T> successorParent = null;
        Node<T> current = node.getRight();
        
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        
        if (successor != node.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        
        return successor;
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