import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        targetSumPairs(arr, tar);
        scn.close();
    }

    private static void targetSumPairs(int[] arr, int tar) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == tar) {
                System.out.println(arr[i] + " " + arr[j]);
                i++;
                j--;
            } else if (arr[i] + arr[j] > tar) {
                j--;
            } else {
                i++;
            }
        }
    }
}