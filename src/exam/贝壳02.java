package exam;

import java.util.Scanner;

public class 贝壳02 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        //N -> M
        int res = 0;
        while(N>M){
            N--;
            res++;
        }
        if(N<M){
            while(N!=M){
                if(N*2<M){
                    N = N*2;
                    res++;
                }else if(N*2>M){
                    res = (int) (res+2*N-M);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
