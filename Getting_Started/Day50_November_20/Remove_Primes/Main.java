import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());
        }
        removePrimes(list);
        System.out.println(list);
    }

    private static void removePrimes(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            }
        }
    }

    private static boolean isPrime(int ele) {
        for (int div = 2; div * div <= ele; div++) {
            if (ele % div == 0) {
                return false;
            }
        }
        return true;
    }
}