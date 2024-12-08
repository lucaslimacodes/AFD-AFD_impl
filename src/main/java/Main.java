package main.java;


import main.java.AFD.AFD;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        char[] alphabet = {'0','1'};
        String[] allStates = {"q1", "q2"};
        String[] accept = {"q2"};

        AFD afd = new AFD(alphabet, allStates, accept, "q1");
        afd.addTransition("q1","q1", '1');
        afd.addTransition("q1","q2", '0');
        afd.addTransition("q2","q2", '1');
        afd.addTransition("q2","q1", '0');
        System.out.println(afd.accepts("0101100111111111011"));
    }
}