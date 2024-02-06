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
        int k = scn.nextInt();
        int ans = quickSelect(arr, k, 0, n - 1);
        System.out.println(ans);
        scn.close();
    }

    private static int quickSelect(int[] arr, int k, int st, int end) {
        int pidx = partion(arr, st, end, arr[end]);
        if (pidx == k - 1) {
            return arr[pidx];
        }
        if (pidx > k - 1) {
            return quickSelect(arr, k, st, pidx - 1);
        } else {
            return quickSelect(arr, k, pidx + 1, end);
        }
    }

    private static int partion(int[] arr, int st, int end, int pivot) {
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

}