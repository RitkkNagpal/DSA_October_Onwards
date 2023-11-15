import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ele = scn.nextInt();
        printFirstIndexAndLastIndex(arr, ele);
        scn.close();
    }

    private static void printFirstIndexAndLastIndex(int[] arr, int ele) {
        int left = 0;
        int right = arr.length - 1;
        int firstIdx = -1;
        int lastIdx = -1;
        // searching first index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 1 1 1 1 2 3 4 5 6 7
            if (arr[mid] >= ele) {
                if (arr[mid] == ele) {
                    firstIdx = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = arr.length - 1;
        
        // searching last index
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= ele) {
                if (arr[mid] == ele) {
                    lastIdx = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (firstIdx != -1) {
            System.out.println("Element Found");
            System.out.println("First Index: " + firstIdx);
            System.out.println("Last Index:  " + lastIdx);
        } else {
            System.out.println("Element Not Found");
        }
    }
}
