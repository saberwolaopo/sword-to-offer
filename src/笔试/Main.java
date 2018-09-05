package 笔试;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    public static void select(int[] num, PriorityQueue<String> queue, int index, StringBuilder sb) {
        StringBuilder sb1 = new StringBuilder(sb);
        if (index == num.length) {
            queue.add(sb.toString());
            return;
        }
        if (num[index] == 1) {
            sb.append(index);
            select(num, queue, index + 1, sb);
        } else {

            select(num, queue, index + 1, sb);
            select(num, queue, index + 1, sb1.append(index));

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int length = line.length;
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        PriorityQueue<String> queue =new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
                char[] char1 =str1.toCharArray();
                char[] char2 = str2.toCharArray();
                int len = Math.min(char1.length, char2.length);
                for (int i = 0; i < len; i++) {
                    if(char1[i]<char2[i]) return -1;
                    if(char1[i]>char2[i]) return 1;
                }
                return char1.length>char2.length?1:-1;
            }

        });
        StringBuilder sb = new StringBuilder();
        select(num, queue, 0, sb);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}