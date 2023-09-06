package Isomorphic;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        var hm=new HashMap<Character,Character>();
        if(s.length()!=t.length())return false;
        int len=s.length();
        for(int i=0;i<len;i++){
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            else hm.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }

}
