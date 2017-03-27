package Algorithm.selection;

import java.util.ArrayList;
import java.util.Random;

public class Selection3 {
	int comparison=0;
	int arr[];
	int n;

	public Selection3(int[] arr) {
		this.n=arr.length;
		this.arr=new int[n];
		for (int i = 0; i < n; i++) {
			this.arr[i]=arr[i];
		}
	}

	public int select(int k) {
		if(k>n){
			return -1;
		}
		if(n==1){
			return arr[0];
		}
		int left=0;
		int right=n-1;
		if (n < 25) {
			insertionSort(arr);
			return arr[k - 1];
		}
		
		return quickSelect(arr,k);

	}

	private int quickSelect(int[] arr,int k) {
		int n=arr.length;
		if(k>n){
			return -1;
		}
		if(n==1){
			return arr[0];
		}
		if (n < 25) {
			insertionSort(arr);
			return arr[k - 1];
		}
		int pivotIndex=findPivot(arr, 0, n-1);
		int pivot=arr[pivotIndex];
		ArrayList<Integer> less=new ArrayList<>();
		ArrayList<Integer> equal=new ArrayList<>();
		ArrayList<Integer> greater=new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if(compare(arr[i], pivot)){
				less.add(arr[i]);
			}
			else if(compare(pivot, arr[i])){
				greater.add(arr[i]);
			}
			else{
				equal.add(arr[i]);
			}
		}
		int l=less.size();
		int e=equal.size();
		int r=greater.size();
		if(k<l){
			int[] a=new int[less.size()];
			for(int i=0;i<less.size();++i){
				a[i]=less.get(i);
			}
			return quickSelect(a,k);
		}
		else if(k>l){
			int[] a=new int[greater.size()];
			for(int i=0;i<greater.size();++i){
				a[i]=greater.get(i);
			}
			return quickSelect(a,k-l-e);
		}
		else{
			return pivot;
		}		
	}
	private int findPivot(int[] arr, int left, int right) {
		int n = arr.length;
		if (right - left + 1 <= 5) {
			insertionSort(arr, left, right);
			return (left + right) / 2;
		}
		int cursor=left-1;
		for (int i = left; i <= right; i += 5) {
			int end = i + 4 < n ? i + 4 : n - 1;
			insertionSort(arr, i, end);
			int median=(i+end)/2;
			swap(arr, ++cursor, median);
			
		}
		return findPivot(arr, left, cursor);
	}

	private void insertionSort(int[] arr, int left, int right) {
		int temp;
		for (int i = 1 + left; i <= right; ++i) {
			temp = arr[i];
			int j = i - 1;
			for (; j >= 0 && compare(temp, arr[j]); j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}

	private void insertionSort(int [] arr) {
		int temp;
		for (int i = 1; i < arr.length; ++i) {
			temp = arr[i];
			int j = i - 1;
			for (; j >= 0 && compare(temp, arr[j]); j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public boolean compare(int a, int b) {
		comparison++;
		return a < b;
	}
	
}
