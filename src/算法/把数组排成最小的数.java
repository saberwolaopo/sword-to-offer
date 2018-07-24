package 算法;



/*
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
        String str = "";
        int length = numbers.length;
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                int a = Integer.valueOf(numbers[i]+""+numbers[j]);
                int b = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(a>b){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i = 0;i<length;i++){
            str+=String.valueOf(numbers[i]);
        }
        return str;
    }
    public static void main(String []argv){
        int []numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
