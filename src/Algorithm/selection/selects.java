package CS610;

class Selects {
	static int counter = 0;

	public static void main(String[] args) {

		int n1 = 10000;
		int n2 = 100000;
		int n3 = 1000000;

		int[] a1 = new int[n1];
		for (int j = 0; j < a1.length; j++)
			a1[j] = (int) (n1 * 200 * Math.random());
		int[] b1 = a1.clone();
		int[] c1 = a1.clone();
		Select1(a1, n1, n1 >> 1);
		Select2(b1, b1.length, n1 >> 1);
		Select3(c1, c1.length, n1 >> 1);
		System.out.println();

		int[] a2 = new int[n2];
		for (int j = 0; j < a2.length; j++)
			a2[j] = (int) (n2 * 200 * Math.random());
		int[] b2 = a2.clone();
		int[] c2 = a2.clone();
		Select1(a2, n2, n2 >> 1);
		Select2(b2, b2.length, n2 >> 1);
		Select3(c2, c2.length, n2 >> 1);
		System.out.println();

		int[] a3 = new int[n3];
		for (int j = 0; j < a3.length; j++)
			a3[j] = (int) (n3 * 200 * Math.random());
		int[] b3 = a3.clone();
		int[] c3 = a3.clone();
		Select1(a3, n3, n3 >> 1);
		Select2(b3, b3.length, n3 >> 1);
		Select3(c3, c3.length, n3 >> 1);
		System.out.println();

	}

	static void Select1(int[] a, int n, int k) {
		counter = 0;
		quicksort(a, 0, a.length - 1);
		System.out.format("Select1: n = %7d, k = %7d, a[k] = %8d, %9d comparisons.\n", a.length, k, a[k], counter);
	}

	static void Select2(int[] a, int n, int k) {
		counter = 0;
		int left = 0;
		int right = n - 1;
		randomPivotSelect(a, left, right, k);
		System.out.format("Select2: n = %7d, k = %7d, a[k] = %8d, %9d comparisons.\n", a.length, k, a[k], counter);
	}

	static void Select3(int[] a, int n, int k) {
		counter = 0;
		int left = 0;
		int right = n - 1;
		goodPivotSelect(a, left, right, k);
		System.out.format("Select3: n = %7d, k = %7d, a[k] = %8d, %9d comparisons.\n", a.length, k, a[k], counter);
	}

	static int randomPivotSelect(int[] a, int left, int right, int k) {
		if (right - left + 1 <= 25) {
			insertionSort(a, left, right);
			return a[k];
		} else {
			int vIndex = left + (int) ((right - left) * Math.random());
			int pivot = a[vIndex];
			elementSwap(a, left, vIndex);
			int n1 = partition(a, left, right, pivot);
			if (k <= n1) {
				return randomPivotSelect(a, left, n1 - 1, k);
			}
			int n2 = partition(a, n1, right, pivot + 1);
			if (k <= n2) {
				return pivot;
			} else {
				return randomPivotSelect(a, n2, right, k);
			}
		}
	}

	static int goodPivotSelect(int[] a, int left, int right, int k) {
		if (right - left + 1 <= 25) {
			insertionSort(a, left, right);
			return a[k];
		} else {
			int pivot = findGoodPivot(a, left, right);
			int n1 = partition(a, left, right, pivot);
			if (k <= n1)
				return goodPivotSelect(a, left, n1 - 1, k);
			int n2 = partition(a, n1, right, pivot + 1);
			if (k <= n2) {
				return pivot;
			} else {
				return goodPivotSelect(a, n2, right, k);
			}
		}
	}

	/*
	 * partition moves elements less than the pivot to the left part and put the
	 * leftmost elements behind them.
	 */
	static int partition(int[] a, int left, int right, int pivot) {
		int frwrdIndex = left + 1;
		int bkwrdIndex = right;

		while (frwrdIndex <= bkwrdIndex) {
			while (frwrdIndex <= bkwrdIndex && compare(a[frwrdIndex], pivot))
				++frwrdIndex;
			while (frwrdIndex <= bkwrdIndex && !compare(a[bkwrdIndex], pivot))
				--bkwrdIndex;
			if (frwrdIndex < bkwrdIndex) {
				elementSwap(a, frwrdIndex, bkwrdIndex);
				++frwrdIndex;
				--bkwrdIndex;
			}
		}
		elementSwap(a, left, bkwrdIndex);
		return bkwrdIndex;
	}

	static void quicksort(int[] a, int left, int right) {
		if (left >= right)
			return;
		int vIndex = left + (int) ((right - left) * Math.random());
		int pivot = a[vIndex];
		elementSwap(a, left, vIndex);
		int bkwrdIndex = partition(a, left, right, pivot);
		quicksort(a, left, bkwrdIndex - 1);
		quicksort(a, bkwrdIndex + 1, right);
	}

	static int findGoodPivot(int[] a, int left, int right) {
		int i = left;
		int j = left;
		while (j + 5 <= right) {
			insertionSort(a, j, j + 4);
			elementSwap(a, i, j + 2);
			++i;
			j += 5;
		}
		if (j < right)
			insertionSort(a, j, right);
		elementSwap(a, i, j + ((right - j) >> 1));
		++i;
		goodPivotSelect(a, left, i - 1, left + (i - left) >> 1);
		elementSwap(a, left, left + ((i - left) >> 1));
		return a[left];
	}

	static void elementSwap(int[] a, int m, int n) {
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}

	static void printArray(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}

	static boolean compare(int a, int b) {
		++counter;
		return a < b ? true : false;
	}

	static void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; ++i) {
			for (int j = i; j > left; --j) {
				if (compare(a[j], a[j - 1]))
					elementSwap(a, j, j - 1);
				else
					break;
			}
		}
	}

}