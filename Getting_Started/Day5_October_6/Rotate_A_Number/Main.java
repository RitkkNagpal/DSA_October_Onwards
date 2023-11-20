import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextLong();
        long k = scn.nextInt();
        long rotatedNumber = rotateNumber(num, k);
        System.out.println(rotatedNumber);
        scn.close();
    }

    private static long rotateNumber(long num, long k) {
        int digitCount = countDigits(num);
        if (k == 0) {
            return num;
        }
        if (k > digitCount) {
            k = k % digitCount;
        }
        if (k < 0) {
            k += digitCount;
        }
        long pow =((Double)Math.pow(10, k)).longValue();
        long rightPart = num % (pow);
        long leftPart = num / pow;

        return rightPart * ((Double)Math.pow(10, digitCount-k)).longValue() + leftPart;
    }

    private static int countDigits(long num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
