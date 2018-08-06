package LeetCode;



public class remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return 1;
        }
        int count = 1;//不重复的个数
        int index = 1;//不重复开始的索引
        for(int i = 0;i<A.length-1;i++){
            if(A[i]!=A[i+1]){
                count++;
                A[index++] = A[i+1];
            }
        }
        return count;
    }
}
