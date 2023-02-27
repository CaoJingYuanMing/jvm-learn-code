package org.example.leedcode.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String test = "abcabcbb";
        int count = lengthOfLongestSubstring2(test);
        System.out.println("=========result==========");
        System.out.println(count);
    }

    /*
       题解参考：
       https://blog.csdn.net/djdjdjcux/article/details/104645003
     */

    /**
     * 滑动窗口解法
     *
     * @param s 入参
     * @return 最长的不重复字串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0, end = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>(s.length());

        // 滑动窗口set，保证set里的元素是不重复的
        // 每次遇到重复的元素，起始指针往后移动一位
        while (start < n && end < n) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                maxLength = Math.max(maxLength, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return maxLength;
    }

    /**
     * 优化后的滑动窗口解法
     *
     * @param s 入参
     * @return 最长的不重复字串长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        // 滑动窗口set，保证set里的元素是不重复的
        // 每次遇到重复的元素，起始指针往后移动一位
        for (int i = 0, j = 0; j < n; j++) {
            // 如果遍历到重复元素
            if (map.containsKey(s.charAt(j))) {
                // 防止索引回溯
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);

            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}

