package FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
          int idx= Arrays.binarySearch(nums,target);
          if(idx<0)
              return new int[]{-1,-1};
          else{
              int start=idx,end=idx;
              while(start>=0 && nums[start]!=target)
                  start--;
              while(end < nums.length && nums[end]!=idx)
                  end++;
              return new int[]{start+1,end-1};
          }
    }
}
