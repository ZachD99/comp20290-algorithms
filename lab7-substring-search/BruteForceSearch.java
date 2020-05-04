// Java program for Naive Pattern Searching 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BruteForceSearch {

	public static void search(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		for (int pos = 0; pos <= n-m; pos++) {
			int j;
			for (j = 0; j < m; j++)
				if (txt.charAt(pos + j) != pat.charAt(j))
					break;
			if (j == m)
				System.out.println("\nPattern found at index " + pos);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String pat = "qwertyuiop";

		File file1 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\100chars.txt");
		Scanner scanner1 = new Scanner(file1).useDelimiter("[^a-zA-Z]+");
		String txt1 = scanner1.next();
		final long startTime1 = System.nanoTime();
		search(txt1, pat);
		final long elapsedTime1 = System.nanoTime() - startTime1;
		System.out.println("Time taken: " + elapsedTime1 + "ns.");

		File file2 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\500chars.txt");
		Scanner scanner2 = new Scanner(file2).useDelimiter("[^a-zA-Z]+");
		String txt2 = scanner2.next();
		final long startTime2 = System.nanoTime();
		search(txt2, pat);
		final long elapsedTime2 = System.nanoTime() - startTime2;
		System.out.println("Time taken: " + elapsedTime2 + "ns.");

		File file3 = new File("C:\\Users\\zachd\\OneDrive\\Documents\\Algorithms\\Documentation\\1000chars.txt");
		Scanner scanner3 = new Scanner(file3).useDelimiter("[^a-zA-Z]+");
		String txt3 = scanner3.next();
		final long startTime3 = System.nanoTime();
		search(txt3, pat);
		final long elapsedTime3 = System.nanoTime() - startTime3;
		System.out.println("Time taken: " + elapsedTime3 + "ns.");
	}
}
