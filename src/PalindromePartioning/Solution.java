package PalindromePartioning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        for(List<String> a: partition("aab")){
            System.out.println(a.toString());
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        backTrack(0,s,new ArrayList<String> (),ans);
        return ans;
    }
    public static void backTrack(int pos, String s, ArrayList<String> list, List<List<String>> ans){
        if(s.length()==pos){
            ans.add(new ArrayList<String>(list));
            return;
        }
        else{
            for(int i=pos;i<s.length();i++){
                String curr=s.substring(pos,i+1);
                if(isPalindrome(curr)){
                    list.add(curr);
                    backTrack(i+1,s,list,ans);
                    list.remove(list.size()-1);
                }
                
            }
        }
    }

    private static boolean isPalindrome(String curr) {
        int low=0,high=curr.length()-1;
        while(low<high){
            if(curr.charAt(low)!=curr.charAt(high)){
                return false;
            }
            low++;high--;
        }
        return true;
    }
}
