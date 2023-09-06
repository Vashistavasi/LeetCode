import java.util.HashSet;

class Solution {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character>hs=new HashSet<Character>();
        int start=0,end=0;
        int max=Integer.MIN_VALUE;
        String ans="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hs.contains(c)){
                int len=i-start;
                if(len>max){
                    max=len;
                    ans=s.substring(start,i);
                }
                while(s.charAt(start)!=c){
                    hs.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            else{
                hs.add(c);
                int len=i-start+1;
                if(len>max){
                    max=len;
                    ans=s.substring(start,i+1);
                }
            }
        }
        return max;
    }
}