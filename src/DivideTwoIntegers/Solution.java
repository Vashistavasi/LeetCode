package DivideTwoIntegers;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.divide(2147483647,2));
    }
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
        boolean neg= ((dividend<0)^(divisor<0))?true:false;
        dividend=Math.abs(dividend);divisor=Math.abs(divisor);

       int count=divisor; int quo=0, mul=divisor,ans=0;
       while(dividend>=divisor){
           int temp=divisor;int m=1;
           while(temp<<1 >0 && temp<<1<=dividend && m<=Integer.MAX_VALUE ){
               temp<<=1;
               m<<=1;
           }
           dividend-=temp;
           ans+=m;
       }

       if(neg)return -ans;
       else return ans;
    }
}
