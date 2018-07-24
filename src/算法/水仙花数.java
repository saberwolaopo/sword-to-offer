package 算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 水仙花数 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            fun(in.nextInt(),in.nextInt());
        }
    }

    private static void fun(int m, int n ) {
        List result = new ArrayList<Integer>();
        for (int i = m; i <= n; i++) {
            int a = i / 100;//百位数字
            int b = (i % 100) / 10;//十位数字
            int c = i % 10;//个位数字
            int index = a * a * a + b * b * b + c * c * c;
            if (index == i) {
                result.add(i);
            }
        }
        if (result.size() != 0) {
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < result.size(); i++) {
                str.append(result.get(i));
                str.append(" ");
            }
            System.out.println(str.toString());
        }else{
            String no = "no";
            System.out.println(no);
        }
    }
}
