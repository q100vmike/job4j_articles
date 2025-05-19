package kiss.fool;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void whenMainTrue() {
        String[] args = new String[0];
        Fool fool = new Fool();
        fool.main(args);

        String out = output.toString();

        assertEquals("Test string", output.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}