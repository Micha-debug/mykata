import java.util.ArrayList;
import java.util.List;

public class Converter {
    String roman = "";
    List<RomanNumber> romanList = List.of(RomanNumber.X, RomanNumber.X, RomanNumber.I);

    String convert(int arabic) {
        if (arabic <= 0) {
            throw new RuntimeException("Negative result is not allowed in the roman system: " + arabic);
        }
        while (arabic != 0) {
            while (arabic % 5 >= 1) {
                if (arabic % 10 == 9) {
                    roman = "IX" + roman;
                    arabic -= 9;
                } else if (arabic % 5 == 4) {
                    roman = "IV" + roman;
                    arabic -= 4;
                } else {
                    roman = "I" + roman;
                    arabic -= 1;
                }
            }
            while (arabic % 10 >= 5) {
                roman = "V" + roman;
                arabic -= 5;
            }
            while (arabic % 50 >= 10) {
                if (arabic % 100 == 90) {
                    roman = "XC" + roman;
                    arabic -= 90;
                } else if (arabic % 50 == 40) {
                    roman = "XL" + roman;
                    arabic -= 40;
                } else {
                    roman = "X" + roman;
                    arabic -= 10;
                }
            }
            while (arabic % 100 >= 50) {
                roman = "L" + roman;
                arabic -= 50;
            }
            while (arabic % 500 >= 100) {
                if (arabic % 1000 == 900) {
                    roman = "CM" + roman;
                    arabic -= 900;
                } else if (arabic % 500 >= 400) {
                    roman = "CD" + roman;
                    arabic -= 400;
                } else {
                    roman = "C" + roman;
                    arabic -= 100;
                }
            }
            while (arabic % 1000 >= 500) {
                roman = "D" + roman;
                arabic -= 500;
            }
            for(int i = 0; i < arabic/1000; i++){
                roman = "M" + roman;
            }
        }
        return (roman);
    }
}
