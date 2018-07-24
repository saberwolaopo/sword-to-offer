package 八大排序;
/**
 * 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @param numbers 需要排序的整型数组
 */
public class bubbleSort {
    public static void bubblesort(int []numbers){
        int length = numbers.length;
        int temp = 0;
        for(int i = 0;i<length-1;i++){
            for(int j = 0;j<length-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                    temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}
