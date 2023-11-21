package InterleavingStrings;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1=s1.length(); int l2=s2.length(); int l3=s3.length();
        if(l3!=l1+l2)return false;
        else return dfs(s1,s2,s3,0,0,0,new boolean[l1+1][l2+2]);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] booleans) {
      if(booleans[i][j])return false;
        if(k==s3.length())return true;
       boolean valid=(i<s1.length() && s1.charAt(i)==s3.charAt(k)&&dfs(s1,s2,s3,i+1,j,k+1,booleans));
       valid =valid || (j<s2.length() && s2.charAt(j)==s3.charAt(k)&&dfs(s1,s2,s3,i,j+1,k+1,booleans));
       if(!valid)booleans[i][j]=true;
       return valid;
    }

}
