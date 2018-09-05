package 笔试;

import java.util.Scanner;

public class good_future_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(),temp = 0,x1 = 0;
        int[][] arrays = new int[count][2];
        for (int i=0;i<count;i++){
            for (int j=0;j<2;j++){
                arrays[i][j] = sc.nextInt();
            }
        }

        while (x1<count){
            for (int i=1;i<Integer.MAX_VALUE;i++){
                if ((arrays[x1][0] + i) == (arrays[x1][0]|i)){
                    temp++;
                    if (temp == arrays[x1][1]){
                        System.out.println(i);
                    }
                }
            }
            x1++;
        }
    }
}
