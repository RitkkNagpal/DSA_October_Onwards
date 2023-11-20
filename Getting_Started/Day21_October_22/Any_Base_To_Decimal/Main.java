import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int val = anyBaseToDecimal(n, b);
        System.out.println(val);
        scn.close();
    }    

    private static int anyBaseToDecimal(int n, int b) {
        int ans = 0;
        int pow = 1;
        while(n > 0) {
            int ld = n % 10;
            ans += ld*pow;
            pow *= b;
            n /= 10;
        }

        return ans;
    }
}
