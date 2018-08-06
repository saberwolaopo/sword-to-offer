package LeetCode;
/*

Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

 */
public class merge_two_sorted_arrays {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(i>=0 && j>=0){
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        //如果i走完了，但是j还没走完，说明j剩下的值全部小于之前的值，甩在最前面即可
        while(j>=0){
            A[index--] = B[j--];
        }
    }
}
