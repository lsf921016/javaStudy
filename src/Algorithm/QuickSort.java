package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2017/3/19.
 */
public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
            System.out.print(list.get(i)+",");
        }
        System.out.println("------------------------");
        int left = 0;
        int right = list.size()-1;
        qSort(list, left, right);
        for (int i : list) {
            System.out.print(i + ",");
        }
    }

    public static void qSort(List<Integer> list, int left, int right) {
        if (left >= right)
            return;
        int pivot = (left + right) / 2;
        swap(list, pivot, right);
        pivot=partition(list,left,right);
        qSort(list,left,pivot-1);
        qSort(list,pivot+1,right);
    }

    private static int partition(List<Integer> list, int left, int right) {
        int temp=list.get(right);
        int tempIndex=right;
        while(left<=right){
            while(left<=right&&temp<=list.get(right)){
                --right;
            }
            while ((left<=right&&temp>=list.get(left))){
                ++left;
            }
            if(left<right){
                swap(list,left,right);
            }
        }
        swap(list,left,tempIndex);
        return left;
    }

    static void swap(List<Integer> list, int index1, int index2) {
        int num1=list.get(index1);
        int num2=list.get(index2);
        list.set(index1,num2);
        list.set(index2,num1);
    }
}
