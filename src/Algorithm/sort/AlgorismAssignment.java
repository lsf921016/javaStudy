package Algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class AlgorismAssignment {
	public static int[] getSortedCopy(int[] source) {
		int len = source.length;
		if (len == 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; ++i) {
			arr[i] = source[i];
		}
		Arrays.sort(arr);
		return arr;

	}

	public static int[] createRandomArray(int length) {
		int[] arr = new int[length];
		Random random = new Random(10000);
		for (int i = 0; i < length; ++i) {
			arr[i] = random.nextInt();
		}
		return arr;
	}

	public static int[] getReverseCopy(int[] arr) {
		int length = arr.length;
		int i = 0, j = length - 1;
		if (i < 0 || j < 0) {
			return null;
		}
		int[] copy = new int[length];
		for (int k = 0; k < length; ++k) {
			copy[k] = arr[k];
		}
		while (i < j) {
			swap(copy, i, j);
			++i;
			--j;
		}
		return copy;

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
public static double log(double value,double base){
	return Math.log(value)/Math.log(base);
}
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.printf("%d,", arr[i]);
		}
		System.out.println();
	}

	public static void execute(int[] arr) {
		MergeSort merge = new MergeSort(arr);
		merge.boot();
		merge.printInfo();

		HeapSort heap = new HeapSort(arr);
		heap.boot();
		heap.printInfo();

		QuickSort quick = new QuickSort(arr);
		quick.boot();
		quick.printInfo();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public static void execute2(int size) {
		int[] randomArr = createRandomArray(size);
		System.out.printf("%n For %d elements random array:%n", size);
		MergeSort merge = new MergeSort(randomArr);
		merge.boot();
		System.out.println("merge sort:");
		System.out.println("number of comparison: " + merge.compCount);
		System.out.println("time costs:" + merge.time);
		System.out.println("constant factor:"+merge.compCount/(size*log(size,2)));
		System.out.println();

		HeapSort heap = new HeapSort(randomArr);
		heap.boot();
		System.out.println("heap sort:");
		System.out.println("number of comparison: " + heap.compCount);
		System.out.println("time costs:" + heap.time);
		System.out.println("constant factor:"+heap.compCount/(size*log(size,2)));
		System.out.println();

		QuickSort quick = new QuickSort(randomArr);
		quick.boot();
		System.out.println("quickSort:");
		System.out.println("number of comparison: " + quick.compCount);
		System.out.println("time costs:" + quick.time);
		System.out.println("constant factor:"+quick.compCount/(size*log(size,2)));
		System.out.println();

		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("-------------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		int[] randomArr = createRandomArray(32);
		System.out.println("random array:");
		printArr(randomArr);
		int[] sortedArr = getSortedCopy(randomArr);
		System.out.println("sorted array:");
		printArr(sortedArr);
		int[] reverselySortedArr = getReverseCopy(sortedArr);
		System.out.println("reversely sorted array:");
		printArr(reverselySortedArr);

		System.out.printf("%n%n%n%s%n", "For RandomArray:");
		execute(randomArr);

		System.out.printf("%n%n%n%s%n", "For SortedArray:");
		execute(sortedArr);

		System.out.printf("%n%n%n%s%n", "For reverselySortedArray:");
		execute(reverselySortedArr);

		execute2(1 << 5);

	}
}
