import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = reader.readLine();
        try (Scanner scanner = new Scanner(s)) {
            final boolean hasNextInt = scanner.hasNextInt();
            doMainLogic(s, hasNextInt);
        }
//        if (isArabic) {
//            System.out.println(num1 + " " + this.op + " " + num2 + " = " + ans);
//        } else if (isError) {
//        } else {
//
//
//            System.out.println(s + " = " + conv.convert(ans));
//            System.out.println(ans);
//        }

    }

    static int doMainLogic(String s, boolean hasNextInt) {
        String[] strings = s.split(" ");
        int a = 0;
        int b = 0;
        char op = 'l';
        char ch = 'm';
        boolean isError = false;
        boolean isArabic = false;
        if (hasNextInt) {
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[2]);
            op = strings[1].charAt(0);
            isArabic = true;
        }
        else {
            final int arg1LastPosition = strings[0].length() - 1;
            for (int i = 0; i <= arg1LastPosition; i++) {
                final char charAtNextPosition = (i == arg1LastPosition ?
                        '#' : strings[0].charAt(i + 1));
                ch = strings[0].charAt(i);
                switch (ch) {
                    case 'I':
                        if ((charAtNextPosition == 'V') || (charAtNextPosition == 'X')) {
                            a--;
                        } else {
                            a++;
                        }
                        break;
                    case 'V':
                            a += 5;
                        break;
                    case 'X':
                        if (((charAtNextPosition) == 'L') || ((charAtNextPosition) == 'C')) {
                            a -= 10;
                        } else {
                            a += 10;
                        }
                        break;
                    case 'L':
                            a += 50;
                        break;
                    case 'C':
                        if (((charAtNextPosition) == 'D') || ((charAtNextPosition) == 'M')) {
                            a -= 100;
                        } else {
                            a += 100;
                        }
                        break;
                    case 'D':
                            a += 500;
                        break;
                    case 'M':
                        a += 1000;
                        break;
                    default:
                        System.out.println("Error");
                        isError = true;
                }
            }
            final int arg2LastPosition = strings[2].length() - 1;
            for (int i = arg2LastPosition; i >= 0; i--) {
                    ch = strings[2].charAt(i);
                final char charAtNextPosition = (i == arg2LastPosition ?
                        '#' : strings[2].charAt(i + 1));
                final boolean isPlusOne = (i == arg2LastPosition) || (charAtNextPosition == 'I');
                    switch (ch) {
                        case 'I':
                            if (isPlusOne) {
                                b++;
                            } else {
                                b--;
                            }
                            break;
                        case 'V':
                            if (isPlusOne) {
                                b += 5;
                            } else {
                                b -= 5;
                            }
                            break;
                        case 'X':
                            if ((i == arg2LastPosition) || (charAtNextPosition == 'I') || (charAtNextPosition == 'V') || (charAtNextPosition == 'X')) {
                                b += 10;
                            } else {
                                b -= 10;
                            }
                            break;
                        case 'L':
                            if ((i == arg2LastPosition) || (charAtNextPosition == 'I') || (charAtNextPosition == 'V') || (charAtNextPosition == 'X')) {
                                b += 50;
                            } else {
                                b -= 50;
                            }
                            break;
                        case 'C':
                            if ((i == arg2LastPosition) || (charAtNextPosition == 'I') || (charAtNextPosition == 'V') || (charAtNextPosition == 'X') || (charAtNextPosition == 'L') || (charAtNextPosition == 'C')) {
                                b += 100;
                            } else {
                                b -= 100;
                            }
                            break;
                        case 'D':
                            if ((i == arg2LastPosition) || (charAtNextPosition == 'I') || (charAtNextPosition == 'V') || (charAtNextPosition == 'X') || (charAtNextPosition == 'L') || (charAtNextPosition == 'C')) {
                                b += 500;
                            } else {
                                b -= 500;
                            }
                            break;
                        case 'M':
                            b += 1000;
                            break;
                        default:
                            System.out.println("Error");
                            isError = true;
                    }
                }
            op = strings[1].charAt(0);
        }
        //else {
        //    System.out.println("Error");
        //}
        /*String s = "/*+-";
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(s.codePointAt(0));
        */

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

}


