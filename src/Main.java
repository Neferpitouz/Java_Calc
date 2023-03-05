import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Result example = new Result();
        Income test = new Income();
        System.out.println("Введите выражение:");
        Scanner input = new Scanner(System.in);
        test.equazion = input.nextLine();
        example.cifer = test.intResult(test.splitter());
        System.out.println(test.equazion + " = " + example.roman_convert());
    }
}
class Income {
    String equazion;
    String[] splitter() {
        String[] result = equazion.split(" ");
        return result;
    }
    int intResult(String[] massive){
        int res = 0;
            try{
            if(massive.length != 3){throw new IOException();}}
            catch (IOException e){
                System.out.println("Выражение не соответствует схеме: операнд оператор операнд");
                System.exit(1);
                }
        Ten_Roman[] romans = Ten_Roman.values();
        int d1 = 0;
        int d2 = 0;
        int rom = 0;
        int arabic = 0;
        String operator = massive[1];
        String b1 = massive[0];
        String b2 = massive[2];

        for (Ten_Roman d:romans
             ) {try {
            if (parseInt(b1) == d.getValue()) {
                arabic++;
                d1 = d.getValue();
            }
                }
                catch (NumberFormatException not_arabic)
                {
                    if(b1.equals(d.getRoman_value())){
                        rom++;
                        d1 = d.getValue();
                    }
                }
        }
        for (Ten_Roman d:romans
        ) {try {
            if (parseInt(b2) == d.getValue()) {
                arabic++;
                d2 = d.getValue();
            }
        }
        catch (NumberFormatException not_arabic)
        {
            if(b2.equals(d.getRoman_value())){
                rom++;
                d2 = d.getValue();
            }
        }

        }
        try
        {
            if (((arabic + rom) < 2)||(d1 > 10)||(d2 > 10)) {
                throw new IOException();
            }
        }
        catch (IOException s){
            System.out.println("Разрешены числа от 1 до 10");
            System.exit(1);
        }
        try
        {
            if ((rom == 1) || (arabic == 1)) {
                throw new IOException();
            }
        }
        catch (IOException same_system)
        {
            System.out.println("Числа должны быть одной системы");
            System.exit(1);
        }
            switch (operator) {
                case "+":
                    res = d1 + d2;
                    break;
                case "-":
                    res = d1 - d2;
                    break;
                case "*":
                    res = d1 * d2;
                    break;
                case "/":
                    if (d2 != 0 || d2 <= d1) {
                        res = d1 / d2;
                        break;
                    }
                default:
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Недопустимый оператор");
                        System.exit(1);
                    }

            }
        if (rom == 2){
            res *= -1;
        }
        else if (arabic == 2) {
            res *= 1;
        }
        try
        {
            if ((res == 0) && (rom == 2)) {
                throw new NoZeroRoman("Ноль не может быть результатом вычислений в римской системе");
            }
        }
        catch(NoZeroRoman noZero){
            System.out.println("Ноль не может быть результатом вычислений в римской системе");
            System.exit(1);
        }

        return res;
    }

}
class Result {
    int cifer;
    String roman_convert(){
        String result = "";
        if(cifer < 0) {
            cifer *= -1;
            Roman[] romans = Roman.values();
            while (cifer > 0) {
                for (Roman values : romans
                ) {
                    if (cifer >= values.getValue()) {
                        cifer = cifer - values.getValue();
                        result += values.getRoman_value();
                        break;
                    }

                }
            }
        }
        else
        {
            result = Integer.toString(cifer);
        }
        return result;
    }
}


