package 算法;

import java.util.HashMap;

/*
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1.
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        int result = -1;
        int length = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<length;i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i<length;i++){
            if(map.get(str.charAt(i)) == 1){
                result = i;
                break;
            }
        }
        return result;
    }
    public static void main(String []args){
        String str ="google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
