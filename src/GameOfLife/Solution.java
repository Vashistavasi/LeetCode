package GameOfLife;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[][]board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        s.gameOfLife(board);
       for(int a[]:board) System.out.println(Arrays.toString(a));
    }
    public void gameOfLife(int[][] board) {
        int len = board.length;
        int wid = board[0].length;
        int[][] ans = new int[len][wid];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                int count = neigh(i, j, board);
                if (board[i][j] == 0) {
                    if (count == 3) ans[i][j] = 1;
                } else {
                    if (count < 2) ans[i][j] = 0;
                    else if (count < 4) ans[i][j] = 1;
                    else ans[i][j] = 0;
                }
            }
        }
        for(int i=0;i<len;i++){
            System.arraycopy(ans[i], 0, board[i], 0, wid);
        }
    }

    private int neigh(int p, int q, int[][] board) {
        int count = 0;
        int len = board.length;
        int wid = board[0].length;
        int x[] = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int y[] = new int[]{1, 1, 1, 0, -1, -1, -1, 0};
        for (int i = 0; i < 8; i++) {

            if (valid(x[i] + p, y[i] + q, len, wid)) {
                if (board[x[i] + p][y[i] + q] == 1) count++;
            }

        }
        return count;
    }

    private boolean valid(int p, int q, int len, int wid) {

        return (p > -1 && q > -1 && p < len && q < wid);
    }

}
