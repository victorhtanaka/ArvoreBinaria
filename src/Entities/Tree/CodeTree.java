package Entities.Tree;

import java.util.HashMap;

import Entities.Node.Node;
import Entities.Queue.DynamicQueue;

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
        }
    }

    public void createTree() {
        while (!keysQueue.isEmpty()) {
            T key = (T) keysQueue.retrieve();
            insert(key);
        }
    }

    @Override
    public void insert(T key) {
        Node<T> newNode = new Node<>(key);
        Node<T> current = getRoot();
        Node<T> parent = null;

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
                } else if (current.getLeft().getValue() == null || current.getLeft().getValue().toString() == null) {

                    if (j == morseCode.length() - 1) {
                        current.getLeft().setValue(key);
                    }
                }
                current = current.getLeft();

            } else {
                parent = current;
                if (current.getRight() == null) {
                    if (j == morseCode.length() - 1) {
                        parent.setRight(newNode);
                    } else {
                        current.setRight(new Node<>(null));
                    }
                } else if (current.getRight().getValue() == null || current.getRight().getValue().toString() == null) {

                    if (j == morseCode.length() - 1) {
                        current.getRight().setValue(key);
                    }
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
}
