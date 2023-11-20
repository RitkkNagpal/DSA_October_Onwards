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

        int[] res;
        res = differenceOfTwoArrays(arr2, arr1);
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        scn.close();
    }

    private static int[] differenceOfTwoArrays(int[] arr1, int[] arr2) {
        int[] res = new int[Math.max(arr1.length, arr2.length)];
        int borrow = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = res.length - 1;
        while (i >= 0) {
            int val1 = (i >= 0) ? arr1[i] : 0;
            int val2 = (j >= 0) ? arr2[j] : 0;

            int val = val1 - val2 + borrow;
            if (val < 0) {
                val += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            res[k] = val;
            i--;
            j--;
            k--;
        }
        return res;
    }
}
