package SpiralMatrix;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Solution s=new Solution();
        System.out.println(s.spiralOrder(matrix).toString());
//        [1,2,3,4,8,12,16,15,14,13,9,5,6,7,8,12]
//        [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
    }
    public List<Integer> spiralOrder(int[][] matrix) {

          List<Integer> al=new ArrayList<Integer>();
          int len=matrix.length; int width=matrix[0].length;
          int right=width-1;int down=len-1;int left=0;int up=0;
          int count=len*width;
          while(count>0){
              //goRight();
              for(int i=left;i<=right && count>0;i++,count--)
                  al.add(matrix[up][i]);
              //goDown();
              for(int i=up+1;i<=down &&count>0;i++,count--)
                  al.add(matrix[i][right]);
              up++;
              //goLeft();
              for(int i=right-1;i>=left &&count>0 ;i--,count--)
                  al.add(matrix[down][i]);
              right--;

              //goUp();
              for(int i=down-1;i>=up&&count>0;i--,count--)
                  al.add(matrix[i][left]);
              down--;
              left++;



          }
        return al;
    }



}
