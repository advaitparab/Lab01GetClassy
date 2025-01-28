import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SafeInputObjTest {

    @Test
    void testGetNonZeroLengthString() {
        String simulatedInput = "\nHello\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(new Scanner(System.in));
        String result = safeInput.getNonZeroLengthString("Enter non-zero string");
        assertEquals("Hello", result);
    }

    @Test
    void testGetInt() {
        String simulatedInput = "notanumber\n42\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(new Scanner(System.in));
        int result = safeInput.getInt("Enter an integer");
        assertEquals(42, result);
    }

    @Test
    void testGetDouble() {
        String simulatedInput = "invalid\n3.14\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(new Scanner(System.in));
        double result = safeInput.getDouble("Enter a double");
        assertEquals(3.14, result, 0.001);
    }

    @Test
    void testGetYNConfirm() {
        String simulatedInput = "maybe\nY\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        SafeInputObj safeInput = new SafeInputObj(new Scanner(System.in));
        boolean result = safeInput.getYNConfirm("Do you confirm?");
        assertTrue(result);
    }
}
