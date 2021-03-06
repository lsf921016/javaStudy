package Algorithm.selection;

public class Selection3 {
    int comparison = 0;
    int array[];

    public Selection3(int[] arr) {
        this.array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.array[i] = arr[i];
        }
    }

    public int select(int k) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length < 25) {
            insertionSort(array);
            return array[k - 1];
        }
        return quickSelect(array, k, 0, array.length - 1);

    }

    private int quickSelect(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return arr[left];
        }
        int pivot = findPivot(arr, left, right);
        int l = left;
        int g = right;
        int i = left;
        while (i <= g) {
            int comp = compareTo(arr[i], pivot);
            if (comp < 0) {
                swap(arr, l++, i++);
            } else if (comp == 0) {
                ++i;
            } else {
                swap(arr, i, g--);
            }
        }
        if (k <= l - left) {
            return quickSelect(arr, k, left, l - 1);
        } else if (k <= g + 1 - left) {
            return arr[l];
        } else {
            return quickSelect(arr, k + left - g - 1, g + 1, right);
        }

    }

    private int findPivot(int[] arr, int left, int right) {
        if (right - left <= 4) {
            insertionSort(arr, left, right);
            return arr[(left + right) / 2];
        }
        int cursor = left - 1;
        for (int i = left; i <= right; i += 5) {
            int end = i + 4 <= right ? i + 4 : right;
            insertionSort(arr, i, end);
            int median = (i + end) / 2;
            swap(arr, ++cursor, median);
        }
        return findPivot(arr, left, cursor);
    }

    private void insertionSort(int[] arr, int left, int right) {
        int temp;
        for (int i = 1 + left; i <= right; ++i) {
            temp = arr[i];
            int j = i - 1;
            for (; j >= left && compare(temp, arr[j]); j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    private void insertionSort(int[] arr) {
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

    public int compareTo(int a, int b) {
        ++comparison;
        if (a < b)
            return -1;
        else if (a > b)
            return 1;
        else
            return 0;

    }

}
