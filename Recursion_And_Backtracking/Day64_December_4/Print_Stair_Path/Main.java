import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<String> paths = printStairPath(n);
        System.out.println(paths);
        scn.close();
    }

    private static List<String> printStairPath(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        if (n == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> nm1Paths = printStairPath(n - 1);
        List<String> nm2Paths = printStairPath(n - 2);
        List<String> nm3Paths = printStairPath(n - 3);
        List<String> resultPaths = new ArrayList<>();
        for (String path : nm1Paths) {
            resultPaths.add("1" + path);
        }
        for (String path : nm2Paths) {
            resultPaths.add("2" + path);
        }
        for (String path : nm3Paths) {
            resultPaths.add("3" + path);
        }
        return resultPaths;
    }
}
