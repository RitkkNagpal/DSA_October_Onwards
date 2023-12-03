import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        List<String> subSequences = getSS(str);
        System.out.println(subSequences);
        scn.close();
    }

    private static List<String> getSS(String str) {
        if (str.length() == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char currChar = str.charAt(0);
        String remStr = str.substring(1);
        List<String> remainingSubSequences = getSS(remStr);
        List<String> resultSubsequences = new ArrayList<>();

        for (int i = 0; i < remainingSubSequences.size(); i++) {
            resultSubsequences.add(remainingSubSequences.get(i));
        }

        for (int i = 0; i < remainingSubSequences.size(); i++) {
            resultSubsequences.add(currChar + remainingSubSequences.get(i));
        }
        return resultSubsequences;
    }
}
