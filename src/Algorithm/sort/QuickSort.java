package Algorithm.sort;

public class QuickSort extends sort {
	int left = 0, right = 0;

	QuickSort(int[] source) {
		super(source);
		// TODO �Զ����ɵĹ��캯�����
		length = source.length;

	}

	public void boot() {
		long startTime=System.currentTimeMillis();
		left = 0;
		right = length - 1;
		_quickSort(arr, left, right);
		long endTime=System.currentTimeMillis();
		time=endTime-startTime;
	}

	private void _quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int pivot=(left+right)/2;
		swap(arr,pivot,right);
		pivot=partition(arr,left,right);
		_quickSort(arr, left, pivot-1);
		_quickSort(arr, pivot+1, right);
	}

	private int partition(int[] arr, int left, int right) {
		int l=left;
		int r=right;
		int temp=arr[r];
		while(l <= r) {
			while(l <= r &&compare(temp,arr[r])) {
				--r;
			}
			while(l <= r && compare(arr[l] , temp)) {
				++l;
			}
			if(l < r) {
				swap(arr, l, r);
			}
		}
		swap(arr, l, right);
		return l;
	}

}
