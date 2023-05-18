package RotateImage;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int [][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        s.rotate(matrix);
        for(int []a : matrix)
        System.out.println(Arrays.toString(a));
    }
    public void rotate(int[][] matrix) {
    int len=matrix.length;int width=matrix[0].length;
    int up=0;int down=len-1;int left=0;int right=width-1;
    Queue<Integer> que=new ArrayDeque<>();
    while(up<=down && left<=right){
        //Top Row values to queue
        for(int i=left;i<=right;i++){
            que.add(matrix[up][i]);
        }
        // Right column to queue
        for(int i=up;i<=down;i++){
            que.add(matrix[i][right]);
        }
        //bottom row values to queue
        for(int i=right;i>=left;i--){
            que.add(matrix[down][i]);
        }
        //left column to queue
        for(int i=down;i>=up;i--){
            que.add(matrix[i][left]);
        }
        //left column to queue
        for(int i=up;i<=down;i++){
            matrix[i][right]=que.poll();
        }
        // replace bottom row values
        for(int i=right;i>=left;i--){
            matrix[down][i]=que.poll();
        }

        // replace left column values
        for(int i=down;i>=up;i--){
            matrix[i][left]=que.poll();
        }
        // replace top row with values
        for(int i=left;i<=right;i++){
            matrix[up][i]=que.poll();
        }
        up++;down--;left++;right--;
    }
        }


}
