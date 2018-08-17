package LeetCode;

import java.util.HashMap;

/*
题目描述

Given a string, find the length of the longest substring without repeating characters.
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()<1){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int leftBound = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            leftBound = Math.max(leftBound,(map.containsKey(c))?map.get(c)+1:0);
            max = Math.max(max,i-leftBound+1);
            map.put(c,i);
        }
        return max;
    }
}
