package test.java.AFD;

import main.java.AFD.AFD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AFDTest {

    @Test
    @DisplayName("test AFD accepts function")
    public void acceptsTest(){
        char[] alphabet = {'0','1'};
        String[] allStates = {"q1", "q2"};
        String[] accept = {"q2"};

        AFD afd = new AFD(alphabet, allStates, accept, "q1");
        afd.addTransition("q1","q1", '1');
        afd.addTransition("q1","q2", '0');
        afd.addTransition("q2","q2", '1');
        afd.addTransition("q2","q1", '0');
        assertTrue(afd.accepts("0"));
        assertTrue(afd.accepts("111110"));
        assertTrue(afd.accepts("0001100111111"));
        assertFalse(afd.accepts(""));
        assertFalse(afd.accepts("1"));
        assertFalse(afd.accepts("1001"));
    }
}
