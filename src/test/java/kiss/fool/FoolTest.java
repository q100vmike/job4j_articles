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

        Fool fool = new Fool();
        System.setOut(new PrintStream(output));

        while (fool.startAt < 20) {
            fool.player = "n";
            fool.compare(String.valueOf(fool.startAt));
            //var answer = input.nextLine(); 1\r\n 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 1617 Fizz 19 Buzz Fizz 22 23 Fizz Buzz
            String test = output.toString();
            fool.player = "y";
            fool.compare(String.valueOf(test));
        }

        String out = output.toString();

        assertEquals("Test string", output.toString());
    }

}