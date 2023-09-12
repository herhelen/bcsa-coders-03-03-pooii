package utils;

import java.util.Scanner;

public class InputUtils {

    public static Integer inputInt(Scanner sc) {
        boolean isInputSuccess = false;
        Integer input = null;

        while(!isInputSuccess) {
            if(sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();
                isInputSuccess = true;
            } else {
                System.out.println("Entrada inválida. O valor esperado é um número inteiro.");
                sc.nextLine();
            }
        }

        return input;
    }

    public static Integer inputInt(Scanner sc, String msg) {
        boolean isInputSuccess = false;
        Integer input = null;

        while(!isInputSuccess) {
            System.out.print(msg);

            if(sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();
                isInputSuccess = true;
            } else {
                System.out.println("Entrada inválida. O valor esperado é um número inteiro.");
                sc.nextLine();
            }
        }

        return input;
    }

    public static String inputString(Scanner sc, String msg) {
        boolean isInputSuccess = false;
        String input = null;

        while(!isInputSuccess) {
            System.out.print(msg);
            input = sc.nextLine();

            if(input == null || input.isBlank()) {
                System.out.println("Entrada vazia ou apenas com espaço em branco.");
                sc.nextLine();
            } else {
                isInputSuccess = true;
            }
        }

        return input;
    }
}
