package WordLadder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        s.ladderLength("","",new ArrayList<String>());
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 0;
        }
        var hs = new HashSet<String>();
        for (var curr : wordList) hs.add(curr);
        var visited = new HashSet<String>();
        var queue = new ArrayDeque<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        char alphabets[] = new char[26];
        alphabets[0] = 'a';
        for (int i = 1; i < 26; i++) {
            alphabets[i] = (char) ((int) alphabets[i - 1] + 1);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                var curr = queue.poll();
                if (curr.equals(endWord)) return level;
                var charArray = curr.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    char old = charArray[i];
                    for (char alpha : alphabets) {
                        charArray[i] = alpha;
                        String replacement = new String(charArray);
                        if (hs.contains(replacement) && !visited.contains(replacement)) {
                            queue.add(replacement);
                            visited.add(replacement);
                        }
                    }
                    charArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
