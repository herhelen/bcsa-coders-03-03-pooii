package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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

    public static Integer inputInt(Scanner sc, String msg, List<Integer> validValues, String invalidValueMsg) {
        boolean isInputSuccess = false;
        Integer input = null;

        while(!isInputSuccess) {
            System.out.print(msg);

            if(sc.hasNextInt()) {
                input = sc.nextInt();
                sc.nextLine();

                if (validValues.contains(input)) {
                    isInputSuccess = true;
                } else {
                    System.out.println(invalidValueMsg);
                }
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
            } else {
                isInputSuccess = true;
            }
        }

        return input;
    }

    public static LocalDateTime inputDateTime(Scanner sc, String datetimePattern, String msg, String invalidValueMsg) {
        boolean isParsingSuccess = false;
        String input = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datetimePattern);

        LocalDateTime dateTime = null;
        while (!isParsingSuccess) {
            try {
                System.out.println(msg);
                input = sc.nextLine();
                dateTime = LocalDateTime.parse(input, formatter);
                isParsingSuccess = true;
            } catch (DateTimeParseException e) {
                System.out.println(invalidValueMsg);
            }
        }

        return dateTime;
    }

}
