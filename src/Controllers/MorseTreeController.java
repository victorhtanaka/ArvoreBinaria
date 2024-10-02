package Controllers;
import java.util.HashMap;

import javax.swing.JFrame;

import Services.MorseTreeService;
import Services.ViewTreeService;

public class MorseTreeController {
    
    private MorseTreeService morseTreeService;
    private ViewTreeService viewTreeService;

    public MorseTreeController() {
        this.morseTreeService = new MorseTreeService();
        this.viewTreeService = new ViewTreeService();
    }

    public String decodeWord(String morseCode) {
        try {

            return morseTreeService.decodeWord(morseCode);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void createTree() {
        try {

            morseTreeService.createTree();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewTree() {

        viewTreeService.showTreeInPanel(new JFrame(), morseTreeService.getMorseTree());

    }

    public HashMap<String, String> generateMorseMap() {
        try {

            return morseTreeService.generateCodeMap();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
