import java.util.Scanner;
import static java.lang.Integer.*;


public class Main {

    static Scanner scan = new Scanner(System.in);
    static int a;
    static int b;
    static String aRome;
    static String bRome;
    static int result;
    static String op;
    static String input;
    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
                "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
                "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Введите выражение.");
        input = scan.nextLine();
        if (input.contains("+")) {
            op = "\\+";
        } else if (input.contains("-")) {
            op = "-";
        } else if (input.contains("*")) {
            op = "\\*";
        } else if (input.contains("/")) {
            op = "/";
        } else {
            System.out.println("Строка не является математической операцией");
            return;
        }
        String[] numbers = input.split(op);
        if (numbers.length>2 || numbers[1].contains(op)) {
            System.out.println("Выражение должно состоять из одного действия");
            return;}
        else {
            if (isNumeric(numbers[0])) {
                a = parseInt(numbers[0]);
            } else {
                aRome = numbers[0];
                for (int i = 0; i < 10; i++) {
                    if (roman[i].equals(aRome)) {
                        a = i + 1;
                    }
                }
            }
        }
        if ((isNumeric(numbers[0]) && !isNumeric(numbers[1]) || (!isNumeric(numbers[0]) && isNumeric(numbers[1])))) {
            System.out.println("Числа должны быть с одной системе счисления");
            return;
        }
        if (a < 1 || a > 10) {
            System.out.println("Первое число не входит в диапазон от 1 до 10");
            return;
        }
        if (isNumeric(numbers[1])) {
            b = parseInt(numbers[1]);
        } else {
            bRome = numbers[1];
            for (int i = 0; i < 10; i++) {
                if (roman[i].equals(bRome)) {
                    b = i + 1;
                }
            }
        }
        if (b < 1 || b > 10) {
            System.out.println("Второе число не входит в диапазон от 1 до 10");
            return;
        }
        switch (op) {
            case "\\+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "\\*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
        }
        if(isNumeric(numbers[0])){
            System.out.println(result);
        } else {
            if (result<0) {
                System.out.println("В римской системе нет отрицательных чисел");
            } else {
                System.out.println(roman[(result-1)]);
            }
        }
    }
}

