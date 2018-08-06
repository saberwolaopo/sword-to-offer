package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A =[1,1,1,2,2,3],
Your function should return length =5, and A is now[1,1,2,2,3].
 */
public class remove_duplicates_from_sorted_array_ii {
    public static int removeDuplicates(int[] A) {
        int length = A.length;
        if(A == null || length < 1){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(A[0]);
        int count = 1;
        for(int i = 1;i<length;i++){
            if(A[i] == A[i-1]){
                count++;
            }else{
                count = 1;
            }
            if(count == 1 || count == 2){
                list.add(A[i]);
            }
        }
        for(int i = 0;i<list.size();i++){
            A[i] = list.get(i);
        }
        return list.size();
    }
    public static void main(String []args){
        int []A = {1,1,1,2,2,3};
        removeDuplicates(A);
        System.out.println(Arrays.toString(A));
    }
}
