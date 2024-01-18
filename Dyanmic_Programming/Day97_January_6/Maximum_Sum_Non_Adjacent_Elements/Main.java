import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = maxSumNonAdjacentElements(arr);
        System.out.println(ans);
        scn.close();
    }

    private static int maxSumNonAdjacentElements(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length; i++) {
            int newInc = exc + arr[i];
            int newExc = Math.max(inc, exc);

            inc = newInc;
            exc = newExc;
        }
        return Math.max(inc, exc);
    }
}
