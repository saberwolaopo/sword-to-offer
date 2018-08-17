package 笔试;

import java.util.Arrays;

public class 华为3 {
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public static void swapWithZero(int[] array, int len, int n) {
        int indexZero = 0;
        int indexn = 0;
        for(int i = 0;i<len;i++){
            if(array[i] == 0){
                indexZero = i;
            }
            if(array[i] == n){
                indexn = i;
            }
        }
        int temp = array[indexZero];
        array[indexZero] = array[indexn];
        array[indexn] = temp;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public static void sort(int[] array, int len) {
        for(int i = 0;i<len;i++){
            if(i == array[i]){
                continue;
            }
            swapWithZero(array,len,array[i]);
            swapWithZero(array,len,i);
        }
    }
    public static void main(String []args){
        int []array = {1,5,4,2,3,0};
        sort(array,6);
        System.out.println(Arrays.toString(array));
    }
}