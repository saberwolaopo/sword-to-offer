package com.company;

import org.junit.Test;

import java.util.Arrays;

public class TopK {
    //重建堆
    public void adjustHeap(int []a,int i,int len){
        //i为根节点的索引
        int left = 2*i+1;
        int right = 2*i+2;
        int smallest = i;
        while(true){
            //如果左节点小于根节点，最小值设为左节点的索引
            if(left<len && a[left]<a[smallest]){
                smallest = left;
            }
            //如果右节点小于根节点，最小值设为右节点的索引
            if(right<len && a[right]<a[smallest]){
                smallest = right;
            }
            if(i!=smallest){
                int temp = a[i];
                a[i] = a[smallest];
                a[smallest] = temp;
            }else{
                break;
            }
            i = smallest;
            left = i*2+1;
            right = i*2+2;
        }
    }
    //生成小顶堆
    public void buildHeap(int []a , int len){
        for(int i = len/2;i>=0;i--){
            adjustHeap(a,i,len);
        }
    }
    @Test
    public void testTopK(){
        int[] a={49,38,65,97,76,13,49,78,34,12,64};
        int k=5;
        int[] topK=new int[k];
        for(int i=0;i<k;i++){
            topK[i]=a[i];
        }
        buildHeap(topK, k);
        for(int i=k;i<a.length;i++){
            int root=topK[0];
            //当数据大于根结点的时候，替换根节点，并进行更新堆
            if(a[i]>root){
                topK[0]=a[i];
                //buildMinHeap(topK, k);
                adjustHeap(topK, 0, k);
            }
        }
        //buildMinHeap(a,a.length);

        System.out.println(Arrays.toString(topK));

    }
}
