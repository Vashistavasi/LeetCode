package ContainsDuplicateII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int [] nums={1,0,1,1};
        int k=1;
        Solution s=new Solution();
        System.out.println(s.containsNearbyDuplicate(nums,k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    var hm=new HashMap<Integer, List<Integer>> ();
    for(int i=0;i<nums.length;i++){
        if(!hm.containsKey(nums[i])){
            List<Integer> al=new ArrayList<Integer>();
            al.add(i);
            hm.put(nums[i],al);
        }
        else{
            List<Integer> al=hm.getOrDefault(nums[i],new ArrayList<>());
            for(int j: al){
                if(Math.abs(j-i)<=k)return true;
            }
            al.add(i);
            hm.put(nums[i],al);
        }
    }
    return false;
    }
}
