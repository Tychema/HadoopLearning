package com.atguigu.leetcodeTest.easyProblem;

import java.util.HashMap;
import java.util.Map;

public class romanToInt {
    public int romanToInt2(String s) {
        Map<Character,Integer> hashtable=new HashMap<Character,Integer>();
        hashtable.put('I',1);
        hashtable.put('V',5);
        hashtable.put('X',10);
        hashtable.put('L',50);
        hashtable.put('C',100);
        hashtable.put('D',500);
        hashtable.put('M',1000);
        int sum=0;
        int forenum=0;
        for(int i=s.length()-1;i>=0;i--){
            int nownum=hashtable.get(s.charAt(i));
            if(nownum<forenum){
                sum-=nownum;
            }else{
                sum+=nownum;
            }
            forenum=nownum;
        }
        return sum;
    }
}
