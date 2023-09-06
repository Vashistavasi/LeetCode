package PathSum;


import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
//        -1,5,null,4,null,null,2,-4
        TreeNode node=new TreeNode(9);
        node.left=new TreeNode(6);
        node.right=new TreeNode(-3);
        node.right.left=new TreeNode(-6);
        node.right.right=new TreeNode(2);
        node.right.right.left=new TreeNode(2);
        node.right.right.left.left=new TreeNode(-6);
        node.right.right.left.right=new TreeNode(-6);
        node.right.right.left.left.left=new TreeNode(-6);
//        node.left.left=new TreeNode(4);
//        node.left.left.right=new TreeNode(2);
//        node.left.left.right.left=new TreeNode(-4);
        Solution s=new Solution();
        System.out.println(s.maxPathSum(node));
    }

    static boolean n1 = false, n2 = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        n1=false;n2=false;
        var ans=lca(root,p,q);
        if(n1&&n2)return ans;
        else return null;
    }
    public List<Integer> rightSideView(TreeNode root) {
        var que = new ArrayDeque<TreeNode>();
        var list = new ArrayList<Integer>();
        que.add(root);
        var count=1;
        while(!que.isEmpty()){
            var c=0;
            while(count>0){
                count--;
                var currNode=que.poll();
                if(count==0) list.add(currNode.val);
                if(currNode.left!=null){
                    c++;
                    que.add(currNode.left);
                }
                if(currNode.right!=null){
                    c++;
                    que.add(currNode.right);
                }
            }
            count=c;
        }
        return list;
    }
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode temp = null;
        if (root == p) {
            n1 = true;
            temp = root;
        }
        if (root == q) {
            n2 = true;
            temp = root;
        }
        if (temp != null) return temp;
        var left = lca(root.left, p, q);
        var right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        else return left == null ? right : left;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
    return helper(root,0,targetSum);
    }

    private boolean helper(TreeNode root, int currSum, int targetSum) {
    if(root.left==null || root.right==null)return currSum==targetSum;
    else return helper(root.left,currSum+root.val,targetSum) ||
            helper(root.right,currSum+root.val,targetSum);
    }
    public int sumNumbers(TreeNode root) {
    var sum=0;
        var list = new ArrayList<String>();
        helper1(root,"",list);
        for(String i: list)sum+=Integer.parseInt(i);
    return sum;
    }

    private void helper1(TreeNode root, String currSum, ArrayList<String> list) {
        if(root==null)return;
        else if(root.left==null && root.right==null)list.add(currSum+root.val);
        else {
            helper1(root.left,currSum+Integer.toString(root.val),list);
            helper1(root.right,currSum+Integer.toString(root.val),list);
        }

    }


    public int maxPathSum(TreeNode root) {
        var nodes = new ArrayDeque<TreeNode>();
        nodes.add(root);
        long ans=Integer.MIN_VALUE;
        while(!nodes.isEmpty()){
            var currNode=nodes.poll();
            var left=maxSum(currNode.left,0);
            if(left!=0)ans=Math.max(left,ans);
            var right=maxSum(currNode.right,0);
            if(right!=0)ans=Math.max(right,ans);
            var both= (long)currNode.val;
            both+=left+right;
            ans=Math.max(ans,both);
            {
                ans=Math.max(currNode.val+left,ans);
                ans=Math.max(currNode.val+right,ans);
                ans=Math.max(currNode.val,ans);
            }
            if(currNode.left!=null){
                nodes.add(currNode.left);
                ans=Math.max(ans,maxPathSum(currNode.left));
            }
            if(currNode.right!=null){
                nodes.add(currNode.right);
                ans=Math.max(ans,maxPathSum(currNode.right));
            }
        }
        return (int)ans;
    }
    public long maxSum(TreeNode root,long currSum){
        if(root==null)return currSum;
        else if(root.right==null && root.left==null) return Math.max(currSum+root.val,currSum);
        else return Math.max(currSum,Math.max(maxSum(root.left,currSum+root.val),maxSum(root.right,currSum+root.val)));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



