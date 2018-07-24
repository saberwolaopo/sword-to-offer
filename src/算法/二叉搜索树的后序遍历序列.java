package 算法;
/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return fun(sequence,0,sequence.length-1);
    }

    private boolean fun(int[] a, int start, int end) {
        if(start>=end){
            return true;
        }
        int i = start;
        while(a[i]<a[end]) {
            ++i;
        }
        for(int j = i;j<end;j++){
            if(a[j]<a[end]){
                return false;
            }
        }
        return fun(a,start,i-1) && fun(a,i,end-1);
    }
}
