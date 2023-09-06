import java.util.Arrays;

class Solution {
    public static int[] plusOne(int[] digits) {
    	int len=digits.length;
    	boolean overflow=false;
    	int carry=1;
    	for(int i=len-1;i>-1;i--) {
    	   if(i==0 && carry==1) {
    		   if(digits[0]+carry>9) {
    			   overflow=true;
    			   digits[0]=0;
    		   }
    		   else digits[0]++;
    	   }
    	   else {
    		   if(carry==1) {
    			   if(digits[i]+carry>9) {
        			   digits[i]=0;
        		   }
    			   else {
    				   carry=0;
    				   digits[i]++;
    			   }
    		   }
    		   else {
    			   carry=0;
    			   break;
    		   }
    	   }
    	}
    	if(overflow) {
    		int arr[]=new int[len+1];
    		arr[0]=1;
    		for(int i=1;i<len+1;i++) {
    			arr[i]=digits[i-1];
    		}
    		return arr;
    	}
    	return digits;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] {1,0})));
	}
}