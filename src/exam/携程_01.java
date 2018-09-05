package exam;

import java.util.Scanner;

public class 携程_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        System.out.println(Twofone(number));
    }

    private static int Twofone(long number) {
        int count = 0;
        while(number!=0){
            count++;
            number = number & (number-1);
        }
        return count;
    }
}
