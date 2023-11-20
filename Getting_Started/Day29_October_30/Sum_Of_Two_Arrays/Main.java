import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        int[] res = sumOfTwoArrays(arr1, arr2);
        int i = 0;
        // skip leading zeroes
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        scn.close();
    }

    private static int[] sumOfTwoArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] res = new int[Math.max(n1, n2) + 1];
        int carry = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        int k = res.length - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int val1 = i >= 0 ? arr1[i] : 0;
            int val2 = j >= 0 ? arr2[j] : 0;

            res[k] = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;

            i--;
            j--;
            k--;
        }
        return res;
    }
}
