import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = reader.readLine();
        try (Scanner scanner = new Scanner(s)) {
            final boolean hasNextInt = scanner.hasNextInt();
            doMainLogic(s, hasNextInt);
        }
    }

    static int doMainLogic(String s, boolean hasNextInt) {
        String[] args = s.split(" ");
        int a;
        int b;
        char op;
        boolean isError = false;
        boolean isArabic = hasNextInt;
        if (hasNextInt) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[2]);
        }
        else {
            a = getArabic(args[0]);
            b = getArabic(args[2]);
        }
        op = args[1].charAt(0);
        if (isError) {
            //todo: msg about err
            System.out.println(s + " " + "");
            return a;
        } else {
            Converter conv = new Converter();
            try {
                Calculator1 calc = new Calculator1();
                int answer = calc.calculate(a, op, b);
                if (isArabic) {
                    System.out.println(a + " " + op + " " + b + " = " + answer);
                } else {
                    System.out.println(s + " = " + conv.convert(answer));
                    System.out.println(answer);
                }
                return answer;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } finally {
            }
        }
        return a;
    }

    static int getArabic(String arg) {
        final int arg1LastPosition = arg.length() - 1;
        String string1 = Character.toString(arg.charAt(arg1LastPosition));
        RomanNumber number = RomanNumber.valueOf(string1);
        int a = number.getNumber();
        for (int i = arg1LastPosition - 1; i >= 0; i--) {
            string1 = Character.toString(arg.charAt(i));
            number = RomanNumber.valueOf(string1);
            String stringNext = Character.toString(arg.charAt(i+1));
            RomanNumber numberNext = RomanNumber.valueOf(stringNext);
            if (number.ordinal() < numberNext.ordinal()){
                a = a - number.getNumber();
            }
            else {
                a = a + number.getNumber();
            }
        }
        return a;
    }

}


