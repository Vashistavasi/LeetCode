package SnakesAndLadders;

import java.util.*;
class Node {
    int node;
    int x;
    int y;
    int weight;

    public Node(int node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
        this.weight = Integer.MAX_VALUE;
    }
}
class Solution {
    public int snakesAndLadders1...(int[][] board) {
        {
            Map<Integer, Node> hm = new HashMap<>();
            int node=1; int len= board.length;
            boolean flag=true;
            for(int i=len-1;i>-1;i--){
                if(flag){
                    for(int j=0;j<len;j++){
                        hm.put(node,new Node(node,i,j));
                        node++;
                    }
                    flag=false;
                }
                else{
                    for(int j=len-1;j>-1;j--){
                        hm.put(node, new Node(node, i, j));
                        node++;
                    }
                    flag=true;
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            Node root=hm.get(1);
            root.weight=0;
            pq.add(root);
            while (!pq.isEmpty()) {
                Node curr=pq.poll();
                int low=curr.node+1;
                int upper=Math.min(curr.node+6,len*len);
                for(int ra=low;ra<=upper;ra++){
                    if (ra<len*len+1) {
                        Node adjNode=hm.get(ra);
                        int x=adjNode.x; int y=adjNode.y;
                        if(board[x][y]==-1){
                            if(adjNode.weight>curr.weight+1){
                                adjNode.weight=curr.weight+1;
                                pq.add(adjNode);
                            }
                        }
                        else{
                            Node ladderOrSnake=hm.get(board[x][y]);
                            if(ladderOrSnake.weight>curr.weight+1){
                                ladderOrSnake.weight= curr.weight+1;
                                pq.add(ladderOrSnake);
                            }
                        }
                    }
                }

            }
            if(hm.get(len*len).weight==Integer.MAX_VALUE)return -1;
            return hm.get(len*len).weight;
        }
    }
    public int mySol(int [][]board){
        Map<Integer, Node> hm = new HashMap<>();
        int node=1; int len= board.length;
        hm.put(1,new Node(1,1,2));
        boolean flag=true;
        for(int i=len-1;i>-1;i--){
            if(flag){
                for(int j=0;j<len;j++){
                    hm.put(node,new Node(node,i,j));
                    node++;
                }
                flag=false;
            }
            else{
                for(int j=len-1;j>-1;j--){
                    hm.put(node, new Node(node, i, j));
                    node++;
                }
                flag=true;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        Node root=hm.get(1);
        root.weight=0;
        pq.add(root);
        boolean[] visited =new boolean[len*len+1];
        while (!pq.isEmpty()) {
            Node curr=pq.poll();
            int range=Math.min(6,len*len);
//            if(!visited[curr.node])
            {
                for(int ra=1;ra<=range;ra++){
                    if (curr.node+ra<len*len+1 && !visited[curr.node + ra]) {
                        Node adjNode=hm.get(curr.node+ra);
                        int x=adjNode.x; int y=adjNode.y;
                        if(board[x][y]==-1){
                            if(adjNode.weight>curr.weight+1) {
                                adjNode.weight = curr.weight + 1;
                                pq.add(adjNode);
                            }
                           // visited[adjNode.node]=true;
                        }
                        else{
                            Node ladderOrSnake=hm.get(board[x][y]);
                            if(ladderOrSnake.weight>curr.weight+1){
                                ladderOrSnake.weight= curr.weight+1;
                                pq.add(ladderOrSnake);
                            }

                            //visited[ladderOrSnake.node]=true;
                        }
                    }
                }
            }
//            visited[curr.node]=true;

        }
return hm.get(len*len).weight;
    }
    public static void main(String[] args) {
//        int [] [] board=
//                 {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
//                         {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1},
//                         {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
//        Solution s=new Solution();
//        System.out.println(s.mySol(board));
//        [[-1,-1,-1,-1,48,5,-1],[12,29,13,9,-1,2,32],[-1,-1,21,7,-1,12,49],
//        [42,37,21,40,-1,22,12],[42,-1,2,-1,-1,-1,6],[39,-1,35,-1,-1,39,-1],[-1,36,-1,-1,-1,-1,5]]
        int [][]board =      {{-1,-1,-1,-1,48,5,-1},{12,29,13,9,-1,2,32},{-1,-1,21,7,-1,12,49},
                {42,37,21,40,-1,22,12},{42,-1,2,-1,-1,-1,6},{39,-1,35,-1,-1,39,-1},{-1,36,-1,-1,-1,-1,5}};
        Solution s=new Solution();
        int ans=s.mySol(board);
        System.out.println("The answer is ");
        System.out.println(ans);
//        Solution s=new Solution();
//        int len=board.length;
//        boolean visited[][]=new boolean[len][len];
//        int dis[][]=new int[len][len];
//        for(int i=0;i<len;i++){
//            for(int j=0;j<len;j++){
//                dis[i][j]=Integer.MAX_VALUE;
//            }
//        }
////        visited[len-1][0]=true;
////        dis[len-1][0]=0;
////        PriorityQueue<Integer[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
////        pq.add(new Integer[]{len - 1, 0, 0});
////        s.dfs(board,0,len-1,0,visited,dis);
//        s.bfs(board,visited,dis);
//        System.out.println(ans);
    }
    static int ans=Integer.MAX_VALUE;
//    static boolean flag=false;
    public void bfs(int[][]board, boolean visited[][], int dis[][])
    {
        int len= board.length;
        PriorityQueue<Integer[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new Integer[]{len - 1, 0, 0});
        while (!pq.isEmpty()) {
            Integer[] curr=pq.poll();
            int x=curr[0];int y=curr[1];int w=curr[2];
            visited[x][y]=true;
            int range = Math.min(6, len * len);
            for (int i = 1; i <= range && x>-1 && y>-1; i++) {
                //dfs on neighbors
                if (x % 2 == 1) {
                    //go right
                    if (y + 1 == len) {
                        x--;
                        y = len - 1;
                    } else {
                        y++;
                    }
                } else {
                    //go left
                    if (y - 1 == -1) {
                        x--;
                        y = 0;
                    } else {
                        y--;
                    }
                }
                if (x > -1 && y > -1) {
                    if(visited[x][y])return;
                    visited[x][y]=true;
                    if(board[x][y]==-1){
                        if(dis[x][y]>w+1)dis[x][y]=w+1;
                        //dfs(board, dis[x][y], x, y,visited,dis);
                        pq.add(new Integer[]{x, y, dis[x][y]});
                    }
                    else{
                        if(dis[board[x][y]/len][board[x][y]%len]>w+1)dis[board[x][y]/len][board[x][y]%len]=w+1;
//                        dfs(board,w+1,board[x][y]/len,board[x][y]%len,visited,dis);
                        pq.add(new Integer[]{board[x][y]/len,board[x][y]%len,dis[board[x][y]/len][board[x][y]%len]});
                    }
                }
            }
        }
    }
    public void dfs(int [][]board,int val,int x,int y, boolean visited[][],int dis[][]) {
//        if(flag)return;
        int len = board.length;
        if (x == 0 && y == 0) {
            ans = Math.min(ans, val);
//            flag=false;
        }
        else {
            int range = Math.min(6, len * len);
            for (int i = 1; i <= range && x>-1 && y>-1; i++) {

                //dfs on neighbors
                if (x % 2 == 1) {
                    //go right
                    if (y + 1 == len) {
                        x--;
                        y = len - 1;
                    } else {
                        y++;
                    }
                } else {
                    //go left
                    if (y - 1 == -1) {
                        x--;
                        y = 0;
                    } else {
                        y--;
                    }
                }
                if (x > -1 && y > -1) {
                    if(visited[x][y])return;
                    visited[x][y]=true;
                    if(board[x][y]==-1){
                        if(dis[x][y]>val+1)dis[x][y]=val+1;
                        dfs(board, dis[x][y], x, y,visited,dis);
                    }
                    else{
                        if(dis[board[x][y]/len][board[x][y]%len]>val+1)dis[board[x][y]/len][board[x][y]%len]=val+1;
                        dfs(board,val+1,board[x][y]/len,board[x][y]%len,visited,dis);
                    }
                    visited[x][y]=false;
                }
            }
        }
    }
    public int snakesAndLadders(int[][] board) {
        int len=board.length;
        List<List<Integer[]>> graph = new ArrayList<List<Integer[]>>();
        for(int i=0;i<=len*len;i++){
            graph.add(new ArrayList<Integer[]>());
        }
        int range=Math.min(6,len*len);
        int node=1;
        for(int i=len-1;i>-1;i--){
            for(int j=0;j<len;j++){
                addNodes(board,graph,i,j,range,node);
                node++;
            }
        }

      int [] dis=bfs(graph);
        return dis[dis.length - 1];
    }

    private void addNodes(int [][]board,List<List<Integer[]>> graph, int i, int j, int range,int node) {
        var list=graph.get(node);
        var len = board.length;
        for(int l=1;l<=range && node+l<len*len+1;l++){
            if(j+1==len){
                if(i%2==0)j=0;
                else j=len-1;
                i--;
            }
            else j++;
            if(board[i][j]==-1)
            list.add(new Integer[]{node + l, 1});
            else list.add(new Integer[]{board[i][j], 1});
        }
        graph.set(node,list);
    }
    public void bfs(int board[][]){
        int len=board.length;
        int [][] dis=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++)dis[i][j]=Integer.MAX_VALUE;
        }
        dis[len-1][0]=0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.add(new Integer[]{len - 1, 0, 0});
        int range=Math.min(6,len*len);
        while(pq.isEmpty()){
            Integer[] curr=pq.poll();
            int curri=curr[0]; int currj=curr[1]; int currW=curr[2];
            for(int l=1;l<=range;l++){
                if(curri%2==1){
                    //move left
                    if(currj-1<0){
                        curri--;
                        currj=0;
                    }
                    else {
                        currj--;
                    }
                    if(dis[curri][currj]>dis[curr[0]][curr[1]]+1){
                        dis[curri][currj]=dis[curr[0]][curr[1]]+1;
                        pq.add(new Integer[]{curri, currj, dis[curri][currj]});
                    }
                }
                else{
                    //move right
                }
            }
        }
    }
    public int[] bfs(List<List<Integer[]>> graph){
        var que = new ArrayDeque<Integer>();
        que.add(1);
        var hs = new HashSet<Integer>();
        PriorityQueue<Integer[]> pq=new PriorityQueue<>((v1,v2)->v1[1]-v2[1]);
        pq.add(new Integer[]{1, 0});
        int dis[] = new int[graph.size()+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1]=0;
        while (!pq.isEmpty()) {
        Integer [] curr=pq.poll();
            List<Integer[]> adj = graph.get(curr[0]);
            for(int i=0;i<adj.size();i++){
                if(dis[adj.get(i)[0]]>curr[1]+1){
                 dis[adj.get(i)[0]]=curr[1]+1;
                 adj.get(i)[1]=curr[1]+1;
                }
            }
        }
        return dis;
    }
}
