package com.atguigu.leetcodeTest.easyProblem;


import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        String s ="abcdefg";
        System.out.println(s.substring(0,3));
    }
    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<n;i++){
            Character c=s.charAt(i);
            if(c=='(' || c=='{' || c=='[' ){
                st.push(c);
            }
            if(c==')' || c=='}' || c==']' ){
                if(st.empty()){
                    return false;
                }
                Character c2=st.pop();
                if((c==')' && c2!='(') || (c==']' && c2!='[') ||(c=='}' && c2!='{')){
                    return false;
                }
            }
        }
        if(!st.empty())
            return false;
        return true;
    }
}
