package Algorithm.selection;

public class Selection1 {
	public int comparison;
	int [] arr;
	int n;
	public Selection1(int[] arr) {
		this.n=arr.length;
		this.arr=new int[n];
		for (int i = 0; i < n; i++) {
			this.arr[i]=arr[i];
		}
	}
	
	public int select(int k) {
		if (k>n) {
			return -1;
		}
		int left = 0;
		int right = n-1;
		quickSort(arr, left, right);
		return arr[k-1];
	}

	public void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		int pivotIndex = (left + right) / 2;
		swap(array, pivotIndex, right);
		pivotIndex = partition(array, left, right);
		quickSort(array, left, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, right);
	}

	public int partition(int[] array, int left, int right) {
		int l = left;
		int r = right;
		int temp = array[r];
		while (l <= r) {
			while (l <= r && compare(temp, array[r])) {
				--r;
			}
			while (l <= r && compare(array[l], temp)) {
				++l;
			}	
			if (l < r) {
				swap(array, l, r);
			}
		}
		swap(array, l, right);
		return l;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public boolean compare(int a, int b) {
		comparison++;
		return a <= b;
	}


}
