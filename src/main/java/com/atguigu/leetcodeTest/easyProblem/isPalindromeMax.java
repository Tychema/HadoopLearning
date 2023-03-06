package com.atguigu.leetcodeTest.easyProblem;

/**
 *如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class isPalindromeMax {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }
    public static boolean isPalindrome(String s) {
        int low=0;
        int high=s.length()-1;
        while(low<=high){
            char s1=s.charAt(low);
            char s2=s.charAt(high);
            while((s1<'0' || (s1>'9' && s1<'A') || (s1>'Z' && s1<'a') || s1>'z')&& low<high){
                low++;
                s1=s.charAt(low);
            }
            while((s2<'0'||(s2>'9' && s1<'A') || (s2>'Z' && s2<'a') || s2>'z' ) && low<high){
                high--;
                s2=s.charAt(high);
            }
            if(s1==s2){
                high--;
                low++;
                continue;
            }
            if((s1<='9' && s2>'9')||(s1>'9' && s2<='9')){
                return false;
            }
            if( s1+'a'-'A'==s2 || s1==s2+'a'-'A'){
                high--;
                low++;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
