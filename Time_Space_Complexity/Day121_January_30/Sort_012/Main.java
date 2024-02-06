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
        sort012(arr);
        System.out.println("After Sort");
        display(arr);
        scn.close();
    }

    private static void sort012(int[] arr) {
        // 0 -> i - 1 --> region of zeroes
        // i -> j - 1 --> region of ones
        // j -> k - 1 --> region of twos
        // k and above --> unknowns
        int i = 0, j = 0, k = 0;
        while (k < arr.length) {
            int ele = arr[k];
            if (ele == 2) {
                k++;
            } else if (ele == 1) {
                swap(arr, j, k);
                j++;
                k++;
            } else {
                swap(arr, i, k);
                swap(arr, j, k);
                j++;
                k++;
                i++;
            }
        }
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