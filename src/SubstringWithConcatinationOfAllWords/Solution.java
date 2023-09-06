package SubstringWithConcatinationOfAllWords;

import java.util.*;

public class Solution {
    static List<String> permutes=new ArrayList<>();

    public static void main(String[] args) {
        Solution s=new Solution();
        String words[]={"word","good","best","good"};
        String string="wordgoodgoodgoodbestword";


        System.out.println(s.findSubstring(string,words));
    }
    private void intialize(Map<String, Integer> hm,String[]words) {

        for(String l:words){
            hm.put(l,hm.getOrDefault(l,0)+1);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
    Map<String,Integer> hm=new HashMap<String,Integer>();
    for(String l:words){
        hm.put(l,hm.getOrDefault(l,0)+1);
    }
    Set<String> hs=hm.keySet();
       List<Integer> ans=new ArrayList<>();
       int len=words[0].length();
       int si=words.length;
       for(int i=0;i<s.length()-si*len+1;i++){
           String curr=s.substring(i,i+len);
           if(hs.contains(curr)){
               HashMap<String,Integer> check=new HashMap<String,Integer>();
               boolean flag=true;
               for(int j=i;j<i+si*len;j+=len){
                   curr=s.substring(j,j+len);
                   check.put(curr,check.getOrDefault(curr,0)+1);
                   if(hm.get(curr)!=null && hm.get(curr)>=check.get(curr)){
                       continue;
                   }
                   else{
                       flag=false;
                       break;
                   }
               }
               if(flag) {
                   ans.add(i);
               }
//               hm=new HashMap<String,Integer>();
//               intialize(hm,words);
           }

       }
       return ans;
    }

    private void permute(String word,String []words,int l, int r){
        if(l==r ){
            permutes.add(word);
        }
        else {
            for(int i=l;i<=r;i++){
                word=swa(word,words,l,i);
                permute(word,words,l+1,r);
                word=swa(word,words,l,i);
            }
        }
    }

    private String swa(String word, String[] words, int l, int i) {
        String temp=words[l];
        words[l]=words[i];
        words[i]=temp;
        return word+words[l];
    }

}
