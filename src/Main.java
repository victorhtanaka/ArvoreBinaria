import java.util.HashMap;

import javax.swing.JFrame;

import Tree.BinaryTree;
import Tree.MorseTree;
import Tree.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> morseAlphabetical = new HashMap<String, String>() {
            {
                put("A", ".-");
                put("B", "-...");
                put("C", "-.-.");
                put("D", "-..");
                put("E", ".");
                put("F", "..-.");
                put("G", "--.");
                put("H", "....");
                put("I", "..");
                put("J", ".---");
                put("K", "-.-");
                put("L", ".-..");
                put("M", "--");
                put("N", "-.");
                put("O", "---");
                put("P", ".--.");
                put("Q", "--.-");
                put("R", ".-.");
                put("S", "...");
                put("T", "-");
                put("U", "..-");
                put("V", "...-");
                put("W", ".--");
                put("X", "-..-");
                put("Y", "-.--");
                put("Z", "--..");
                put("1", ".----");
                put("2", "..---");
                put("3", "...--");
                put("4", "....-");
                put("5", ".....");
                put("6", "-....");
                put("7", "--...");
                put("8", "---..");
                put("9", "----.");
                put("0", "-----");
            }
        };
        MorseTree<String> morseTree = new MorseTree<String>(new Node<String>(""), morseAlphabetical);
        morseTree.createTree();
    }
}
