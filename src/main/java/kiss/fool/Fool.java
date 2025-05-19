package kiss.fool;

import java.util.Scanner;

public class Fool {

    public static Integer startAt = 1;
    public static String player = "n";

    public static void compare(String answer) {
        String again = "Ошибка. Начинай снова.";
        String out =  "";

        if (startAt % 3 == 0 && startAt % 5 == 0) {
            out = !"FizzBuzz".equals(answer) && player == "y" ? again : "FizzBuzz";
        } else if (startAt % 3 == 0) {
            out = !"Fizz".equals(answer) && player == "y" ? again : "Fizz";
        } else if (startAt % 5 == 0) {
            out = !"Buzz".equals(answer) && player == "y" ? again : "Buzz";
        } else {
            out = String.valueOf(startAt).equals(answer) ? String.valueOf(startAt) : again;

        }
        if (player == "n" || (player == "y" && again.equals(out))) {
            System.out.println(out);
        }
        startAt++;
        if (again.equals(out)) {
            startAt = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        while (startAt < 100) {
            player = "n";
            compare(String.valueOf(startAt));
            var answer = input.nextLine();
            player = "y";
            compare(answer);
        }
    }
}
