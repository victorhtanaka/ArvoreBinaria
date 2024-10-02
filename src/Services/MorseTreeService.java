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

    public HashMap<String, String> generateBinaryMap() {
        HashMap<String, String> binAlphabetical = new HashMap<String, String>() {
            {
                put("A", "01000001");
                put("B", "01000010");
                put("C", "01000011");
                put("D", "01000100");
                put("E", "01000101");
                put("F", "01000110");
                put("G", "01000111");
                put("H", "01001000");
                put("I", "01001001");
                put("J", "01001010");
                put("K", "01001011");
                put("L", "01001100");
                put("M", "01001101");
                put("N", "01001110");
                put("O", "01001111");
                put("P", "01010000");
                put("Q", "01010001");
                put("R", "01010010");
                put("S", "01010011");
                put("T", "01010100");
                put("U", "01010101");
                put("V", "01010110");
                put("W", "01010111");
                put("X", "01011000");
                put("Y", "01011001");
                put("Z", "01011010");
                put("1", "00110001");
                put("2", "00110010");
                put("3", "00110011");
                put("4", "00110100");
                put("5", "00110101");
                put("6", "00110110");
                put("7", "00110111");
                put("8", "00111000");
                put("9", "00111001");
                put("0", "00110000");
            }
        };

        return binAlphabetical;
    }

    public CodeTree<String> getMorseTree() {
        return this.morseTree;
    }
}
