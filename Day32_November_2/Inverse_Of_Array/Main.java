import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = inverseOfArray(arr);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

    private static int[] inverseOfArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            res[val] = i;
        }

        return res;
    }
}
