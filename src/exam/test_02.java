package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class test_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//珠子个数
        int m = sc.nextInt();//连续m个串珠
        int c = sc.nextInt();//手串颜色

        ArrayList<int[]> list = new ArrayList<>();//每个珠子的颜色
        for(int i = 0;i<n;i++){
            int num_i = sc.nextInt();//第i个珠子有几种颜色
            int num[] = new int[num_i];
            for(int j = 0;j<num_i;j++){
                num[j] = sc.nextInt();
            }
            list.add(num);
        }
        System.out.println(outofcolor(n,m,c,list));
    }

    private static int outofcolor(int n, int m, int c, ArrayList<int[]> list) {
        int result = 0;
        for(int i = 1;i<=c;i++){
            ArrayList<Integer> singleresult = new ArrayList<>();
            for(int j = 0;j<list.size();j++){
                int num[] = list.get(j);
                for(int z = 0;z<num.length;z++){
                    if (i == num[z]){
                        singleresult.add(j+1);
                    }
                }
            }
            if(samecolor(singleresult,m)){
                result+=1;
            }
        }
        return result;
    }
    //这个方法判断这个颜色列表中，在m个数字中是否有连续的数字
    private static boolean samecolor(ArrayList<Integer> singleresult,int m) {
        for(int i = 0;i<singleresult.size()-1;i++){
            int a = Math.abs(singleresult.get(i)-singleresult.get(i+1));
            if(a<=m-1){
                return true;
            }
        }
        if(Math.abs(singleresult.get(0)-singleresult.get(singleresult.size()-1))<=m-1){
            return true;
        }
        return false;
    }
}
