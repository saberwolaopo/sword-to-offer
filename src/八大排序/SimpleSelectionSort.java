package 八大排序;
//简单选择排序
import java.util.Arrays;

public class SimpleSelectionSort {
    public static void simpleselectionsort(int []numbers){
        int length = numbers.length;
        for(int i = 0;i<length;i++){
            int k=i;//k存放最小值下标。每次循环最小值下标+1
            for(int j=i+1;j<length;j++){//找到最小值下标
                if(numbers[k]>numbers[j]){
                    k=j;
                }
            }
            swap(numbers,k,i);
        }
    }

    private static void swap(int[] numbers, int k, int i) {
        int temp = 0;
        temp = numbers[k];
        numbers[k] = numbers[i];
        numbers[i] = temp;
    }
    public static void main(String[] args){
        int numbers[] = {3,1,5,7,2,4,9,6,10,8};
        simpleselectionsort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
