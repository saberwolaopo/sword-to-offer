package 算法;

import java.util.ArrayList;
import java.util.Iterator;

/*
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
public class 和为S的两个数字 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = array.length;
        int start = 0;
        int end = length - 1;
        if(length<1){
            return result;
        }
        while(start<end){
            if(array[start]+array[end]<sum){
                start++;
            }
            if(array[start]+array[end]>sum){
                end--;
            }
            if(array[start]+array[end]==sum){
                break;
            }
        }
        if(array[start]+array[end] == sum) {
            result.add(array[start]);
            result.add(array[end]);
            return result;
        }else{
            return result;
        }
    }
    public static void main(String []args){
        int []array = {};
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        result = FindNumbersWithSum(array,sum);
        Iterator<Integer> it = result.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
