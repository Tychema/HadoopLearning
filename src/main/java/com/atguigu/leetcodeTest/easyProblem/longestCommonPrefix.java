package com.atguigu.leetcodeTest.easyProblem;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String s=longestCommonPrefix2(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix2(String[] strs) {
        String s=strs[0];
        int len=0;
        for(int i=1;i<strs.length;i++){
            if(strs[i].equals("")){
                return "";
            }
            if(s.length()<strs[i].length()){
                len=s.length();
            }
            else{
                len=strs[i].length();
            }
            for(int j=0;j<len;j++){
                if(s.charAt(j)!=strs[i].charAt(j)){
                    s=s.substring(0,j);
                    break;
                }
                if(j==len-1){
                    s=s.substring(0,len);
                }
            }
        }
        return s;
    }
}
