import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		String[] strs={"flower","flow","flight"};
		String []strs1= {"ab","a"};
		Solution s=new Solution();
		System.out.println(s.longestCommonPrefix(strs1));
	}
    public String longestCommonPrefix1(String[] strs) {
      StringBuilder sb=new StringBuilder();
        boolean flag=true;
      for(int i=0;i<strs[0].length() && flag;i++){
          char c=strs[0].charAt(i);
          for(int j=1;j<strs.length;j++){
              if(strs[j].length()<=i)
              {
                flag=false; break;
              }
           else   if( c==strs[j].charAt(i)){
                  continue;
              }

          }
          if(flag)
          sb.append(c);
          else break;
      }
      return new String(sb);
    }
     public String longestCommonPrefix(String[] strs) {
    	 int len=Integer.MAX_VALUE;
    	 String least="";
    	 for(int i=0;i<strs.length;i++) {
    		 if(len>strs[i].length()) {
    			 len=strs[i].length();
    			 least=strs[i];
    		 }
    	 }
      Trie main=new Trie();
      for(int i=0;i<strs.length;i++)
      main.insert(strs[i],main);
      int k=0;
      Trie temp=main;
      while(temp!=null && temp.getChildren().size()==1){
        temp=temp.children.get(least.charAt(k));
        k++;
      }
      return strs[0].substring(0,k);
    }
   public class Trie {
     private final Map<Character, Trie> children;
    private boolean isEndOfWord;

    public Trie() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }

    public Map<Character, Trie> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    public void insert(String word,Trie current) {
        for (char ch : word.toCharArray()) {
            current.getChildren().putIfAbsent(ch, new Trie());
            current = current.getChildren().get(ch);
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word, Trie current) {
        for (char ch : word.toCharArray()) {
            Trie node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }
}
}