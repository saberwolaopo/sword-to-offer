package exam;

import java.util.HashMap;
import java.util.Scanner;

public class HuaWei_02 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        //初始化客人数量
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 12;i<20;i++){
            map.put(i,0);
        }
        while (sc.hasNext()){
            String []s = sc.nextLine().split(",");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            if(a!=-1 && b!=-1){
                MaxNum(map,a,b);
            }
        }
        for(int i = 12;i<20;i++){
            System.out.println("["+i+","+(i+1)+")"+":"+map.get(i));
        }
    }

    private static void MaxNum(HashMap<Integer, Integer> map, int a, int b) {
        for(int i = a;i<b;i++){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
    }
}
