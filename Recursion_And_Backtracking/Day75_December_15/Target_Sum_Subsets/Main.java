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
        printTargetSumSubset(arr, 0, "", 0, tar);
        scn.close();
    }

    private static void printTargetSumSubset(int[] arr, int i, String set, int sum, int tar) {
        if (i == arr.length) {
            if (sum == tar) {
                System.out.println(set + ".");
            }
            return;
        }
        printTargetSumSubset(arr, i + 1, set + arr[i] + ",", sum + arr[i], tar);
        printTargetSumSubset(arr, i + 1, set, sum, tar);
    }
}
