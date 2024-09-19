import javax.swing.JFrame;

import Tree.BinaryTree;
import Tree.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(new Node<Integer>(5));
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.showTreeInPanel(new JFrame());
    }
}
