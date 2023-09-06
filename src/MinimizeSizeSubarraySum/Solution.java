package MinimizeSizeSubarraySum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
    BufferedReader input= Files.newBufferedReader(Path.of("D:\\LeetCode\\src\\MinimizeSizeSubarraySum\\input.txt"));
    String line=input.readLine();
    Solution s=new Solution();
    while(line!=null){

        List<Integer> al = new ArrayList<>();
        StringTokenizer st=new StringTokenizer(line,",");
        int target=Integer.parseInt(st.nextToken());
        while(st.hasMoreTokens()){
            al.add(Integer.parseInt(st.nextToken()));
        }
        Integer [] a=al.toArray(new Integer[0]);
        int [] nums= Arrays.stream(a).mapToInt(Integer::intValue).toArray();
        System.out.println(s.minSubArrayLen(target,nums));
        line=input.readLine();
    }
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < len) {
            while (right < len && sum < target) {
                sum += nums[right++];
            }
            while (sum >= target) {
                ans = Math.min(right - left, ans);
                sum -= nums[left++];
            }
        }
        if(ans==Integer.MAX_VALUE)return 0;
        return ans;
    }
}
