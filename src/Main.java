import java.util.Scanner;

import Controllers.MorseTreeController;

public class Main {
    public static void main(String[] args) throws Exception {
        MorseTreeController morseTreeController = new MorseTreeController();

        boolean menu = true;
        while (menu) {
            System.out.println(
                "Selecione a funcionalidade desejada:\n" +
                "1. Popular árvore\n" +
                "2. Ver árvore\n" +
                "3. Decodificar palavra\n" +
                "4. Sair"
            );
            Scanner scanner = new Scanner(System.in);

            int function = scanner.nextInt();
            scanner.close();

            switch (function) {
                case 1:
                    morseTreeController.createTree();
                    break;

                case 2:
                    morseTreeController.viewTree();
                    break;

                case 3:
                    String decodedWord = morseTreeController.decodeWord(askWord());
                    if (decodedWord == null) {
                        System.out.println("Código inválido");
                    } else {
                        System.out.println(decodedWord);
                    }
                    break;

                case 4:
                    menu = false;
                    break;

                default:
                    System.out.println("Selecione uma opção válida");
            }
        }
    }

    public static String askWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a palavra em código morse:");
        String word = scanner.nextLine();
        scanner.close();
        return word;
    }
}
