/*
    Java implementation of the recursive solution to the Towers of Hanoi problem
 */

public class Hanoi {

    static void hanoiTowers(int disk, String source, String destination, String aux) {
        if(disk==1)    //base case
            System.out.println("Move disk 1 from " + source + " to " + destination);
        else {
            hanoiTowers(disk - 1, source, aux, destination);
            System.out.println("Move disk " + disk + " from " + source + " to " + destination);
            hanoiTowers(disk - 1, aux, destination, source);
        }
    }

    public static void main (String[] args)
    {
        int n = 5;
        final long startTime = System.nanoTime();
        hanoiTowers(n,"A", "C", "B");
        final long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + elapsedTime + "ns.");
    }
}
