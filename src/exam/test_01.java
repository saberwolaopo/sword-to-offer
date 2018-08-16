package exam;
/*
   ac:95%
 */
import java.util.ArrayList;
import java.util.Scanner;

public class test_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//用户的个数
        int []num = new int[n];//文章喜好度
        for(int i = 0;i<n;i++){
            num[i] = sc.nextInt();
        }
        int q = sc.nextInt();//查询组数
        ArrayList<int[]> list = new ArrayList<>();//查询的方式
        for(int i = 0;i<q;i++){
            int []select = new int[3];
            for(int j = 0;j<3;j++){
                select[j] = sc.nextInt();
            }
            list.add(select);
        }
        for(int i = 0;i<q;i++){
            System.out.println(Find(n,num,list.get(i)));
        }
    }

    private static int Find(int n, int[] num, int[] select) {
        int l = select[0]-1;//下限
        int r = select[1]-1;//上限
        int k = select[2];//用户喜好值
        int result = 0;
        for(int i = l;i<=r;i++){
            if(num[i] == k){
                result+=1;
            }
        }
        return result;
    }
}
