package 笔试;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 华为4 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//随机数的个数
        int []nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(nums[i]);
        }
        int size = set.size();
        Object[] newnums = new Object[size];
        newnums = set.toArray();
        Arrays.sort(newnums);
        for(int i = 0;i<size;i++){
            System.out.println(newnums[i]);
        }
    }
}
