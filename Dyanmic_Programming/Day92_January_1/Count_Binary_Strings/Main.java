import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = countBinaryStrings(n);
        System.out.println(ans);
        scn.close();
    }

    private static int countBinaryStrings(int n) {
        int countStringsEndingAt0 = 1;
        int countStringsEndingAt1 = 1;
        for (int i = 2; i <= n; i++) {
            int nextCountStringsEndingAt0 = countStringsEndingAt1;
            int nextCountStringsEndingAt1 = countStringsEndingAt0 + countStringsEndingAt1;
            countStringsEndingAt0 = nextCountStringsEndingAt0;
            countStringsEndingAt1 = nextCountStringsEndingAt1;
        }
        return countStringsEndingAt0 + countStringsEndingAt1;
    }
}
