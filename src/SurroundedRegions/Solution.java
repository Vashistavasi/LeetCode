package SurroundedRegions;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        char[][]board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        s.solve(board);
    }
    class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;this.y=y;
        }
    }
    public void solve(char[][] board) {
        ArrayDeque<Node> que=new ArrayDeque<Node>();
        int len=board.length; int width=board[0].length;
        for(int i=0;i<len;i++){
            if(board[i][0]=='O') que.offer(new Node(i,0));
            if(board[i][width-1]=='O')que.offer(new Node(i,width-1));
        }
        for(int i=0;i<width;i++){
            if(board[0][width]=='O') que.offer(new Node(0,width));
            if(board[len-1][width]=='O') que.offer(new Node(len-1,width));
        }
        while(!que.isEmpty()){
            Node curr=que.poll();
            board[curr.x][curr.y]='#';
            if(curr.x-1>=0 && board[curr.x-1][curr.y]=='O')que.offer(new Node(curr.x-1,curr.y));
            if(curr.x+1<len && board[curr.x+1][curr.y]=='O')que.offer(new Node(curr.x+1,curr.y));
            if(curr.y-1>=0 && board[curr.x][curr.y-1]=='O')que.offer(new Node(curr.x,curr.y-1));
            if(curr.y+1<width && board[curr.x][curr.y+1]=='O')que.offer(new Node(curr.x,curr.y+1));
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<width;j++){
                if(board[i][j]=='#')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
}
