package SimplifyPath;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.simplifyPath("/home/../../foo/"));
    }
    public String simplifyPath(String path) {
        StringTokenizer st=new StringTokenizer(path,"/");
        StringBuilder sb=new StringBuilder();
        sb.append("/");
        while(st.hasMoreTokens()){
            String curr=st.nextToken();
            if(curr.equals("..")){
                int idx=sb.substring(0,sb.length()-1).lastIndexOf("/");
                if(idx>=0)
                sb=new StringBuilder(sb.substring(0,idx)+"/");
            }
            else if(curr.equals(".")){
                continue;
            }
            else{
                sb.append(curr+"/");
            }
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
