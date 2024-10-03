import java.util.Scanner;

import Controllers.MorseTreeController;

public class Main {
    public static void main(String[] args) throws Exception {
        MorseTreeController morseTreeController = new MorseTreeController();

        boolean menu = true;
        Scanner scanner = new Scanner(System.in);

        while (menu) {
            System.out.println(
                "Selecione a funcionalidade desejada:\n" +
                "1. Popular árvore\n" +
                "2. Ver árvore\n" +
                "3. Decodificar palavra\n" +
                "4. Sair"
            );
            
            int function = scanner.nextInt();

            switch (function) {
                case 1:
                    morseTreeController.createTree();
                    System.out.println("Árvore populada com sucesso");
                    break;

                case 2:
                    morseTreeController.viewTree();
                    break;

                case 3:
                    System.out.println("Digite a palavra em código morse (separado por /): ");
                    String morseWord = scanner.next();
                    String[] letters = morseWord.split("/");
                    String decodedWord = "";
                    for(int i = 0; i < letters.length; i++) {
                        decodedWord += morseTreeController.decodeWord(letters[i]);
                        
                    }
                    if (decodedWord == "") {
                        System.out.println("Código inválido");
                    } else {
                        System.out.println("Palavra decodificada: " + decodedWord);
                    }
                    
                    break;

                case 4:
                    menu = false;
                    break;

                default:
                    System.out.println("Selecione uma opção válida");
            }
        }
        scanner.close();
    }
}
