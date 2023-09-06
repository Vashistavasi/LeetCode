package Graphs;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
//        [[2,4],[1,3],[2,4],[1,3]]
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        var list1 = new ArrayList<Node>();
        var list2 = new ArrayList<Node>();
        var list3 = new ArrayList<Node>();
        var list4=new ArrayList<Node>();
        list1.add(node2);list1.add(node4);
        list2.add(node1);list2.add(node3);
        list3.add(node2);list3.add(node4);
        list4.add(node1);list4.add(node3);
        node1.neighbors=list1;
        node2.neighbors=list2;
        node3.neighbors=list3;
        node4.neighbors=list4;
        Node ans=s.cloneGraph(node1);
        System.out.println(ans);
    }
    public Node cloneGraph(Node node) {
        var hm = new HashMap<Integer, Node>();
        var visited = new HashSet<Node>();
        var que = new ArrayDeque<Node>();
        que.add(node);
        while(!que.isEmpty()){
            Node currNode=que.poll();
            visited.add(currNode);
            if(!hm.containsKey(currNode.val))
            hm.put(currNode.val,new Node(currNode.val));
            var nei=currNode.neighbors;
            for(int i=0;i<nei.size();i++){
                if (!visited.contains(nei.get(i))) {
                    que.add(nei.get(i));
                    if(!hm.containsKey(nei.get(i).val)){
                        hm.put(nei.get(i).val,new Node(nei.get(i).val));
                    }
                }
            }

        }
        visited = new HashSet<>();
        que.add(node);
        var ans=hm.get(node.val);
        var aq = new ArrayDeque<Node>();
        aq.add(ans);
        while(!que.isEmpty()){
            Node currNode=que.poll();
            Node replica=aq.poll();
            var replicaNei=replica.neighbors;
            visited.add(currNode);
            var nei=currNode.neighbors;
            for(int i=0;i<nei.size();i++){
                if(!replicaNei.contains(hm.get(nei.get(i).val)))
                replicaNei.add(hm.get(nei.get(i).val));
                if(!visited.contains(nei.get(i))){
                    que.add(nei.get(i));
                    aq.add(hm.get(nei.get(i).val));
                }
            }
        }
        return ans;

    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
