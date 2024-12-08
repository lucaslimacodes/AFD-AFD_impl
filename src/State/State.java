package State;

import Util.Pair;

import java.util.ArrayList;

public class State {
    private String stateID;
    private ArrayList<Pair<Character, String>> transitions; // char -> nextStateID


    public State(String stateID) {
        this.stateID = stateID;
        this.transitions = new ArrayList<>();
    }

    public State(String stateID, ArrayList<Pair<Character, String>> transitions) {
        this(stateID);
        this.transitions = transitions;
    }

    public void addTransition(char symbol, String endState){
        transitions.add(new Pair<>(symbol, endState));
    }

    public String getStateID() {
        return stateID;
    }
    public void setStateID(String stateID) {
        this.stateID = stateID;
    }
    public ArrayList<Pair<Character, String>> getTransitions() {
        return transitions;
    }
    public void setTransitions(ArrayList<Pair<Character, String>> transitions) {
        this.transitions = transitions;
    }

}
