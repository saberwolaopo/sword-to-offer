package exam;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class 贝壳01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//多米诺骨牌的数量
        LinkedHashMap<Long,Long> map = new LinkedHashMap<>();//多米诺骨牌的位置和高度
        for(int i = 0;i<n;i++){
            map.put(sc.nextLong(),sc.nextLong());
        }
        for(Long key : map.keySet()){
            System.out.print(fun(map,key,map.get(key)));
            System.out.print(' ');
        }
    }

    private static int fun(LinkedHashMap map,long index, long hight) {
        int number = 1;
        long left = index + 1;
        long right = index + hight - 1;
        for(long i = left;i<=right;i++){
            if(map.containsKey(i)){
                right =  Math.max(right, i+(long) map.get(i)-1);
                number+=1;
            }
        }
        return number;
    }
}
