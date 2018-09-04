package LeetCode;

import java.util.HashSet;
import java.util.Set;

/*
题目描述

Given a string s and a dictionary of words dict,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s ="leetcode",
dict =["leet", "code"].

Return true because"leetcode"can be segmented as"leet code".

40%ac
 */
public class word_break {
    public static boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        for(String str:dict){
            if(s.contains(str)){
                s=s.replaceAll(str,"");
            }
        }
        length = s.length();
        if(length==0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String []args){
        String s = "aaaaaaa";
        Set<String> set = new HashSet<>();
        set.add("aaaa");
        set.add("aaa");
        System.out.println(wordBreak(s,set));
    }
}
