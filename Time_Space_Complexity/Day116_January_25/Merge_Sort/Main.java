import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Before Sort");
        display(arr);
        int[] sortedArray = mergeSort(arr, 0, arr.length - 1);
        System.out.println("After Sort");
        display(sortedArray);
        scn.close();
    }

    // 3 2 1

    private static int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[] { arr[left] };
        }
        int mid = left + ((right - left) / 2);
        int[] leftArr = mergeSort(arr, left, mid);
        int[] rightArr = mergeSort(arr, mid + 1, right);
        return mergeTwoSortedArrays(leftArr, rightArr);
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    private static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArray = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i++];
            } else {
                mergedArray[k] = arr2[j++];
            }
            k++;
        }

        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}