import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int idx = firstIndex(arr, 0, x);
        if (idx != -1) {
            System.out.println("Element found at index: " + idx);
        } else {
            System.out.println("Element not found");
        }
        scn.close();
    }

    private static int firstIndex(int[] arr, int idx, int target) {
        if (idx == arr.length)
            return -1;

        if (arr[idx] == target) {
            return idx;
        }
        return firstIndex(arr, idx + 1, target);
    }
}