import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPath(n, "");
        scn.close();
    }

    private static void printStairPath(int n, String ans) {
        if (n <= 0) {
            if (n == 0) {
                System.out.println(ans);
            }
            return;
        }

        printStairPath(n - 1, ans + "1");
        printStairPath(n - 2, ans + "2");
        printStairPath(n - 3, ans + "3");
    }
}
