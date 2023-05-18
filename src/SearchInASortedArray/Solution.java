package SearchInASortedArray;

import javax.xml.stream.events.StartDocument;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

class Solution {
    public static void main(String[] args) {
        int []nums={4,5,1,2,3};
        Solution s=new Solution();
        System.out.println(s.search(nums,1));
    }
    public int search(int[] nums, int target) {
        int k=findBase(0,nums.length-1,nums);

        return binarySearchSplit(nums,target,k);
//        return binarySearch(nums,target,k+1);
    }
    public int binarySearchSplit(int[] nums, int target,int k) {
       int ans=binarySearchCustom(nums,target,k,0);
       if (ans==-1)
           ans=binarySearchCustom(nums,target,k,1);

        return ans; // target not found
    }

    private int binarySearchCustom(int[] nums, int target, int k, int flag) {
        int ans=-1;
            int left=0, right=k-1;
            if(flag==1){
                left=k;right=nums.length-1;
            }
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(nums[mid]==target)return mid;
                else if(nums[mid]>target)
                    right=mid-1;
                else
                    left=mid+1;
            }
        return -1;
    }

    public int findBase(int low,int high,int nums[]) {
         while(low<high){
             int mid=low+(high-low)/2;
             if(nums[mid]>nums[high]) low=mid+1;
             else high=mid;
         }
         return low;
    }
}