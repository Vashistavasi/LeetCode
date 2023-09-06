package Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int [][] pre={{0,1}};
        Solution s=new Solution();
        int ans[]= s.findOrder(2,pre);
        System.out.println(Arrays.toString(ans));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        //load the graph and the indegree array
        int[] indegree = new int[numCourses];
        if(prerequisites.length==0)return new int[0];
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        var ans=new ArrayList<Integer>();
        var que = new ArrayDeque<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)que.add(i);
        }
        int cnt=0;
        while(!que.isEmpty()){
            int curr=que.poll();
            ans.add(curr);
            cnt++;
            var adj = graph.get(curr);
            for(int i=0;i<adj.size();i++){
                indegree[adj.get(i)]--;
                if(indegree[adj.get(i)]==0) que.add(adj.get(i));
            }
        }
        if(cnt==numCourses)return ans.stream().mapToInt(Integer::intValue).toArray();
        else return new int[0];
    }
}
