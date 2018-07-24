package mysort;

import java.util.Arrays;

public class HeapSort {
    public static void heapsort(int[] a){
        int length = a.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap(a,i,length-1);
        }
        while(length > 1){
            int temp = a[length-1];
            a[length-1] = a[0];
            a[0] = temp;
            length--;
            adjustHeap(a,0,length);
        }
    }

    private static void adjustHeap(int[] a, int parent, int length) {
        int temp = a[parent];//父节点的值
        int child = 2*parent+1;
        while (child<length){
            if(child + 1<length && a[child]<a[child+1]){
                child++;
            }
            if(temp>a[child]){
                break;
            }
            a[parent] = a[child];
            //继续向下遍历
            parent = child;
            child = 2*parent+1;
        }
        a[parent] = temp;
    }
    public static void main(String[] args) {
        int[] array = { 1,6,3,2,9,4,5,7,8 };
        HeapSort.heapsort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
