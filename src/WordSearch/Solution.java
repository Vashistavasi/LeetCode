package WordSearch;

import java.util.ArrayDeque;
import java.util.List;

class Solution {
    public boolean exist(char[][] board, String word) {
      int len=board.length; int width=board[0].length;
      boolean visited[][]=new boolean[len][width];
      for(int i=0;i<len;i++){
          for(int j=0;j<width;j++){
              if(exists(i,j,board,0,word,visited))return true;

          }
      }
      return false;
    }

    private boolean exists(int i, int j, char[][] board, int pos,String word,boolean visited[][]) {
        if(visited[i][j])return false;
        if(pos==word.length())return true;
        if(i<0|| j<0|| i==board.length || j==board[0].length)return false;
        if(word.charAt(pos)!=board[i][j])return false;
        visited[i][j]=true;
        boolean ans=exists(i-1,j,board,pos+1,word,visited)||exists(i+1,j,board,pos+1,word,visited)||exists(i,j+1,board,pos+1,word,visited)||exists(i,j-1,board,pos+1,word,visited);
        visited[i][j]=false;
        return ans;
    }

}
