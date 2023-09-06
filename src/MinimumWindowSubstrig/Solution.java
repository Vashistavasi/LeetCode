package MinimumWindowSubstrig;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "bba", t = "ba";
        System.out.println(s.minWindow(input, t));
    }
    public String minWindow(String s, String t){
        int [] freq=new int[60];
        for (char c : t.toCharArray()) {
            freq[c-'A']++;
        }
        int []curr=new int[60];
        int count=0;
        int sLen=s.length();
        int tLen=t.length();
        var ans=s+"a";
        if(tLen>sLen)return "";
        for (int i = 0; i < sLen; i++) {
            int start=i;
            int end=i;
            count=0;
            curr=new int[60];
            for(end=start;end<sLen && (count!=tLen);end++){
                char currChar=s.charAt(end);
                if(freq[currChar-'A']>0 && curr[currChar-'A']<freq[currChar-'A']){
                    curr[currChar-'A']++;
                    count++;
                }
            }

            if(count==tLen){
                //optimize the window length
                char temp=s.charAt(start);
                while (freq[temp-'A']!=0 && curr[temp-'A']>freq[temp-'A']){
                    start++;
                    curr[temp]--;
                    if(start<sLen)
                        temp=s.charAt(start);
                }
                String sub=s.substring(start,end);
                if(sub.length()<ans.length())ans=sub;

            }

        }
        if(ans.equals(s+"a"))return "";
        else  return ans;
    }
    public String minWindow2(String s, String t) {
        if(s.equals(t))return s;
        if(!checkFreq(s,t))return "";
        String ans = s;
        int len = s.length();
        for (int i = 0; i < len-t.length()+1; i++) {
            String curr = findwindow(s.substring(i), t);
            //if (curr.equals("")) return "";
            //update ans
            if (ans.length() > curr.length() && curr.length()>0) ans = curr;
            if(i==len-t.length() && ans.equals(s)) return s;
        }

        if(ans.equals(s))return "";
        return ans;
    }

public String minString(String s, String t){
      int sLen=s.length(), tLen=t.length(), start=0, end=0, ansS=-1, ansE=sLen;
      int []freq=new int[60];
      for(char c: t.toCharArray()){
          freq[c-'A']++;
      }
      int [] subFreq=new int[60];
      while(end<sLen){
          subFreq[s.charAt(end)-'A']++;
          while (start <= end && subFreq[s.charAt(start) - 'A'] > freq[s.charAt(start) - 'A']) {
              subFreq[s.charAt(start) - 'A']--;
              start++;
}
          if(check(subFreq,freq) && (end-start+1)<(ansE-ansS+1)){
              ansS=start;
              ansE=end;
          }
          end++;
      }
      if(ansS==-1)return "";
      return s.substring(ansS,ansE+1);
}
public boolean check(int []subFreq, int[]freq){
        for(int i=0;i<freq.length;i++){
            if(freq[i]>subFreq[i])return false;
        }
        return true;
}

    private static void initialize(String s, Map<Character, Integer> hm) {
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
    }

    public String minWindow1(String s, String t) {
        if(s.equals(t))return s;
        if(!checkFreq(s,t))return "";
        String ans = s;
        int len = s.length();
        for (int i = 0; i < len-t.length()+1; i++) {
            String curr = findwindow(s.substring(i), t);
            //if (curr.equals("")) return "";
            //update ans
            if (ans.length() > curr.length() && curr.length()>0) ans = curr;
            if(i==len-1 && ans.equals(s)) return s;
        }

        if(ans.equals(s))return "";
        return ans;
    }

    private boolean checkFreq(String s, String t) {
        Map<Character,Integer> freq=new HashMap<>();
        Map<Character,Integer> cFreq=new HashMap<>();
        initialize(t,freq);
        initialize(s,cFreq);
        for (char c : freq.keySet()) {
            if (cFreq.containsKey(c) && cFreq.get(c) >= freq.get(c)) continue;
            else return false;
        }
        return true;
    }


    private String findwindow(String substring, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        initialize(t, freq);
        int start = 0, end = 0;
        while (start<substring.length() && !freq.containsKey(substring.charAt(start))) start++;
        for (end = start; end < substring.length() && freq.size() > 0; end++) {
            char curr = substring.charAt(end);
            if (freq.containsKey(curr)) {
                if (freq.get(curr) > 1) freq.put(curr, freq.get(curr) - 1);
                else freq.remove(curr);
            }
        }
        if (freq.size() > 0) return "";
        else return substring.substring(start, end);
    }

}

