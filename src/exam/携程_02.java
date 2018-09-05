package exam;

import java.util.*;

public class 携程_02 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();//记录数
        int selectime = sc.nextInt();//时间值
        LinkedHashMap<Integer,int[]> map = new LinkedHashMap<>();
        for(int i = 0;i<count;i++){
            int dingdan = sc.nextInt();//订单号
            int []times = new int[2];
            times[0] = sc.nextInt();
            times[1] = sc.nextInt();
            map.put(dingdan,times);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list = getresult(count,selectime,map);
        Object[] result = list.toArray();
        Arrays.sort(result);
        if(list.size()!=0){
            for(int i = 0;i<result.length;i++){
                System.out.println(result[i]);
            }
        }else{
            System.out.println("null");
        }
    }

    private static ArrayList<Integer> getresult(int count, int selectime, LinkedHashMap<Integer,int[]> map) {
        List<Integer> list = new ArrayList<>();
        for(Integer dingdan : map.keySet()){
            int times[] = map.get(dingdan);
            int intime = times[0];
            int outime = times[1];
            if(selectime>=intime && selectime<=outime){
                list.add(dingdan);
            }
        }
        return (ArrayList<Integer>) list;
    }
}
