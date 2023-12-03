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
        displayArrayInInverse(arr, 0);
        scn.close();
    }

    private static void displayArrayInInverse(int[] arr, int idx) {
        if (idx == arr.length - 1)
            return;
        displayArrayInInverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }
}