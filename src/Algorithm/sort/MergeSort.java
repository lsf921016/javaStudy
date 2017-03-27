package Algorithm.sort;

public class MergeSort extends sort {

	MergeSort(int[] source) {
		super(source);
		// TODO �Զ����ɵĹ��캯�����
	}

	public void boot() {
		long startTime = System.currentTimeMillis();
		int[] tempArr = new int[length];
		int left = 0;
		int right = length - 1;
		_mergeSort(arr, tempArr, left, right);
		long endTime = System.currentTimeMillis();
		time = endTime - startTime;
	}

	private void _mergeSort(int[] arr, int[] tempArr, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		_mergeSort(arr, tempArr, left, mid);
		_mergeSort(arr, tempArr, mid + 1, right);
		merge(arr, tempArr, left, right, mid);

	}

	private void merge(int[] arr, int[] tempArr, int left, int right, int mid) {
		int index1 = left;
		int index2 = mid + 1;
		for (int i = left; i <= right; ++i) {
			tempArr[i] = arr[i];
		}
		int i = left;
		while (index1 <= mid && index2 <= right) {
			if (compare(tempArr[index1], tempArr[index2])) {
				arr[i++] = tempArr[index1++];
			} else {
				arr[i++] = tempArr[index2++];
			}
		}
		while (index1 <= mid) {
			arr[i++] = tempArr[index1++];
		}
		while (index2 <= right) {
			arr[i++] = tempArr[index2++];
		}
	}

}
