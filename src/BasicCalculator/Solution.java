package BasicCalculator;

import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) {
    Solution s=new Solution();
        System.out.println(    s.calculate("1-(     -2)"));
    }
    public int calculate(String s){
        int result=0;
        int num=0;
        int sign=1;
        var stack = new ArrayDeque<Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=10*num+ (int)(c-'0');
            } else if (c == '+') {
                result+=sign*num;
                num=0;
                sign=1;
            } else if (c == '-') {
                result+=sign*num;
                num=0;
                sign=-1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign=1;
                result=0;
            } else if (c == ')') {
                result+=sign*num;
                num=0;
                result*=stack.pop();
                result*=stack.pop();
            }
        }
        if(num!=0)result+=sign*num;
        return result;
    }
    public int calculate1(String s) {
        if(s.length()==1)return Integer.parseInt(s);
        var stack=new ArrayDeque<Character>();
        int res=0;
        for(char c: s.toCharArray()){
            if(c==' ')continue;
            if (c!=')'){
                stack.push(c);
            }
            else {
                var cStack=new ArrayDeque<Character>();
                while(stack.peek()!='(') cStack.push(stack.pop());

                while(!cStack.isEmpty()){
                    if(cStack.peek()=='+'){
                        cStack.pop();
                        StringBuilder num = getStringBuilder(cStack);
                        res+=Integer.parseInt(num.toString());
                    }
                    else if(cStack.peek()=='-'){
                        cStack.pop();
                        StringBuilder num = getStringBuilder(cStack);
                        res-=Integer.parseInt(num.toString());
                    }
                    else {
                        StringBuilder num = getStringBuilder(cStack);
                        res+=Integer.parseInt(num.toString());
                    }
                }
                if(stack.peek()=='(')stack.pop();
                for(char at: new StringBuilder(Integer.toString(res)).reverse().toString().toCharArray())stack.push(at);
                res=0;
            }


        }
        var cStack=new ArrayDeque<Character>();
        while(!stack.isEmpty())cStack.push(stack.pop());
        if(!cStack.contains('+') && !cStack.contains('-'))return Integer.parseInt(new StringBuilder(getStringBuilder(cStack).toString()).reverse().toString());
        while(cStack.contains('+') || cStack.contains('-')) {
            if (cStack.peek() == '+') {
                cStack.pop();
                StringBuilder num = getStringBuilder(cStack);
                res += Integer.parseInt(num.toString());
            } else if (cStack.peek() == '-') {
                cStack.pop();
                StringBuilder num = getStringBuilder(cStack);
                res -= Integer.parseInt(num.toString()) ;
            } else {
                StringBuilder num = getStringBuilder(cStack);
                res += Integer.parseInt(num.toString());
            }
        }
        for(char at: Integer.toString(res).toCharArray())cStack.push(at);
        res=0;


        return Integer.parseInt(getStringBuilder(cStack).toString());
    }

    private static StringBuilder getStringBuilder(ArrayDeque<Character> stack) {
        StringBuilder num=new StringBuilder("");
        while(stack.size()>0 && stack.peek()!='(' && stack.peek()!=')' && stack.peek()!='+' && stack.peek()!='-')num.append(stack.pop());
        num.reverse();
        return num;
    }
}
