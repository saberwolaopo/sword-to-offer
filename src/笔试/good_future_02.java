package 笔试;

import java.util.Scanner;

public class good_future_02 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = 0;
        int res = 0;
        int n = 0;
        while(n != str.length()){
            res = (int)str.charAt(n);
            while(res % 3 != 0){
                n++;
                res =  res+(int)str.charAt(n);
            }
            if(res % 3 == 0){
                max = max+1;
            }
            n++;
        }
        System.out.println(max);
    }
}
