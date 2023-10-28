import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int val = getValueInBase(n, b);
        System.out.println(val);
        scn.close();
    }

    private static int getValueInBase(int n, int b) {
        int ans = 0;
        int pow = 1;
        while(n > 0) {
            int rem =  n % b;
            n /= b;
            ans = ans+ rem * pow;
            pow = pow * 10;
        }
        return (ans);
    }
}
