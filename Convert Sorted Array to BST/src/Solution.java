/**
 * Definition for a binary tree node.
 
 */
class Solution {
	static void inOrder(TreeNode root) {
		if(root==null)
			return;
		else {
			inOrder(root.left);
			System.out.print(root.val+",");
			inOrder(root.right);
		}
	}
	public static void main(String[] args) {
		inOrder(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
	}
	 public static class TreeNode {
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

    public static TreeNode sortedArrayToBST1(int[] nums) {
        int len=nums.length;
        int mid=len/2;
        TreeNode root=new TreeNode(nums[mid]);
        TreeNode temp=root;
        TreeNode left,right;
        int start=mid-1,end=len-1;
        if(start>-1)left=new TreeNode(nums[start--]);
        else left=null;
        if(end>mid)right=new TreeNode(nums[end--]);
        else right=null;
        root.left=left;root.right=right;
        while(start>-1){
             temp=root;
           insert(temp,nums[start--]);
        }
        while(end>mid){
             temp=root;
           insert(temp,nums[end--]);
        }
        return root;
        
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
       return find(0,nums.length-1,nums);
        
    }
    public static void insert(TreeNode root, int val){
        TreeNode prev=root;
        int flag=0;
            while(root!=null){
            if(val>root.val){
            	prev=root;
                root=root.right;
                flag=1;
            }
            else{
            	prev=root;
               root=root.left;
               flag=2;
            }
        }
            if(flag==1)
        prev.right=new TreeNode(val);
            else
            	prev.left=new TreeNode(val);
    }
    public static TreeNode find(int l,int r, int arr[]) {
    	if(l>r)
    		return null;
    	if(l==r)
    		return new TreeNode(arr[l]);
    	int mid=(l+r)/2;
    	TreeNode root=new TreeNode(arr[mid]);
    	root.left=find(l,mid-1,arr);root.right=find(mid+1,r,arr);
    	return root;
    }
}