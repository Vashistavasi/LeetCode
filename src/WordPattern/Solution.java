package WordPattern;

import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
        public boolean wordPattern(String pattern, String s) {
            var st=new StringTokenizer(s);
            var hm=new HashMap<Character,String>();
            if(st.countTokens()!=pattern.length())return false;
            for(char c: pattern.toCharArray()){
                String token=st.nextToken();
                if(hm.containsKey(c)){
                    if(!hm.get(c).equals(token))return false;
                }
                else{
                    if(hm.containsValue(token))return false;
                    hm.put(c,token);
                }
            }
            return true;
        }
}
