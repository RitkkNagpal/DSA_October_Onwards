import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str);
        scn.close();
    }

    private static void printPermutations(String str) {
        int totalPermutations = factorial(str.length());
        for (int i = 0; i < totalPermutations; i++) {
            int div = str.length();
            StringBuilder s = new StringBuilder(str);
            int temp = i;
            while (div > 0) {
                int idx = temp % div;
                temp /= div;
                div--;
                System.out.print(s.charAt(idx));
                s.deleteCharAt(idx);
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact = fact * i;
        }
        return fact;
    }
}
