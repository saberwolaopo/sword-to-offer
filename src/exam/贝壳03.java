package exam;

import java.util.HashMap;
import java.util.Scanner;

public class 贝壳03 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//家庭成员
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(sc.nextInt(),sc.nextInt());
        }
        int god = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) == -1){
                god = key;
            }
        }
        int m = sc.nextInt();
        for(int i = 0;i<m;i++){
            System.out.println(isfather(sc.nextInt(),sc.nextInt(),map,god));

        }

    }

    private static int isfather(int i, int j, HashMap<Integer, Integer> map,int god) {
        if(i == god){
            return 1;
        }else if(j == god){
            return 2;
        }else{
            int ivalue = i,inumber=0;
            int jvalue = j,jnumber=0;
            while(map.get(ivalue)!=god){
                ivalue = map.get(ivalue);
                inumber++;
            }
            while(map.get(jvalue)!=god){
                jvalue = map.get(jvalue);
                jnumber++;
            }
            if(ivalue == jvalue && inumber>jnumber){
                return 2;
            }else if(ivalue == jvalue && inumber<jnumber){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
