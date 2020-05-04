// JAVA program for implementation of KMP pattern 
// searching algorithm

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class KMPsearch {
	void KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int[] lps= new int[M];
		int j = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		computeLPSArray(pat, M, lps);

		//insert your code here

		int i = 0;
		while(i<N) {
			if (txt.charAt(i) == pat.charAt(j)) {
				j++;
				i++;
			}

			if (M == j) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			}else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
	}

	void computeLPSArray(String pat, int M, int[] lps) {
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				}
				else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}

	// Driver program to test above function
	public static void main(String[] args) throws FileNotFoundException {
		String pat = "qwertyuiop";

		File file1 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\100chars.txt");
		Scanner scanner1 = new Scanner(file1).useDelimiter("[^a-zA-Z]+");
		String txt1 = scanner1.next();
		final long startTime1 = System.nanoTime();
		new KMPsearch().KMPSearch(pat, txt1);
		final long elapsedTime1 = System.nanoTime() - startTime1;
		System.out.println("Time taken: " + elapsedTime1 + "ns.");

		File file2 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\500chars.txt");
		Scanner scanner2 = new Scanner(file2).useDelimiter("[^a-zA-Z]+");
		String txt2 = scanner2.next();
		final long startTime2 = System.nanoTime();
		new KMPsearch().KMPSearch(pat, txt2);
		final long elapsedTime2 = System.nanoTime() - startTime2;
		System.out.println("Time taken: " + elapsedTime2 + "ns.");

		File file3 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\1000chars.txt");
		Scanner scanner3 = new Scanner(file3).useDelimiter("[^a-zA-Z]+");
		String txt3 = scanner3.next();
		final long startTime3 = System.nanoTime();
		new KMPsearch().KMPSearch(pat, txt3);
		final long elapsedTime3 = System.nanoTime() - startTime3;
		System.out.println("Time taken: " + elapsedTime3 + "ns.");
	}
}
