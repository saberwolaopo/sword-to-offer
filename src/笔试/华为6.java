package 笔试;


import java.util.HashSet;
import java.util.Scanner;

public class 华为6 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char []chars = sc.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            HashSet<Character> set = new HashSet<>();
            for(int i = 0;i<chars.length;i++){
                while(set.add(chars[i])){
                    sb.append(chars[i]);
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
