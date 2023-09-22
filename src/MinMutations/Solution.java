package MinMutations;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        var hs = new HashSet<String>();
        for(String curr: bank)hs.add(curr);
        Set<String> visited=new HashSet<>();
        var queue = new ArrayDeque<String>();
        queue.add(startGene);
        int level=1;
        char gene[] = new char[]{'A', 'C', 'G', 'T'};
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                String curr=queue.poll();
                if(curr.equals(endGene))return level;
                char [] charArray=curr.toCharArray();
                for(int i=0;i<curr.length();i++) {
                    char old = charArray[i];
                    for (int j = 0; j < gene.length; j++) {
                        charArray[i] = gene[j];
                        String mutation = new String(charArray);
                        if (hs.contains(mutation) && !visited.contains(mutation)) {
                            queue.add(mutation);
                            visited.add(mutation);
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
