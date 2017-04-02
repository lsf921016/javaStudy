package Algorithm.selection;
import java.util.Arrays;

public class Selectx3 {
	private static int compcount;

	public static int select3(int[] arr, int n, int k) {
		if (n==1){
			return arr[0];
		}
		if (n < 25) {
			insertionSort(arr, 0, n - 1);
			return arr[k - 1];
		} else {
			return select(arr, 0, n - 1, k);
		}
	}

	private static int select(int[] arr, int start, int end, int k) {
		if (end <= start) {
			return arr[start];
		}
		int v = findMedian(arr, start, end);
		int lt = start;
		int gt = end;
		int i = start;
		while (i <= gt) {
			int comp = compare(v, arr[i]);
			if (comp == 1) {
				swap(arr, lt, i);
				lt++;
				i++;
			} else if (comp == 0) {
				i++;
			} else {
				swap(arr, i, gt);
				gt--;
			}
		}
		if (k <= lt - start) {
			return select(arr, start, lt - 1, k);
		} else if (k <= gt + 1 - start) {
			return arr[lt];
		} else {
			return select(arr, gt + 1, end, k + start - gt - 1);
		}
	}

	private static int findMedian(int[] arr, int start, int end) {
		if (start == end || start + 1 == end) {
			return arr[start];
		}
		int i = start;
		int j = start;
		while (i <= end) {
			if (end - i == 3) {//do i need comparison here? to do docuemnt
				insertionSort(arr, i, end);
				swap(arr, i + 2, j);
			} else if (end - i == 2) {
				insertionSort(arr, i, end);
				swap(arr, i + 1, j);
			} else if (end - i == 1) {
				insertionSort(arr, i, end);
				swap(arr, i, j);
			} else if (i == end) {
				swap(arr, i, j);
			} else {
				insertionSort(arr, i, i + 4);
				swap(arr, i + 2, j);
			}
			i = i + 5;
			j++;
		}
		return findMedian(arr, start, start + (int) Math.ceil((end - start + 1) * 1.0 / 5 * 1.0));
	}

	public static void insertionSort(int[] arr, int l, int r) {
		for (int i = l + 1; i < r + 1; i++) {
			int j = i;
			while (j > l && compare(arr[j], arr[j - 1]) == -1) {
				swap(arr, j, j - 1);
				j = j - 1;
			}
		}
	}

	public static int compare(int a, int b) {
		compcount++;
		if (a > b) {
			return 1;
		} else if (a == b) {
			return 0;
		} else {
			return -1;
		}
	}

	public static int getCount() {
		return compcount;
	}

	public static void clearCount() {
		compcount = 0;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int [] arr=Util.createRandomArray(10000);
		System.out.println(Selectx3.select3(arr,arr.length,arr.length/2)+"小雅的代码比较次数："+compcount);
	}
}
