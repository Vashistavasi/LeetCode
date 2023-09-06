package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    Input: nums = [0,1,2,4,5,7]
//    Output: ["0->2","4->5","7"]
public static void main(String[] args) {
    Solution s=new Solution();
    int[] nums={0,1,2,4,5,7,8,9,100};
    System.out.println(s.summaryRanges(nums));
}
    public List<String> summaryRanges(int[] nums) {
    int prev=nums[0];
    var ans=new ArrayList<String> ();
    for(int i=0;i<nums.length;i++){
       int start=i;
       while(i<nums.length-1 && nums[i]+1==nums[i+1]){
           i++;
       }
       if(start!=i)
       ans.add(nums[start]+"->"+nums[i]);
       else ans.add(Integer.toString(nums[start]));
    }
    return ans;
    }
}
