package 算法;
/*
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */
public class 斐波拉契数列 {
    public int Fibonacci(int n) {
        int []result = {0,1};
        if(n<2){
            return result[n];
        }
        int one = 1;
        int two = 0;
        int start = 0;
        for(int i = 2;i<=n;i++){
            start = one+two;
            two = one;
            one = start;
        }
        return start;
    }
}
