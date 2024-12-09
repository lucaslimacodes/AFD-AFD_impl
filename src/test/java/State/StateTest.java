package test.java.State;

import main.java.State.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {

    @Test
    @DisplayName("state add transition test")
    public void addTransitionTest(){
        State state = new State("oi");
        state.addTransition('s', "end");
        assertEquals('s', state.getTransitions().getFirst().getFirst());
        assertEquals("end", state.getTransitions().getFirst().getSecond());

    }
}
