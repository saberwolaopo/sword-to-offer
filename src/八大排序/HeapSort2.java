package 八大排序;

import java.util.Arrays;

public class HeapSort2 {
    public static void adjustHeap2(int[] a, int parent, int length){
        int left = 2*parent+1;
        int right = 2*parent+2;
        int smallest = parent;
        //建立小顶堆
        while (true){
            //如果左节点的值小于父节点的值
            if(left<length && a[left]<a[smallest]){
                //最小索引变为左节点
                smallest = left;
            }
            //如果右节点的值小于父节点的值
            if(right<length && a[right]<a[smallest]){
                //最小索引变为右节点
                smallest = right;
            }
            //如果父节点的索引不等于最小值索引了，说明发生了变化。
            //那么就要交换父节点和最小索引的值，否则退出循环
            if(parent!=smallest){
                int temp = a[smallest];
                a[smallest] = a[parent];
                a[parent] = temp;
            }else{
                break;
            }
            //让此时新的父节点的索引成为最小值索引，继续遍历
            parent = smallest;
            left = 2*parent+1;
            right = 2*parent+2;
        }
    }
    public static void heapsort2(int []a){
        int length = a.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap2(a,i,length);
        }
        while(length>1){
            int temp = a[length-1];
            a[length-1] = a[0];
            a[0] = temp;
            length--;
            adjustHeap2(a,0,length);
        }
    }
    public static void main(String[] args) {
        int[] array = { 1,6,3,2,9,4,5,7,8 };
        HeapSort2.heapsort2(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
