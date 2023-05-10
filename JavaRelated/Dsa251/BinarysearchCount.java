package Dsa251;

public class BinarysearchCount {
    static int findKRotation(int arr[], int n) {
        // code here
        int low = 0, high = n - 1;

        while (low <= high) {
            if (arr[low] <= arr[high]) {
                return low; // The array is not rotated
            }

            int mid = (low + high) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // Found the index of smallest element
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1; // Search in the left half
            } else if (arr[mid] >= arr[low]) {
                low = mid + 1; // Search in the right half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myArray = { 66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17,
                26, 30, 36, 38, 46, 52, 60 };
        int ans = findKRotation(myArray, 28);
        System.out.println(ans);
    }

}
