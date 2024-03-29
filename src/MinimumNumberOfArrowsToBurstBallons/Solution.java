package MinimumNumberOfArrowsToBurstBallons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

class Pair{
    int x,y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
       // var points=new int[][]{{10,16},{2,8},{1,6},{7,12}};
//        var points=new int[][]{{1,2},{3,4},{5,6},{7,8}};
//        var points=new int[][]{{1,2},{1,2}};
        var points=new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(s.findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        int count=0;
        var hs=new HashSet<Pair>();
        for(int [] arr: points){
            hs.add(new Pair(arr[0],arr[1]));
        }
        int len=hs.size();
        points=new int[len][2];
        int t=0;
        for(Pair p: hs){
            points[t][0]= p.x;points[t][1]=p.y;
            t++;
        }
        Arrays.sort(points,(a, b)->a[1]-b[1]);
        int [] interval={points[0][0],points[0][1]};
        if (len==1)return 1;
        for(int i=0;i<len;i++){
            //finding common interval for the array

            while(i<len && ((interval[0]>=points[i][0] && interval[0]<=points[i][1]) ||(interval[1]>=points[i][0] && interval[1]<=points[i][1]))){
                interval[0]=Math.max(interval[0],points[i][0]);
                interval[1]=Math.min(interval[1],points[i][1]);
                i++;
            }
            count++;
            if(i<len)
            interval=new int[]{points[i][0],points[i][1]};
        }
        if(interval[0]==points[len-1][0] && interval[1]==points[len-1][1])count++;
        return count;
    }
  //need to find the most common point between the pairs and eliminate them.
}
