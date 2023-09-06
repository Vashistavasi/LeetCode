package PolishNotation;

import java.util.ArrayDeque;

class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.evalRPN(new String[] {"4","13","5","/","+"}));
	}
    public int evalRPN(String[] tokens) {
        ArrayDeque<String> stack=new ArrayDeque<String>();
        for(int i=0;i<tokens.length;i++){
            if(check(tokens[i])){
                switch(tokens[i]){
                    case "+" : {
                      int a=Integer.parseInt(stack.pop());
                      int b=Integer.parseInt(stack.pop());
                      stack.push(Integer.toString(a+b));
                      break;
                    }
                                        case "-" : {
                      int a=Integer.parseInt(stack.pop());
                      int b=Integer.parseInt(stack.pop());
                      stack.push(Integer.toString((a-b)));
                      break;
                    }
                                        case "*" : {
                      int a=Integer.parseInt(stack.pop());
                      int b=Integer.parseInt(stack.pop());
                      stack.push(Integer.toString(a*b));
                      break;
                    }
                                        case "/" : {
                      int a=Integer.parseInt(stack.pop());
                      int b=Integer.parseInt(stack.pop());
                      stack.push(Integer.toString(b/a));
                      break;
                    }
                }
            } else stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());

    }
    public boolean check(String s){
        String add="+", sub="-",div="/",mul="*";
        if(s.equals(add)||s.equals(sub)||s.equals(mul)||s.equals(div))
        return true;
        return false;
    }
}