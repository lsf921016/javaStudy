package Algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.json.JSONArray;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Algorithm.selection.Selection3.swap;

/**
 * Created by lenovo on 2017/3/23.
 */
public class Sort {
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11};
//        quicksort(a,0,a.length-1);
        int[] temArr = new int[arr.length];
        mergesort(arr, temArr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    private static void mergesort(int[] arr, int[] tempArr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergesort(arr, tempArr, left, mid);
        mergesort(arr, tempArr, mid + 1, right);
        merge(arr, tempArr, left, right, mid);
    }

    private static void merge(int[] arr, int[] tempArr, int left, int right, int mid) {
        for (int i = left; i <= right; i++) {
            tempArr[i] = arr[i];
        }
        int cursor = left;
        int index1 = left;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= right) {
            if (tempArr[index1] <= tempArr[index2]) {
                arr[cursor++] = tempArr[index1++];
            } else {
                arr[cursor++] = tempArr[index2++];
            }
        }
        while (index1 <= mid) {
            arr[cursor++] = tempArr[index1++];
        }
        while (index2 <= right) {
            arr[cursor++] = tempArr[index2++];
        }
    }


    private static void quicksort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotIndex = (left + right) / 2;
        swap(arr, pivotIndex, right);
        pivotIndex = partition(arr, left, right);
        quicksort(arr, left, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int l = left;
        int r = right;
        while (l <= r) {
            while (l <= r && arr[l] <= pivot) {
                ++l;
            }
            while (l <= r && arr[r] >= pivot) {
                --r;
            }
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, l, right);
        return l;
    }
}
