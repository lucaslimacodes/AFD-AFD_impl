package AFD;

import Automata.Automata;
import Util.Pair;

import java.util.ArrayList;

public class AFD extends Automata {
    private int currState;

    public AFD(char[] alphabet, int numOfStates, int[] acceptanceStates, int initialState) {
        super(alphabet, numOfStates, acceptanceStates, initialState);
    }

    public AFD(char[] alphabet, int numOfStates, int[] acceptanceStates, int initialState, ArrayList<ArrayList<Pair<Character, Integer>>> transitions) {
        super(alphabet, numOfStates, acceptanceStates, initialState, transitions);
    }

    protected void feed(char symbol){
        ArrayList<Pair<Character, Integer>> currTransitions = getTransitions().get(currState);
        for(Pair<Character, Integer> transition : currTransitions){
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
        for(int accept : getAcceptanceStates()){
            if(accept==currState){
                reset();
                return true;
            }
        }
        reset();
        return false;
    }

}
