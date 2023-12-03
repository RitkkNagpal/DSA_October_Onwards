import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int[] indices = allIndices(arr, tar, 0, 0);
        if (indices.length == 0)
            System.out.println("Element not found");
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
        scn.close();
    }

    private static int[] allIndices(int[] arr, int tar, int idx, int count) {
        if (idx == arr.length) {
            return new int[count];
        }

        int[] indicesFromRestOfArray = null;
        if (arr[idx] == tar) {
            count++;
            indicesFromRestOfArray = allIndices(arr, tar, idx + 1, count);
            indicesFromRestOfArray[count - 1] = idx;
            return indicesFromRestOfArray;
        } else {
            return allIndices(arr, tar, idx + 1, count);
        }
    }
}
