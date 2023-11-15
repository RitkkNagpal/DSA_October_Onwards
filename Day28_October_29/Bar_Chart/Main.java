import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        printBarChart(arr);
        scn.close();
    }

    private static void printBarChart(int[] arr) {
        int n = arr.length;
        int max = findMax(arr);
        for (int i = 0; i < max; i++) {
            int temp = max - i;
            for (int j = 0; j < n; j++) {
                if (temp - arr[j] <= 0) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max) {
                max = ele;
            }
        }
        return max;
    }
}
