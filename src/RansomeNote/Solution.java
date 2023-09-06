package RansomeNote;

import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        return solve(ransomNote, magazine);
    }

    private boolean solve(String ransomNote, String magazine) {
        var hm = new HashMap<Character, Integer>();
        for (char c : ransomNote.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        for (char c : magazine.toCharArray()) {
            if (hm.containsKey(c)) {
                if (hm.get(c) == 1) {
                    hm.remove(c);
                } else
                    hm.put(c, hm.get(c) - 1);
            }
        }
        return hm.size() == 0;
    }
}
