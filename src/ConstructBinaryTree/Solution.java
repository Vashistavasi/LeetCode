package ConstructBinaryTree;


import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int preorder[]={9,15,7,20,3};
        int inorder[]={9,3,15,20,7};
        Solution s=new Solution();
        TreeNode node=s.buildTree1(inorder,preorder);
    }
    int val;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a hashmap to store the indices of each node in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Call the recursive helper function with the start and end indices of the preorder and inorder arrays
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper1(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }

    private TreeNode buildTreeHelper1(int[] postorder, int postOrderStart, int postOrderEnd, int[] inorder, int inorderStart, int inorderend, HashMap<Integer, Integer> map) {
    if(postOrderStart>postOrderEnd || inorderStart>inorderend) return null;
        int curr = postorder[postOrderEnd];
        int idx=map.get(curr);
        var root=new TreeNode(curr);
        int leftTreeSize=idx-inorderStart;
        root.left=buildTreeHelper1(postorder,postOrderStart,postOrderStart+leftTreeSize-1,inorder,inorderStart,idx-1,map);
        root.right=buildTreeHelper1(postorder,postOrderStart+leftTreeSize,postOrderEnd-1,inorder,idx+1,inorderend,map);
        return root;
    }


    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in the preorder array is the root node
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root node in the inorder array
        int rootIndex = map.get(rootVal);

        // Recursively build the left and right subtrees by updating the start and end indices of the preorder and inorder arrays
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, map);
        root.right = buildTreeHelper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, map);

        return root;
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

}



