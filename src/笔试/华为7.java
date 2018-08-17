package 笔试;

import java.util.HashMap;
import java.util.Scanner;

public class 华为7 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();//N个学生
            int M = sc.nextInt();//M个操作
            HashMap<Integer, Integer> map = new HashMap<>();//学生成绩表
            for (int i = 1; i <= N; i++) {
                map.put(i, sc.nextInt());
            }
            for (int i = 0; i < M; i++) {
                if (sc.next().equals("Q")) {
                    int a = sc.nextInt();//下限
                    int b = sc.nextInt();//上限
                    System.out.println(MaxGrade(map, a, b));
                } else {
                    int a = sc.nextInt();//ID
                    int b = sc.nextInt();//新成绩
                    map.put(a, b);
                }
            }
        }
    }

    private static int MaxGrade(HashMap<Integer, Integer> map, int a, int b) {
        int []scores = new int[Math.abs(b-a)+1];
        int index = 0;
        int low = Math.min(a,b);
        int high = Math.max(a,b);
        for(int i = low;i<=high;i++){
            scores[index] = map.get(i);
            index++;
        }
        int max = 0;
        int current = 0;
        for(int i = 0;i<scores.length;i++){
            current = scores[i];
            max = Math.max(max,current);
        }
        return max;
    }
}
