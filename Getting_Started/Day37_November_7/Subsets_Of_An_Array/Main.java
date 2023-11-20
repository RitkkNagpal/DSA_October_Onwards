import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        printSubsets(arr);
        scn.close();
    }

    private static void printSubsets(int[] arr) {
        int n = arr.length;
        int totalSubsets = (int) (Math.pow(2, n));
        for (int i = 0; i < totalSubsets; i++) {
            int[] bin = getBinaryEquivalent(i, n);
            for (int j = 0; j < bin.length; j++) {
                if (bin[j] == 0) {
                    System.out.print("-\t");
                } else {
                    System.out.print(arr[j] + "\t");
                }
            }
            System.out.println();
        }
    }

    private static int[] getBinaryEquivalent(int n, int len) {
        int[] bin = new int[len];
        int idx = bin.length - 1;
        while (n > 0) {
            bin[idx--] = n % 2;
            n /= 2;
        }
        return bin;
    }
}
