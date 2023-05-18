package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        ArrayList<int[]>al=new ArrayList<int[]>();
        int [] currentInterval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=currentInterval[1]){
                currentInterval[1]=Math.max(currentInterval[1],intervals[i][1]);
            }
            else{
                al.add(currentInterval);
                currentInterval=intervals[i];
            }
        }
        al.add(currentInterval);
        return al.toArray(new int[al.size()][]);

    }
}
