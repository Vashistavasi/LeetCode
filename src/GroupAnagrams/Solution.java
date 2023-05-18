package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<char[]> al = new ArrayList<char[]>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            al.add(curr);
        }
        boolean[] visited = new boolean[strs.length];
        List<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                List<String> group = new ArrayList<String>();
                group.add(strs[i]);
                char[] root = al.get(i);
                visited[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    char[] child = al.get(j);
                    if (child.length != root.length) continue;
                    else {
                        int k = 0;
                        for (k = 0; k < child.length; k++) {
                            if (child[k] != root[k]) break;
                        }
                        if (k == child.length) {
                            group.add(strs[j]);
                            visited[j] = true;
                        }
                    }
                }
                ans.add(group);
            }
        }
        return ans;
    }

}
