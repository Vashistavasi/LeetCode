package LeetCode.QuadTree;
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class Solution {
    public static void main(String[] args) {
        //int grid[][]={{1,1,1,1},{1,1,0,0},{1,1,1,1},{0,0,0,0}};
        int grid[][]={{0,1},{0,1}};
        Solution s=new Solution();
        Node root=s.construct(grid);
    }
    /*
    1 1 1 1
    1 1 0 0
    1 1 1 1
    0 0 0 0

    x0,y0 x1,y1
    (x1/2)+1,y1/2 x1,y1
     */

    public Node construct(int[][] grid) {

        int x0=0,y0=0;
        Node root=helper(grid,0,0, grid.length);
        //recursively divide whether current grid can be splited or not
        //if split is possible split into four quadrants
        //again each quadrant should be divided recursively

    return root;
    }
    public Node helper (int [][] grid, int x,int y, int size){
        boolean flag=false;
        int ones=0,zeros=0;
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(grid[i][j]==0)zeros++;
                else ones++;
                if(zeros>=1&&ones>=1){
                    flag=true;break;
                };
            }
            if(zeros>=1&&ones>=1)break;
        }
        if(!flag){
            return new Node((ones>0?true:false),true,null,null,null,null);
        }
        else {
            Node topLeft=helper(grid,x,y,size/2);
            Node topRight=helper(grid,x,y+size/2,size/2);
            Node bottomLeft=helper(grid,x+size/2,y,size/2);
            Node bottomRight=helper(grid,x+size/2,y+size/2,size/2);
            return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
        }

    }
    public Node helper(int [][]grid, int x0,int y0,int x1,int y1,int size){
        if(size==2){
            if(!((x0<=x1 && x1<grid.length && x0+1< grid.length) && (y0<=y1 && y1<grid.length && y0+1< grid.length)))return null;
            Node node =new Node(true,false);
            node.topRight=new Node(grid[x0][y0]==0?false:true,true);
            node.topLeft=new Node(grid[x0+1][y0]==0?false:true,true);
            node.bottomRight=new Node(grid[x0][y0+1]==0?false:true,true);
            node.bottomLeft=new Node(grid[x1][y1]==0?false:true,true);
            return node;
        }
    boolean flag=true;
    int zero=0,one=0;
    for(int i=x0;i<=x1 && flag;i++){
        for(int j=y0;j<=y1;j++){
            if(grid[i][j]==0)zero++;else one++;
            if(one>0&&zero>0){
                flag=false;break;
            }
        }
    }
    if(flag)
        return new Node(zero==0?false:true,
                true, null, null, null, null);
    else{
        Node root=new Node(true,false);
        root.topLeft=helper(grid,x0,y0,x1/2,y1/2,size/2);
        root.topRight=helper(grid,(x1/2)+1,y0,x1,y1/2,size/2);
        root.bottomLeft=helper(grid,x0,y1/2 ,x1/2,y1,size/2);
        root.bottomRight=helper(grid,(x1/2)+1,y1/2 ,x1,y1,size/2);
        return root;
    }
    }
}
