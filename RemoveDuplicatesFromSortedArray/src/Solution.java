class Solution {
    public static int removeDuplicates(int[] nums) {
     int curr=0,next=1;
     while(next<nums.length) {
    	 if(nums[curr]==nums[next])
    		 next++;
    	 else {
    		 nums[curr+1]=nums[next];
    		 curr=curr+1;
    	 }
     }
     for(int i=0;i<curr+1;i++)
    	 System.out.print(nums[i]+" ");
     System.out.println();
     return curr+1;
    }
    public static void main(String[] args) {
		System.out.print(removeDuplicates(new int[] {1,1,2}));
	}
}