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
        int[] sortedArr = countSort(arr);
        System.out.println("After Sort");
        display(sortedArr);
        scn.close();
    }

    private static int[] countSort(int[] arr) {
        int n = arr.length;
        int[] sortedArray = new int[n];
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int[] farr = new int[max - min + 1];
        for (int ele : arr) {
            farr[ele - min]++;
        }
        // convert to prefix sum arr
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        // travel in reverse and fill up sorted array
        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            sortedArray[farr[ele - min] - 1] = ele;
            farr[ele - min]--;
        }
        return sortedArray;
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}