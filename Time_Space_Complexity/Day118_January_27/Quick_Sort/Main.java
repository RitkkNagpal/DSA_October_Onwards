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
        quickSort(arr, 0, n - 1);
        System.out.println("After Sort");
        display(arr);
        scn.close();
    }

    private static void quickSort(int[] arr, int st, int end) {
        if (st >= end) {
            return;
        }
        int pidx = partion(arr, arr[end], st, end);
        display(arr);
        quickSort(arr, st, pidx - 1);
        quickSort(arr, pidx + 1, end);
    }

    private static int partion(int[] arr, int pivot, int st, int end) {
        int i = st;
        int j = st;
        while (i <= end) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}