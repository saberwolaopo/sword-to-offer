package exam;

import java.util.Scanner;

public class Beike_02 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//村庄数量
        int price = 0;
        int []country = new int[n];//村庄海拔
        for(int i = 0;i<n;i++){
            country[i] = sc.nextInt();
        }
        int min = country[0];
        for(int i = 1;i<n;i++){
            min = Math.min(min,country[i]);
        }
        for(int i=0;i<n;i++){
            price+=country[i];
        }
        price = price-min;
        System.out.println(price);
    }
}
