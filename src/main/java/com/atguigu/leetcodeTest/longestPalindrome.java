package com.atguigu.leetcodeTest;

public class longestPalindrome {
    public static void main(String[] args) {
        String s=longestPalindrome("cbbd");
        System.out.println(s);
    }
    public static String longestPalindrome(String s) {
        String s1="";
        for(int i=0;i<s.length();i++){
            String s2=Palindrome(s,i,i);
            if(s2.length()>s1.length()){
                s1=s2;
            }
            s2=Palindrome(s,i,i+1);
            if(s2.length()>s1.length()){
                s1=s2;
            }
        }
        return s1;
    }
    public static String Palindrome(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;right++;
        }
        return s.substring(left+1,right);
    }
}
