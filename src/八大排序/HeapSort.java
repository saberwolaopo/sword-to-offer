package 八大排序;

import java.util.Arrays;

//堆排序
public class HeapSort {
    public static void heapsort(int[] numbers){
        //先构建一个大顶堆
        int length = numbers.length;
        for(int i = length/2;i>=0;i--){
            adjustHeap(numbers,i,length);
        }
        //对数组排序，每次把最小的甩到头部，然后重建大顶堆
        while(length>1){
            int temp = numbers[length-1];
            numbers[length-1] = numbers[0];
            numbers[0] = temp;
            length--;
            adjustHeap(numbers,0,length);
        }
    }

    private static void adjustHeap(int[] numbers, int parent, int length) {
        int temp = numbers[parent];//父节点的值
        int child = 2*parent + 1;//左子节点的下标
        while(child<length){
            if(child+1<length && numbers[child]<numbers[child+1])//如果有右子节点，并且右子节点的值大于左子节点
                child++;//将左子节点变成右子节点
            if(temp>numbers[child]){
                break;
            }
            numbers[parent] = numbers[child];//将父节点的值变成左节点的值
            //继续向下遍历
            parent = child;
            child = 2*parent+1;
        }
        numbers[parent] = temp;
    }
    public static void main(String[] args) {
        int[] array = { 1,6,3,2,9,4,5,7,8 };
        HeapSort.heapsort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
