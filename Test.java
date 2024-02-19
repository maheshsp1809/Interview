import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
        int minPlatforms = findMinPlatforms(arrival, departure);
        System.out.println("Minimum number of platforms required: " + minPlatforms);
    }

    public static int findMinPlatforms(int[] arrival, int[] departure) {
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1;
        int minPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
                if (platformsNeeded > minPlatforms) {
                    minPlatforms = platformsNeeded;
                }
            } else {
                platformsNeeded--;
                j++;
            }
        }

        return minPlatforms;
    }
}
