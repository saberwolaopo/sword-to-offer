package exam;

import java.util.HashSet;
import java.util.Scanner;

public class HuaWei_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.next().toCharArray();
        HashSet<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<chars.length;i++){
            if(set.add(chars[i])){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
