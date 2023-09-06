import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
class Solution {
	  public class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
    	ArrayDeque<TreeNode> que=new ArrayDeque<TreeNode>();
    	que.add(root);
    	int k=1;
    	while(que.size()>0) {
    		int count=0;
    		List<Integer> al=new ArrayList<Integer>();
    		while(k-->0) {
    			TreeNode curr=que.pop();
    			if(curr.left!=null) {que.add(curr.left);count++;al.add(curr.left.val);};
    			if(curr.right!=null) {que.add(curr.right);count++;al.add(curr.right.val);};
    		}
    		k=count;
    		if(!check(al)) {
    			return false;
    		}
    	}
        return true;
        
    }
    public static boolean check(List<Integer> al) {
    	if(al.size()==1)
    		return true;
    	else if(al.size()%2!=0)
    		return false;
    	else {
    		for(int i=0;i<al.size();i++) {
    			if(al.get(i)!=al.get(al.size()-1-i))
    				return false;
    		}
    	}
    	return true;
    }
}