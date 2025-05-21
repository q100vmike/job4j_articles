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
        int[] startAt = new int[10];
        String[] args = new String[0];
        Fool fool = new Fool();
        System.setOut(new PrintStream(output));

        while (fool.startAt < 20) {
            fool.player = "n";
            fool.compare(String.valueOf(startAt));
            //var answer = input.nextLine();
            String test = output.toString();
            fool.player = "y";
            fool.compare(String.valueOf(test));
        }

        String out = output.toString();

        assertEquals("Test string", output.toString());
    }

}