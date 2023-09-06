import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		int nums[]= {2,0,2,1,1,0};
		s.sortColors(nums);
		System.out.println(Arrays.toString(nums));
		
	}
    public void sortColors(int[] nums) {
        mergeSort(nums);
    }
    public void merge(int ans[],int[] first, int [] second){
        int len1=first.length; int len2=second.length;
        int k=0;
        int i=0;int j=0;
        while(i<len1 && j<len2){
            if(first[i]<second[j]){
                ans[k++]=first[i++];
            }
            else
            ans[k++]=second[j++];
        }
        while(i<len1) ans[k++]=first[i++];
        while(j<len2) ans[k++]=second[j++];
    }
    public void mergeSort(int []nums){
     
 if(nums.length<2)
	 return ;
 int mid=nums.length/2;
 int left[]=new int[mid];
 int right[]=new int[nums.length-mid];
 for(int i=0;i<mid;i++)left[i]=nums[i];
 for(int i=mid;i<nums.length;i++)right[i-mid]=nums[i];
mergeSort(left);
mergeSort(right);
merge(nums,left,right);
       
    }
}