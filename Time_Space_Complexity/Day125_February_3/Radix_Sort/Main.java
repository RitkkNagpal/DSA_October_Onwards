import java.util.Scanner;

/**
 * Main
 */
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
        int[] sortedArr = radixSort(arr);
        System.out.println("After Sort");
        display(sortedArr);
        scn.close();
    }

    private static int[] radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int exp = 1;
        int[] sortedArr = arr;
        while (exp <= max) {
            sortedArr = countSort(sortedArr, exp);
            exp = exp * 10;
        }
        return sortedArr;
    }

    private static int[] countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] ansArray = new int[n];
        int[] farr = new int[10]; // since digit are from 0-9 -> we are sorting based on last digit
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i] / exp % 10]++; // 235 -> sorting on basis of last digit -> 235/1 = 235 -> 235 % 10 = 5
        }

        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            int pos = farr[ele / exp % 10] - 1;
            ansArray[pos] = ele;
            farr[ele / exp % 10]--;
        }
        return ansArray;
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}