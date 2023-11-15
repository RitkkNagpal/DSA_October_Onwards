import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int r = scn.nextInt();
        rotateArray(arr, r);
        display(arr);
        scn.close();
    }

    private static void display(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + "\t");
        }
    }

    private static void rotateArray(int[] arr, int r) {
        if (r > arr.length) {
            r = r % arr.length;
        }
        if (r == 0) {
            return;
        }

        if (r < 0) {
            r += arr.length;
        }

        reverse(arr, 0, arr.length - r - 1);
        reverse(arr, arr.length - r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
