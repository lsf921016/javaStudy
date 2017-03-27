package Algorithm.selection;

import java.util.Random;

public class Util {
	public static int[] createRandomArray(int length) {
		int[] arr = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; ++i) {
			arr[i] = random.nextInt();
		}
		return arr;
	}

	public static void printArr(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			System.out.printf("%d,", array[i]);
		}
		System.out.println();
	}
}
