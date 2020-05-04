/*
	Java implementation of various different sorting algorithms
 */

import java.util.Random;

public class AllSortsOfSorts {
	public static final int CUTOFF = 10;

	static void selectionSort (int[] arr){
		for (int i = 0; i < arr.length-1; i++)
		{
			int min_idx = i;
			for (int j = i+1; j < arr.length; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	static void insertionSort(int[] arr, int hi) {
		for (int i = 1; i <= hi; i++) {
			for (int j = i; ((j > 0) && (arr[j] < arr[j - 1])); j--) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}
	/*
    static int[] stalinSort (int[] arr) {
        int []arr2 = new int[arr.length];
        int j = 1;

        arr2[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr2[j-1] <= arr[i]) {
                arr2[j] = arr[i];
                j++;
            }
        }
        return arr2;
    }
    */
	static void mergeSort(int[] a, int n) {
		if (n < 2)
			return;
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		System.arraycopy(a, 0, l, 0, mid);
		if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		merge(a, l, r, mid, n - mid);
	}

	static void enhancedMergeSort(int[] a, int hi) {
		if (hi < 2)
			return;
		if (hi <= CUTOFF) {
			insertionSort(a, hi);   //uses insertion sort for smaller data sets
			return;
		}
		int mid = hi / 2;
		int[] l = new int[mid];
		int[] r = new int[hi - mid];
		System.arraycopy(a, 0, l, 0, mid);
		if (hi - mid >= 0) System.arraycopy(a, mid, r, 0, hi - mid);
		mergeSort(l, mid);
		mergeSort(r, hi-(mid+1));
		if ((a[mid+1] >= a[mid])) return;       //skips call to merge if already sorted
		merge(a, l, r, mid, hi - mid);
	}

	static void merge(int[] a, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j])
				a[k++] = l[i++];
			else
				a[k++] = r[j++];
		}
		while (i < left)
			a[k++] = l[i++];
		while (j < right)
			a[k++] = r[j++];
	}

	static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
	}

	static void enhancedQuickSort( int[] a, int low, int high ) {
		if( low + CUTOFF > high )
			insertionSort(a, high );
		else {
			// Sort low, middle, high
			int mid = ( low + high ) / 2;
			if(a[mid] < a[low]) {
				int tmp = a[low];
				a[low] = a[mid];
				a[mid] = tmp;
			}
			if(a[high] < a[low]) {
				int tmp = a[low];
				a[low] = a[high];
				a[high] = tmp;
			}
			if(a[high] < a[mid]) {
				int tmp = a[mid];
				a[mid] = a[high];
				a[high] = tmp;
			}

			// Place pivot at position high - 1
			int tmp = a[mid];
			a[mid] = a[high-1];
			a[high-1] = tmp;
			int pivot = a[high-1];

			// Begin partitioning
			int i, j;
			for( i = low, j = high - 1; ; ) {
				while(a[++i] < pivot)
					;
				while(pivot < a[--j])
					;
				if( i >= j )
					break;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}

			// Restore pivot
			int temp = a[i];
			a[i] = a[high-1];
			a[high-1] = temp;

			enhancedQuickSort( a, low, i - 1 );    // Sort small elements
			enhancedQuickSort( a, i + 1, high );   // Sort large elements
		}
	}

	static int partition (int[] arr, int low, int high) {
		int piv = arr[high];
		int i = (low - 1) ; // Index of smaller element

		for (int j = low; j <= high-1; j++) {
			// If current element is smaller than the pivot
			if (arr[j] < piv) {
				i++;    // increment index of smaller element
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		return (i + 1);
	}

	static void randomize(int [] arr){
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = random.ints(10, 0, 100).toArray();

		System.out.println("Original Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}

		final long startTime = System.nanoTime();
		selectionSort(array);
		final long elapsedTime = System.nanoTime() - startTime;
		System.out.println("\n\nSelection sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime + "ns.");
		randomize(array);
		System.out.println("\nRandomized Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}

		final long startTime1 = System.nanoTime();
		insertionSort(array, array.length-1);
		final long elapsedTime1 = System.nanoTime() - startTime1;
		System.out.println("\n\nInsertion sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime1 + "ns.");
		randomize(array);
		System.out.println("\nRandomized Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}
        /*
		final long startTime2 = System.nanoTime();
		array = stalinSort(array);
		final long elapsedTime2 = System.nanoTime() - startTime2;
		System.out.println("\n\nStalin sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime2 + "ns.");
        */
		final long startTime3 = System.nanoTime();
		mergeSort(array, array.length-1);
		final long elapsedTime3 = System.nanoTime() - startTime3;
		System.out.println("\n\nMerge sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime3 + "ns.");
		randomize(array);
		System.out.println("\nRandomized Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\n");

		final long startTime4 = System.nanoTime();
		enhancedMergeSort(array, array.length-1);
		final long elapsedTime4 = System.nanoTime() - startTime4;
		System.out.println("Enhanced Merge sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime4 + "ns.");
		randomize(array);
		System.out.println("\nRandomized Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}

		final long startTime5 = System.nanoTime();
		quickSort(array, 0, array.length-1);
		final long elapsedTime5 = System.nanoTime() - startTime5;
		System.out.println("\n\nQuick sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime5 + "ns.");
		randomize(array);
		System.out.println("\nRandomized Array:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\n");

		final long startTime6 = System.nanoTime();
		enhancedQuickSort(array, 0, array.length-1);
		final long elapsedTime6 = System.nanoTime() - startTime6;
		System.out.println("Enhanced Quick sort:");
		for (int element: array) {
			System.out.print(element + " ");
		}
		System.out.println("\nTime taken: " + elapsedTime6 + "ns.");
	}
}
