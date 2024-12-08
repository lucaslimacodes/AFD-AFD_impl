package Automata;

import State.State;

import java.util.ArrayList;

public abstract class Automata {
    private char[] alphabet;
    private String[] allStates;
    private String[] acceptanceStates;
    private String initialState;
    private ArrayList<State> states;

    public Automata(char[] alphabet, String[] allStates, String[] acceptanceStates, String initialState) {
        this.alphabet = alphabet;
        this.allStates = allStates;
        this.acceptanceStates = acceptanceStates;
        this.initialState = initialState;
        this.states = new ArrayList<State>();
        for(String s : allStates) {
            states.add(new State(s));
        }
    }

    protected State getStateByID(String stateID) {
        for(State s : states) {
            if(s.getStateID().equals(stateID)) {
                return s;
            }
        }
        return null;
    }

    public void addTransition(String begin, String end, char symbol) {
        State beginState = getStateByID(begin);
        beginState.addTransition(symbol, end);
    }

    public abstract boolean accepts(String word);
    protected abstract void reset();
    protected abstract void feed(char symbol);

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String[] getAcceptanceStates() {
        return acceptanceStates;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

}
