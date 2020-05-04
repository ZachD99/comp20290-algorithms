public class fibonacci {
    static int fibonacciIterative(int n){
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    static int fibonacciRecursive(int x) {
        if (x <= 1)
            return x;
        return fibonacciRecursive(x-1) + fibonacciRecursive(x-2);
    }

    public static void main (String[] args)
    {
        int m = 44;
        final long startTime = System.nanoTime();
        System.out.println(fibonacciIterative(m));
        final long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Time taken: " + elapsedTime + "ns.");

        int n = 44;
        final long startTime2 = System.nanoTime();
        System.out.println(fibonacciRecursive(n));
        final long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("Time taken: " + elapsedTime2 + "ns.");
    }

}
