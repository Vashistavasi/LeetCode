package Sum3;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[]nums){
        Set<List<Integer>> res=new HashSet<List<Integer>>();
        if(nums.length==0)return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>0) k--;
                else if(sum<0) j++;
            }
        }
        return new ArrayList<>(res);
    }
    // class Pair{
    //     int i,j,sum;
    //     Pair(int i,int j,int sum){
    //         this.i=i;this.j=j;this.sum=sum;
    //     }
    // }
    // class Check{
    //     int i,j,k;
    //     Check(int i,int j,int k){
    //         this.i=i;this.j=j;this.k=k;
    //     }
    //     @Override
    // 	public int hashCode() {
    // 		final int prime = 31;
    // 		int result = 1;
    // 		result = prime * result + getEnclosingInstance().hashCode();
    // 		result = prime * result + Objects.hash(i, j, k);
    // 		return result;
    // 	}
    // 	@Override
    // 	public boolean equals(Object obj) {
    // 		if (this == obj)
    // 			return true;
    // 		if (obj == null)
    // 			return false;
    // 		if (getClass() != obj.getClass())
    // 			return false;
    // 		Check other = (Check) obj;
    // 		if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
    // 			return false;
    // 		return i == other.i && j == other.j && k == other.k;
    // 	}
    //     private Solution getEnclosingInstance() {
    // 		return Solution.this;
    // 	}
    // }
    // public List<List<Integer>> threeSum(int[] nums) {

    //     Map<Integer,Integer> hm=
    //     new HashMap<Integer,Integer>();
    //     for(int i=0;i<nums.length;i++){
    //         hm.put(nums[i],i);
    //     }
    //     List<List<Integer>> ans=new ArrayList<List<Integer>>();
    //     if(hm.size()==1){
    //         if(nums[0]==0)
    //         {
    //             ArrayList<Integer> zer=new ArrayList<Integer> ();zer.add(0);zer.add(0);zer.add(0);
    //            ans.add(zer);
    //            return ans;
    //         }
    //         else return ans;
    //     }
    //     ArrayList<Pair> al=new ArrayList<Pair>();
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             al.add(new Pair(i,j,nums[i]+nums[j]));
    //         }
    //     }


    //     HashSet<Check> hs=new HashSet<Check>();
    //     for(int i=0;i<al.size();i++){
    //        Pair cur=al.get(i);
    //        if(hm.containsKey(-1*cur.sum)){
    //            int first,second,third;
    //            first=cur.i;second=cur.j;third=hm.get(-1*cur.sum);
    //            if(first!=third && second!=third && first!=second){
    //                               ArrayList<Integer> tem=new ArrayList<Integer>();
    //                               int a[]=new int[3]; a[0]=nums[first];a[1]=nums[second];a[2]=nums[third];
    //                               Arrays.sort(a);
    //                               first=a[0];second=a[1];third=a[2];
    //                tem.add(first);tem.add(second);tem.add(third);

    //                if(!hs.contains(new Check(first,second,third))){
    //                    hs.add(new Check(first,second,third));
    //               ans.add(tem);
    //                }

    //            }
    //        }
    //     }
    //     return ans;
    // }
}