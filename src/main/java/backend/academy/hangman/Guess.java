package backend.academy.hangman;

import java.io.PrintStream;
import java.util.Scanner;

public class Guess {
    private PrintStream printStream;
    private Scanner scanner = new Scanner(System.in);

    public Guess(PrintStream printStream) {
        this.printStream = printStream;
    }

    // добавить выбор уровня сложности и коллекции
    protected char makeGuess() {
        printStream.print("Введите букву: ");
        String input = scanner.nextLine().toLowerCase();
        if (!input.equals("!")) {
            while (input.length() != 1 || !isCyrillicLetter(input.charAt(0))) {
                printStream.print("Пожалуйста, введите одну русскую букву: ");
                input = scanner.nextLine().toLowerCase();
                if (input.equals("!")) {
                    break;
                }
            }
        }
        return input.charAt(0);
    }

    // Метод для проверки, является ли символ русской буквой
    private boolean isCyrillicLetter(char ch) {
        return ch >= 'а' && ch <= 'я' || ch == 'ё';  // Диапазон русских букв
    }
}
