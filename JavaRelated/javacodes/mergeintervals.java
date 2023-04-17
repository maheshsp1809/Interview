package javacodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeintervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = solution.merge(intervals);
        System.out.println("Merged intervals: ");
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
     List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
       
    }
}