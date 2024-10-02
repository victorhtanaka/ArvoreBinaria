package Services;
import java.util.HashMap;

import Entities.Node.Node;
import Entities.Tree.CodeTree;

public class MorseTreeService {
    private CodeTree<String> morseTree;
    private char[] chars = new char[] {'.', '-'};

    public MorseTreeService() {
        morseTree = new CodeTree<String>(generateCodeMap(), chars, ".-");
    }

    public String decodeWord(String morseCode) {
        Node<String> current = this.morseTree.getRoot();
        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == chars[0]) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current.getValue();
    }

    public void createTree() {
        this.morseTree.addCharsToStack();
        this.morseTree.createTree();
    }

    public HashMap<String, String> generateCodeMap() {
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

        return morseAlphabetical;
    }

    public CodeTree<String> getMorseTree() {
        return this.morseTree;
    }
}
