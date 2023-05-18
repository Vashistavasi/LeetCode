package DecodeWays;

import java.util.HashMap;
import java.util.HashSet;

import static PalindromePartioning.Solution.backTrack;

class Solution {
    static int count=0;
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.numDecodings("1111111111111111111111111111111111111111111111111    "));
    }
    public int numDecodings(String s) {
        Integer m[]=new Integer[s.length()];
        count=backTrack(0,s,m);
     return count;
    }

    private int backTrack(int pos, String s,Integer [] m) {
        if(pos==s.length())
            return 1;

            if(s.charAt(pos)=='0')return 0;
            if(m[pos]!=null)return m[pos];
            int count1=backTrack(pos+1,s,m);
            int count2=0;
            if(pos+2<=s.length() && Integer.parseInt(s.substring(pos,pos+2))<=26)
                count2=backTrack(pos+2,s,m);
            return m[pos]=count1+count2;
    }
}

