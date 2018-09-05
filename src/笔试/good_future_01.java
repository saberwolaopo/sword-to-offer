package 笔试;

import java.util.Scanner;

public class good_future_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int []num = {0,1,2,3,4,5,6,7,8,9};
        int []bool = new int[10];
        for(int i = 0;i<10;i++){
            bool[i] = sc.nextInt();
        }
        int Zeroflag = 0;
        for(int i = 0;i<10;i++){
            if(bool[i] == 0){
                Zeroflag+=1;
            }
        }

    }
}
