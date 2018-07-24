package 算法;


import java.util.HashMap;


/*
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if(length < 1 || array == null){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
        }
        int halflength = length/2;
        int result = 0;
        for(Integer key : map.keySet()){
            if(map.get(key)>halflength){
                result = key;
            }
        }
        return result;
    }
}
