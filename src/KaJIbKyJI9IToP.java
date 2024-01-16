import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class KaJIbKyJI9IToP {
    static int number1;
    static int number2;
    static char operation;
    static int result;
    static String userInput;
    static String chast1;
    static String chast2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        userInput = scanner.nextLine();

        String FinalResult = calc(userInput);
        System.out.println("<<< Результат >>>");
        System.out.println(chast1 + " " + operation + " " + chast2 + " = " + FinalResult);
    }
    public static String calc (String input){

        String z = null;

        char[] under_char = new char[9];
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        if (operation == 0) {
            throw new IllegalArgumentException("СТРОКА ВВЕДЕНА НЕ ПРАВИЛЬНО");
        }

        String inputRep = input.replace(" ", "");
        String[] chasti = inputRep.split("[+\\-/*]");
        chast1 = chasti[0];
        chast2 = chasti[1];

        try {
            if (chasti[2] != "") {
                throw new IllegalArgumentException("ВВЕДЕНО НЕ ВЕРНОЕ ВЫРАЖЕНИЕ");
            }
        } catch (ArrayIndexOutOfBoundsException exc) {}
        try {

            number1 = parseInt(chast1);
            number2 = parseInt(chast2);

            if ((number1 <= 10) & (number2 <= 10) & (number1 > 0) & (number2 > 0)) {
                result = calculated(number1, number2, operation);
                z = String.valueOf(result);
            } else {
                throw new IllegalArgumentException("ДОЛЖНЫ ИСПОЛЬЗОВАТЬСЯ ЧИСЛА В ДИАПАЗОНЕ ОТ 1 ДО 10");
            }
        } catch (NumberFormatException e) {

            number1 = romanToNumber(chast1);
            number2 = romanToNumber(chast2);

            if ((number1 < 0) | (number2 < 0)) {
                throw new IllegalArgumentException("НЕ ВЕРНОЕ ВЫРАЖЕНИЕ");
            } else {
                result = calculated(number1, number2, operation);
                try {
                    String resultRoman = convertNumToRoman(result);
                    z=resultRoman;
                } catch (ArrayIndexOutOfBoundsException exception) {
                    throw new IllegalArgumentException("В РИМСКОЙ СИСТЕМЕ НЕТ ОТРИЦАТЕЛЬНЫХ ЧИСЕЛ");
                }
            }
        }
        return z;
    }
    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String x = roman[numArabian];
        return x;
    }
    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -1;
    }
    public static int calculated(int num1, int num2, char operatorCalculated) {
        int result = 0;
        switch (operatorCalculated) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
        }
        return result;
    }
}