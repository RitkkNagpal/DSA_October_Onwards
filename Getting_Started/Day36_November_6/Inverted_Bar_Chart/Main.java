import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        printInvertedBarChart(arr);
        scn.close();
    }

    private static void printInvertedBarChart(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] != 0) {
                    System.out.print("*\t");
                    arr[j]--;
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
