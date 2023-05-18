package PreOrderInOrderTreeConstruction;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution s=new Solution();
        s.buildTree(preorder,inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a hashmap to store the indices of each node in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Call the recursive helper function with the start and end indices of the preorder and inorder arrays
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
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
}

