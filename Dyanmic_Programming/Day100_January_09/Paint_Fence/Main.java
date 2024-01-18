
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long waysToPaintFences = paintFences(n, k);
        System.out.println(waysToPaintFences);
        scn.close();
    }

    private static long paintFences(int n, int k) {
        long endingTwoFencesSameColor = k;
        long endingTwoFencesDifferentColor = k * (k - 1);
        for (int i = 2; i < n; i++) {
            long nextFenceWaysEndingSameColor = endingTwoFencesDifferentColor;
            long nextFenceWaysEndingDifferentColor = (k - 1)
                    * (endingTwoFencesSameColor + endingTwoFencesDifferentColor);

            endingTwoFencesSameColor = nextFenceWaysEndingSameColor;
            endingTwoFencesDifferentColor = nextFenceWaysEndingDifferentColor;
        }
        return endingTwoFencesSameColor + endingTwoFencesDifferentColor;
    }
}
