package LeetCode;
/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
(each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 */
public class edid_distance {
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int result = 0;
        int lengthcha = Math.abs(length1-length2);
        int minlength = Math.min(length1,length2);
        result += lengthcha;
        for(int i = 0;i<minlength;i++){
            if(word1.charAt(i) != word2.charAt(i)){
                result += 1;
            }
        }
        return result;
    }

    public static void main(String []args){
        String word1 = "wrqwfq";
        String word2 = "safasfasf";
        System.out.println(minDistance(word1,word2));
    }
}
