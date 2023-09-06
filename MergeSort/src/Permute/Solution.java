package Permute;

import java.util.ArrayList;
import java.util.List;

public class Solution { 
	static List<List<Integer>> ans;
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.permute(new int []{1,2,3}));
	}
	 public List<List<Integer>> permute(int[] nums) {
	        ans=new ArrayList<List<Integer>>();
	        ArrayList<Integer> check=new ArrayList<Integer>();
	        for(int a:nums)
	        	check.add(a);
	        swap(check,0);
	        return ans;
	    }
	 
	 public void swap(ArrayList<Integer> al,int idx) {
		 if(idx==al.size())
			 ans.add(new ArrayList<Integer>(al));
		 else {
			 for(int i=idx;i<al.size();i++) {
				 ArrayList<Integer> b=new ArrayList<Integer>(al);
				 int temp=al.get(i);
				 int curr=al.get(idx);
				 b.set(i, curr);
				 b.set(idx,temp);
				 swap(b,idx+1);
			 }
		 }
	 }
	    
}
