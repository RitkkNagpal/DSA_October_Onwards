import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dates = new int[n];
        for (int i = 0; i < n; i++) {
            dates[i] = scn.nextInt();
        }
        System.out.println("Before Sort");
        display(dates);
        sortDates(dates);
        System.out.println("After Sort");
        display(dates);
        scn.close();
    }

    private static void sortDates(int[] dates) {
        countSort(dates, 30, 1000000, 100); // days
        countSort(dates, 12, 10000, 100); // months
        countSort(dates, 9999, 1, 10000); // years
    }

    private static void countSort(int[] dates, int range, int div, int mod) {
        int n = dates.length;
        int[] ansArray = new int[dates.length];
        int[] farr = new int[range + 1];
        for (int i = 0; i < n; i++) {
            int ele = dates[i];
            farr[ele / div % mod]++;
        }

        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int pos = farr[dates[i] / div % mod] - 1;
            ansArray[pos] = dates[i];
            farr[dates[i] / div % mod]--;
        }

        // fill orignal arr
        for (int i = 0; i < n; i++) {
            dates[i] = ansArray[i];
        }

        // 12062000
        // 12062000/1000000%100=12
        // 12062000/10000%100=06
        // 12062000/1%10000=2000
    }

    private static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}