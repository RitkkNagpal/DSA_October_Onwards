import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long ans = arrangeBuildings(n);
        System.out.println(ans);
        scn.close();
    }

    private static long arrangeBuildings(int n) {
        int buildingAtEnd = 1;
        int spaceAtEnd = 1;
        for (int i = 2; i <= n; i++) {
            int numbWaysNextBuildingPlaced = spaceAtEnd;
            int numbWaysNextSpacePlaced = spaceAtEnd + buildingAtEnd;

            buildingAtEnd = numbWaysNextBuildingPlaced;
            spaceAtEnd = numbWaysNextSpacePlaced;
        }
        int waysBuildingsPlacedInOneLine = buildingAtEnd + spaceAtEnd;
        return waysBuildingsPlacedInOneLine * waysBuildingsPlacedInOneLine;
    }
}
