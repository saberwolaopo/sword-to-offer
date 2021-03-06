package 算法;

import java.util.ArrayList;
import java.util.Arrays;

/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
{2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class 滑动窗口的最大值 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int length = num.length;
        int index = length - size + 1;//总共有多少个滑动窗口
        if(num == null || length<1 || size<1){
            return result;
        }
        for(int i = 0 ;i<index;i++){
            int []demo = new int[size];
            int z = i;
            for(int j = 0;j<size;j++){
                demo[j]= num[z++];
            }
            Arrays.sort(demo);
            int singleresult = demo[size-1];
            result.add(singleresult);
        }
        return result;
    }
    public static void main(String []argv){
        int []num = {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> result = new ArrayList<>();
        result = maxInWindows(num,size);
        System.out.println(result);
    }
}
