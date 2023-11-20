import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        for (int num = low; num <= high; num++) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int div = 2; div * div <= num; div++) {
            if (num % div == 0) {
                return false;
            }
        }
        return true;
    }
}