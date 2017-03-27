package Algorithm.sort;

import java.util.Random;

public class sort {
	public int compCount = 0;
	public int arr[];
	public long time=0;
	public int length=0;

	sort(int[] source) {
		length=source.length;
		arr = new int[length];
		for (int i = 0; i < length; ++i) {
			arr[i] = source[i];
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp=0;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	public boolean compare(int a, int b) {
		++compCount;
		return a <= b;
	}
	public void boot(){
		return;
	}

	public int getCompCount(){
		return compCount;
	}
	public long getTime(){
		return time;
	}
	public int[] getArr(){
		return arr;
	}
	public void printArr() {
		for (int i = 0; i < length; ++i) {
			System.out.printf("%d,", arr[i]);
		}
		System.out.println();
	}
	public void printInfo(){
		System.out.println();
		System.out.println(getClass()+":");
		System.out.println("number of comparisons:"+compCount);
		System.out.print("sorted array: ");
		for (int i = 0; i < length; ++i) {
			System.out.printf("%d,", arr[i]);
		}
		System.out.println();
		
	}
}
