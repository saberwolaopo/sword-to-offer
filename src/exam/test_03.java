package exam;



import java.util.Scanner;

public class test_03 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int result=0;
        int n = sc.nextInt();
        long[] a = new long[n];//a长度序列
        long[] b = new long[n];//b长度序列
        for (int i = 0; i < n; i++) {
             a[i] =  sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] =  sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            int high = (int) a[i];
            int low = (int) b[i];
            if (high < low) {
                result+=1;//如果a比b小，本身就形成一个区间
            } else {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (high < a[j]) {
                    high = (int) a[j];
                }
                if (low > b[j]) {
                    low = (int) b[j];
                }
                if (high < low) {
                    result+=1;
                } else {
                    break;
                }
            }
        }
        System.out.println(result);
    }

}

