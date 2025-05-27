package kiss.fool;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    void whenMainTrue() {
        String exected = "1\r\nFizz\r\nBuzz\r\n7\r\nFizz\r\n11\r\n13\r\nFizzBuzz\r\n17\r\n19\r\nFizz\r\n23\r\nBuzz\r\n";
        String[] answers = {"2", "4", "Fizz", "8", "Buzz", "Fizz", "14", "16", "Fizz", "Buzz", "22", "Fizz", "26"};
        int i = 0;

        Fool fool = new Fool();
        System.setOut(new PrintStream(output));

        while (fool.startAt < answers.length * 2) {
            fool.player = "n";
            fool.compare(String.valueOf(fool.startAt));

            fool.player = "y";
            fool.compare(String.valueOf(answers[i]));
            i++;
        }
        assertEquals(exected, output.toString());
    }

    @Test
    void whenMainFalse() {
        String exected = "1\r\nFizz\r\nОшибка. Начинай снова.\r\n";
        String[] answers = {"2", "4", "1"};
        Fool fool = new Fool();
        System.setOut(new PrintStream(output));

        for (int i = 0; i < answers.length; i++) {
            fool.player = "n";
            fool.compare(String.valueOf(fool.startAt));

            fool.player = "y";
            fool.compare(String.valueOf(answers[i]));
            i++;
        }
        assertEquals(exected, output.toString());
    }
}