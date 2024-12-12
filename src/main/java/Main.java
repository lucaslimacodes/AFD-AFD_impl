package main.java;


import main.java.AFD.AFD;
import main.java.AFN.AFN;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        char[] alphabet = {'0','1'};
        String[] allStates = {"q1", "q2", "q3", "q4"};
        String[] accept = {"q4"};
        AFN afn = new AFN(alphabet, allStates, accept, "q1");
        afn.addTransition("q1", "q1", '0');
        afn.addTransition("q1", "q1", '1');
        afn.addTransition("q1", "q2", '1');
        afn.addTransition("q2", "q3", '0');
        afn.addTransition("q2", "q3", '1');
        afn.addTransition("q3", "q4", '0');
        afn.addTransition("q3", "q4", '1');
        System.out.println(afn.accepts("10000000000"));

//        AFD afd = new AFD(alphabet, allStates, accept, "q1");
//        afd.addTransition("q1","q1", '1');
//        afd.addTransition("q1","q2", '0');
//        afd.addTransition("q2","q2", '1');
//        afd.addTransition("q2","q1", '0');
//        System.out.println(afd.accepts("0101100111111111011"));

    }
}