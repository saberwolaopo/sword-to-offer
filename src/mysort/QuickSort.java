package mysort;

import java.util.Arrays;

public class QuickSort {
    public static void quicksort(int[] a, int low, int high){
        if(low<high){
            int middle = getmiddle(a,low,high);
            quicksort(a,0,middle-1);
            quicksort(a,middle+1,high);
        }
    }

    private static int getmiddle(int[] a, int low, int high) {
        int key = a[low];
        while(low<high){
            while(low<high && a[high]>=key){
                high--;
            }
            a[low] = a[high];//比基准值小的放到空的位置去
            while(low<high && a[low]<=key){
                low++;
            }
            a[high] = a[low];//比基准值大的放大空的位置去
        }
        a[low] = key;
        return low;
    }

    private static void quicksort2(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        quicksort2(a, low, i - 1); // 对低子表进行递归排序
        quicksort2(a, i + 1, hight); // 对高子表进行递归排序

    }
    public static void main(String[] args){
        int[] array = { 1,6,3,2,9,4,5,7,8 };
        quicksort2(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
