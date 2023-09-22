package DesignWordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class TrieNode{
    public HashMap<Character, TrieNode> children;
    public boolean isEnd;
    public TrieNode(){
        children=new HashMap<>();
        isEnd=false;
    }
}
class Trie{
    public TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    public void add(String word){
        TrieNode current=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            TrieNode node=current.children.get(ch);
            if(node==null){
                node=new TrieNode();
                current.children.put(ch,node);
            }
            current=node;
        }
        current.isEnd=true;
    }
    public boolean search(String word,TrieNode given){
        TrieNode current=given;
        for(int i=0;i<word.length();i++){
           char ch=word.charAt(i);
           if(ch=='.'){
              var allNodes=given.children.values().stream().collect(Collectors.toList());
              for(int k=0;k<allNodes.size();k++){
                  if(i==word.length()-1 && allNodes.get(k).isEnd )return true;
                  boolean flag= search(word.substring(i+1,word.length()),allNodes.get(k));
                  if(flag)return true;
              }
              return false;
           }
           else {
               TrieNode node=current.children.get(ch);
               if(node==null)return false;
               current=node;
           }
        }
        return current.isEnd;
    }
}
class WordDictionary {
    public static void main(String[] args) {
        String dictionary[]={"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
        String match[]={"","bad","dad","mad","pad","bad",".ad","b.."};
        WordDictionary wd=new WordDictionary();
        for(String d: dictionary)wd.addWord(d);
        for(String m: match) System.out.println(wd.search(m));
    }
    Trie myTrie;
    public WordDictionary() {
        myTrie=new Trie();
    }

    public void addWord(String word) {
    myTrie.add(word);
    }

    public boolean search(String word) {
    return myTrie.search(word,myTrie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
