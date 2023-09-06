package Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.subsets(new int[] {1,2,3}));
	}
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> al=new ArrayList<List<Integer>>();
        al.add(new ArrayList<Integer>());
        ArrayList<Integer> f=new ArrayList<Integer>();f.add(nums[0]);
        al.add(f);
        for(int i=1;i<nums.length;i++){
            List<List<Integer>> bl=new ArrayList<List<Integer>>();
        for(int j=0;j<al.size();j++){
            List<Integer> curr=al.get(j);
            bl.add(new ArrayList<Integer>(curr));
            curr.add(nums[i]);
            bl.add(curr);
        }
        al=bl;
        }

        return al;
    }
}