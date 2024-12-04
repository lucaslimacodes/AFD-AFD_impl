package Automata;

import Util.Pair;

import java.util.ArrayList;

public abstract class Automata {
    private char[] alphabet;
    private int numOfStates;
    private int[] acceptanceStates;
    private int initialState;
    private ArrayList<ArrayList<Pair<Character, Integer>>> transitions;

    public Automata(char[] alphabet, int numOfStates, int[] acceptanceStates, int initialState) {
        this.alphabet = alphabet;
        this.numOfStates = numOfStates;
        this.acceptanceStates = acceptanceStates;
        this.initialState = initialState;
        this.transitions = new ArrayList<>(numOfStates);
        for (int i = 0; i < numOfStates; i++) {
            transitions.add(new ArrayList<>());
        }
    }

    public Automata(char[] alphabet, int numOfStates, int[] acceptanceStates, int initialState, ArrayList<ArrayList<Pair<Character, Integer>>> transitions) {
        this(alphabet, numOfStates, acceptanceStates, initialState);
        this.transitions = transitions;
    }
    public void addTransition(int begin, int end, char symbol) {
        ArrayList<Pair<Character, Integer>> transitionsOfBegin = transitions.get(begin);
        Pair<Character, Integer> transition = new Pair<>(symbol, end);
        transitionsOfBegin.add(transition);
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

    public int[] getAcceptanceStates() {
        return acceptanceStates;
    }

    public void setAcceptanceStates(int[] acceptanceStates) {
        this.acceptanceStates = acceptanceStates;
    }

    public int getNumOfStates() {
        return numOfStates;
    }

    public void setNumOfStates(int numOfStates) {
        this.numOfStates = numOfStates;
    }

    public int getInitialState() {
        return initialState;
    }

    public void setInitialState(int initialState) {
        this.initialState = initialState;
    }

    public ArrayList<ArrayList<Pair<Character, Integer>>> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<ArrayList<Pair<Character, Integer>>> transitions) {
        this.transitions = transitions;
    }
}
