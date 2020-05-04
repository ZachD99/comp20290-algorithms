/*
    Java implementation of the Russian Peasants multiplication algorithm
 */

import java.lang.*;

public class RussianPeasants {

 static int RussianMultiply(int n, int m) {
  int accumulator = 0;
  while (m > 0)
  {
   if (m % 2 == 1)
    accumulator += n;
   m /= 2;
   n *= 2;
  }
  return accumulator;
 }

 public static void main (String [] args) {
  final long startTime = System.nanoTime();
  System.out.println("4383 X 8238 = " + RussianMultiply(4383,8238));
  final long elapsedTime = System.nanoTime() - startTime;
  System.out.println("Time taken: " + elapsedTime + "ns.");
 }
}
