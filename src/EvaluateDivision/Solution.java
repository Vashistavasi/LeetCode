package EvaluateDivision;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    static double k=1;
    public static void main(String[] args) {
        var al = new ArrayList<List<String>>();
        al.add(Arrays.asList(new String[]{"a","b"}));
        al.add(Arrays.asList(new String[]{"b", "c"}));
        double[] values={2,3};
        var queries = new ArrayList<List<String>>();
        queries.add(Arrays.asList(new String[]{"a", "c"}));
        queries.add(Arrays.asList(new String[]{"c", "x"}));
        queries.add(Arrays.asList(new String[]{"b", "a"}));
        Solution s=new Solution();
        double[] ans = s.calcEquation(al, values, queries);
        System.out.println(Arrays.toString(ans));
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      //construct graph
        Map<String, List<Object[]>> graph = new HashMap<>();
        for(int i=0;i<values.length;i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double val=values[i];
            var currNeighbour=new Object[]{b,val};
            var neigh = graph.getOrDefault(a, new ArrayList<>());
            neigh.add(currNeighbour);
            graph.put(a,neigh);
            currNeighbour=new Object[]{a,1/val};
            neigh = graph.getOrDefault(b, new ArrayList<>());
            neigh.add(currNeighbour);
            graph.put(b, neigh);
        }
        var ans = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            double currAns=1;
            if(a.equals(b) && graph.containsKey(a))ans[i]=1;
            else if(graph.containsKey(a) && graph.containsKey(b)){
                k=1;
                dfs(a, b, currAns, graph, new HashSet<>());
                ans[i]=k;
            }
            else ans[i]=-1;
        }
        return ans;
    }

    private void dfs(String a, String b, double currAns, Map<String, List<Object[]>> graph, HashSet<String> hs) {
            String currNode=a;
            hs.add(currNode);
            List<Object[]> currNei = graph.get(currNode);
            for(int j=0;j<currNei.size();j++){
                String currNeiNode=(String)currNei.get(j)[0];
                double val=(double) currNei.get(j)[1];
                if(!hs.contains(currNeiNode)){
                    if(currNeiNode.equals(b)){
                        currAns*=val;
                        k=currAns;
                        break;
                    }
                    else{
                        currAns*=val;
                        dfs(currNeiNode,b,currAns,graph,hs);
                        currAns/=val;
                    }
                }
            }

    }
}
