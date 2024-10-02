package Services;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

import Entities.Node.Node;
import Entities.Tree.CodeTree;

public class ViewTreeService {
    public ViewTreeService() {}
    public void showTreeInPanel(JFrame frame, CodeTree<String> morseTree) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, morseTree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
            }
        };
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void drawTree(Graphics g, Node<String> node, int x, int y, int xOffset) {
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
