import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int max = findMax(arr, 0);
        System.out.println("Max: " + max);
        scn.close();
    }

    private static int findMax(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int restMax = findMax(arr, idx + 1);
        if (arr[idx] > restMax) {
            return arr[idx];
        }
        return restMax;
    }
}
