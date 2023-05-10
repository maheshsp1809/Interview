package Sorts;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 1000, 5, 4, 3, 2, 1, 8, 9, 100 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            tmp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            tmp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < tmp.length; l++) {
            arr[start + l] = tmp[l];
        }
    }

}
