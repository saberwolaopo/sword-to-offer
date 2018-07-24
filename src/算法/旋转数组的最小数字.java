package 算法;
/*
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，
我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，
输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {
    public static int minNumberInRotateArray(int [] array) {
        if(array == null){
            return 0;
        }
        int length = array.length;
        int start = 0;
        int end = length-1;
        if(array[start]<=array[end]){
            return array[start];
        }else {
            while(start<=end){
                if(array[start]<=array[start+1]){
                    start++;
                }
                if(array[end]>=array[end-1]){
                    end--;
                }
                if(end-start ==1){
                    break;
                }
            }
        }
        return array[end];
    }
    public static void main(String []args){
        int []array = {6,7,8,1,2,3};
        System.out.println(minNumberInRotateArray(array));
    }
}
