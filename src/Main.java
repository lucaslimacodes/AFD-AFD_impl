import AFD.AFD;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        char[] alphabet = {'0','1'};
        int[] accept = {1};
        AFD afd = new AFD(alphabet, 2, accept, 0);
        afd.addTransition(0,1,'0');
        afd.addTransition(0,0,'1');
        afd.addTransition(1,1,'1');
        afd.addTransition(1,0,'0');
        System.out.println(afd.accepts("011100101"));
    }
}