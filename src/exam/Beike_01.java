package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Beike_01 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//表示n个社团
        ArrayList<int[]> list = new ArrayList<>();//社团时间表
        for(int i = 0;i<n;i++){
            int []time = new int[2];
            time[0] = sc.nextInt();
            time[1] = sc.nextInt();
            list.add(time);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int m = 0;
        for(int i = 0;i<n;i++){
            int index[] = list.get(i);
            list.remove(i);
            if(NoFight(list)){
                m+=1;
                result.add(i+1);
            }
            list.add(i,index);
        }
        System.out.println(m);
        if(result.size()>0) {
            Object[] array = result.toArray();
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    private static boolean NoFight(ArrayList<int[]> list) {
        int size = list.size();
        for(int i = 0;i<size-1;i++){
            for(int j = i+1; j<size; j++){
                if(Nofight2array(list.get(i),list.get(j))) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean Nofight2array(int[] lr1, int[] lr2) {
        Arrays.sort(lr1);
        Arrays.sort(lr2);
        if(lr1[1]<=lr2[0] || lr2[1]<=lr1[0]){
            return true;
        }else {
            return false;
        }
    }
}
