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
        int idx = findElementInArray(arr, ele);
        System.out.println(idx);
        scn.close();
    }

    private static int findElementInArray(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }
}