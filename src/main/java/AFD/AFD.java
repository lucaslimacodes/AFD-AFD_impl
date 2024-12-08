package main.java.AFD;

import main.java.Automata.Automata;
import main.java.State.State;
import main.java.Util.Pair;

import java.util.ArrayList;

public class AFD extends Automata {
    private String currState;

    public AFD(char[] alphabet, String[] allStates, String[] acceptanceStates, String initialState) {
        super(alphabet, allStates, acceptanceStates, initialState);
        this.currState = initialState;
    }

    protected void feed(char symbol){
        State currState = this.getStateByID(this.currState);
        for(Pair<Character, String> transition : currState.getTransitions()){
            if(transition.getFirst() == symbol){
                this.currState = transition.getSecond();
                break;
            }
        }
    }

    protected void reset(){
        this.currState = getInitialState();
    }

    public boolean accepts(String word){
        for(char symbol : word.toCharArray()){
            feed(symbol);
        }
        for(String accept : getAcceptanceStates()){
            if(accept.equals(currState)){
                reset();
                return true;
            }
        }
        reset();
        return false;
    }

}
