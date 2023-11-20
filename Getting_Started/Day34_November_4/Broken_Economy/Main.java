import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();
        brokenEconomy(arr, ele);
        scn.close();
    }

    private static void brokenEconomy(int[] arr, int ele) {
        int left = 0;
        int right = arr.length;
        int idx = -1;
        int floor = Integer.MAX_VALUE;
        int ceil = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == ele) {
                idx = mid;
                break;
            } else if (arr[mid] > ele) {
                right = mid - 1;
                ceil = arr[mid];
            } else if (arr[mid] < ele) {
                left = mid + 1;
                floor = arr[mid];
            }
        }
        if (idx != -1) {
            System.out.println("Element Found - " + arr[idx]);
        } else {
            System.out.println("Floor: " + floor);
            System.out.println("Ceil: " + ceil);
        }
    }
}
