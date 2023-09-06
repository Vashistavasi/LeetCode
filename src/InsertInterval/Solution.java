package InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        // int [][] a={{1,6}};
        int[] interval = {4, 10};
        for (int[] i : s.insert(a, interval)) System.out.print(Arrays.toString(i));
    }

    public int[][] insert(int[][] intervals, int[] interval) {
        var result = new ArrayList<Integer[]>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < interval[0]) {
            result.add(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= interval[1]) {
            interval = new int[]{Math.min(intervals[i][0], interval[0]), Math.max(
                    intervals[i][1], interval[1])
            };
            i++;
        }
        result.add(new Integer[]{interval[0], interval[1]});
        while (i < intervals.length) {
            result.add(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        int ans[][] = new int[result.size()][2];
        int t = 0;
        for (Integer[] k : result) {
            ans[t][0] = k[0];
            ans[t][1] = k[1];
            t++;
        }
        return ans;
    }


    public int[][] insert1(int[][] intervals, int[] newInterval) {
        // 2,3 6,9 1,4-> 1,4 6,
        if(intervals.length==0)return new int[][]{{newInterval[0],newInterval[1]}};
        int start=0; int end=0;
        boolean overlap=false;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>=newInterval[0] && intervals[i][0]<=newInterval[0]){
                start=i;
                overlap=true;
            }
            if(intervals[i][1]>=newInterval[1] && intervals[i][0]<=newInterval[1]){
                end=i;
                overlap=true;
            }
            if(intervals[i][1]<=newInterval[1] && intervals[i][0]>newInterval[0]){
                start=i;overlap=true;
            }
        }
        int ans[][]=null;
        if(overlap){
            int len=intervals.length-end+start;
            ans=new int[len][2];
            for(int k=0;k<start;k++){
                ans[k][0]=intervals[k][0]; ans[k][1]=intervals[k][1];
            }
            ans[start][0]=Math.min(intervals[start][0],newInterval[0]);
            ans[start][1]=Math.max(intervals[end][1],newInterval[1]);
            for(int k=end+1;k<intervals.length;k++){
                ans[k-end+start][0]=intervals[k][0]; ans[k-end+start][1]=intervals[k][1];
            }
        }
        else{
            for(int i=0;i<intervals.length;i++){
                if(intervals[i][0]>newInterval[1]){
                    start=i;
                }
            }
            if(start==0){
                if(intervals[0][0]<=newInterval[1]){
                    start=intervals.length-1;
                }
            }
            ans=new int[intervals.length+1][2];
            for(int k=0;k<start;k++){
                ans[k][0]=intervals[k][0]; ans[k][1]=intervals[k][1];
            }
            ans[start][0]=newInterval[0]; ans[start][1]=newInterval[1];
            for(int k=start;k<intervals.length;k++){
                ans[k+1][0]=intervals[k][0]; ans[k+1][1]=intervals[k][1];
            }
        }
        return ans;
    }
}
