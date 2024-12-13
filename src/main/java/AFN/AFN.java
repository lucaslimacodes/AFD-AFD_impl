package main.java.AFN;

import main.java.Automata.Automata;
import main.java.State.State;
import main.java.Util.Pair;

import java.util.ArrayList;

public class AFN extends Automata {
    public static Character EPSILON = '$';
    private ArrayList<String> currState;

    public AFN(char[] alphabet, String[] allStates, String[] acceptanceState, String initialState) {
        super(alphabet, allStates, acceptanceState, initialState);
        this.currState = new ArrayList<>();
        this.currState.add(initialState);
    }

    private ArrayList<String> allStatesFromEpsilon(String beginState){
        State state = getStateByID(beginState);
        ArrayList<String> ret = new ArrayList<>();
        for(Pair<Character,String> transition : state.getTransitions()){
            if(transition.getFirst().equals(EPSILON)){
                ret.add(transition.getSecond());
                ret.addAll(allStatesFromEpsilon(transition.getSecond()));
            }
        }
        return ret;
    }

    protected void feed(char symbol){
        ArrayList<String> newStates = new ArrayList<>();
        for(String s : this.currState){;
            State state = getStateByID(s);
            for(Pair<Character,String> transition : state.getTransitions()){
                if(transition.getFirst() == symbol){
                    newStates.add(transition.getSecond());
                    newStates.addAll(allStatesFromEpsilon(transition.getSecond()));
                }
            }
        }
        this.currState = newStates;
    }


    protected void reset(){
        this.currState.clear();
        this.currState.add(getInitialState());
    }

    public boolean accepts(String word){
        this.currState.addAll(allStatesFromEpsilon(this.currState.getFirst()));
        for(char c : word.toCharArray()){
            feed(c);
        }
        for(String s : this.currState){
            if(isAcceptanceState(s)){
                return true;
            }
        }
        return false;
    }

}
