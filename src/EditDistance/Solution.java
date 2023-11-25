package EditDistance;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        String a="a"; String b="b";
        System.out.println(s.minDistance(a,b));
    }
    public int minDistance(String word1, String word2) {

        int ans = helper(word1, word2, 0, 0);

        return ans;
    }

    private int helper(String word1, String word2, int first, int second) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (first == word1.length() || second == word2.length()) return Math.abs(len2 - len1);
        else {
            if (word1.charAt(first) != word2.charAt(second)) {
                return Math.min(Math.min(helper(word1, word2, first, second + 1), helper(word1, word2, first + 1, second))
                        , helper(word1, word2, first + 1, second + 1));
            } else return 0;
        }

    }
}