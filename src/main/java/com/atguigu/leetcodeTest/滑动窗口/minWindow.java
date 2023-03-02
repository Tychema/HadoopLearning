package com.atguigu.leetcodeTest.滑动窗口;

import java.util.HashMap;
//LeetCode 76最小覆盖字串
//滑动窗口
public class minWindow {
    public static void main(String[] args) {
        String result=minWindow("aa","aa");
        System.out.println(result);
    }
    public static String minWindow(String s, String t){
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i=0;i<t.length();i++){
            if(need.containsKey(t.charAt(i))){
                need.put(t.charAt(i),need.get(t.charAt(i))+1);
            }else{
                need.put(t.charAt(i),1);
            }
        }
        int left = 0, right = 0,valid = 0,start = 0, len =Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                if(window.containsKey(c)){
                    window.put(c,window.get(c)+1);
                }else{
                    window.put(c,1);
                }
                if (window.get(c) <= need.get(c)) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == t.length()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start+len);
    }
}
