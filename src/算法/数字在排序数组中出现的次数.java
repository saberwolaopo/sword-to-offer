package 算法;

import com.company.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

/*
题目描述
统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if(array == null || length < 1){
            return 0;
        }
        int start = 0;
        int end = length-1;
        while((array[start]!=k || array[end]!=k) && start<end){
            if(array[start]!=k){
                start++;
            }
            if(array[end]!=k){
                end--;
            }
        }
        if(start == end){
            if(array[start]==k){
                return 1;
            }else{
                return 0;
            }
        }
        return end-start+1;
    }
    public static void main(String []args){
        int array[] = {};
        System.out.println(GetNumberOfK(array,1));
    }
}
