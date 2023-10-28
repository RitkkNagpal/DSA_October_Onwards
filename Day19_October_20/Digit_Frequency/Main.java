import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n,d);
        System.out.println(f);
        scn.close();
    }    

    private static int getDigitFrequency(int n, int d) {
        int frq = 0;
        while(n > 0) {
            if(d == n % 10) {
                frq++;
            }
            n /= 10;
        }
        return frq;
    }
}
