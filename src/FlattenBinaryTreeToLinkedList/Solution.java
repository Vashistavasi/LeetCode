package FlattenBinaryTreeToLinkedList;


import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        var dummy=root;
        root.right=new TreeNode(5);root.left=new TreeNode(2);
        root.right.right=new TreeNode(6); root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        var pre = new ArrayList<Integer>();
        Solution s=new Solution();
        s.preOrder(root,pre);
        s.flatten(root);
        pre = new ArrayList<Integer>();
        s.preOrder(root,pre);
    }
    public void flatten(TreeNode root){
        var pre = new ArrayList<Integer>();
        var pointer=root;
        preOrder(pointer,pre);
        var dummy=root;
        var start=dummy;
        for(int i=1;i<pre.size();i++){
            dummy.left=null;
            dummy.right=new TreeNode(pre.get(i));
            dummy=dummy.right;
        }
    }
        public  void preOrder(TreeNode root,ArrayList<Integer> pre){
        if(root==null)return;
        else{
            pre.add(root.val);
            preOrder(root.left,pre);
            preOrder(root.right,pre);
        }
    }
//    public <T> void flatten(TreeNode<T> root) {
//        ArrayList<T> pre=new ArrayList<>();
//        preOrder(root,pre);
//        TreeNode<T> dummy=new TreeNode<>();
//        TreeNode<T> pointer=dummy;
//        for(T node: pre){
//            pointer.right=new TreeNode<T>();
//        }
//    }
//    public <T> void preOrder(TreeNode <T> root,ArrayList<T> pre){
//        if(root==null)return;
//        else{
//            pre.add(root.val);
//            preOrder(root.left,pre);
//            preOrder(root.right,pre);
//        }
//    }
}


 class TreeNode   {
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
