package main.java;


import main.java.AFD.AFD;
import main.java.AFN.AFN;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        char[] alphabet = {'0','1'};
        String[] allStates = {"1", "2", "3"};
        String[] accept = {"3"};
        AFN afn = new AFN(alphabet, allStates, accept, "1");
        afn.addTransition("1" ,"1", '0');
        afn.addTransition("1" ,"2", AFN.EPSILON);
        afn.addTransition("2" ,"2", '1');
        afn.addTransition("2" ,"3", '0');
        afn.addTransition("3" ,"3", '0');
//        AFD afd = new AFD(alphabet, allStates, accept, "q1");
//        afd.addTransition("q1","q1", '1');
//        afd.addTransition("q1","q2", '0');
//        afd.addTransition("q2","q2", '1');
//        afd.addTransition("q2","q1", '0');
//        System.out.println(afd.accepts("0101100111111111011"));
        System.out.println(afn.accepts("00001110"));



    }
}