package 算法;

import java.util.Arrays;

/*
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。


B[0] = A[1] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[0]）
B[1 ]= A[0] * A[2] * A[3] * A[4] *....*A[n-1] ;（没有A[1]）
B[2] = A[0] * A[1] * A[3] * A[4] *....*A[n-1] ;（没有A[2]）
 */
public class 构建乘积数组 {
    public static int[] multiply(int[] A) {
        int length = A.length;
        int []B = new int[length];
        boolean changed = false;
        for(int i = 0;i<length;i++) {
            int sum = 1;
            B[i] = 1;//先把数组B每个值都设置为1
            int index = 0;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    index = A[j];//保存A的原始值
                    A[j] = B[i];
                }
                sum *= A[j];
            }
            B[i] = sum;
            A[i] = index;//赋值完毕后，将A的原始值返回
        }
        return B;
    }
    public static void main(String[] args){
        int A[] = {1,2,3,4,5};
        int B[] = multiply(A);
        System.out.println(Arrays.toString(B));
    }
}
