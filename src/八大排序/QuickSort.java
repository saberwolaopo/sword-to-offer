package 八大排序;
//快速排序
public class QuickSort {
    public void quicksort(int []numbers,int low,int high){
        if(low<high){
            int middle = getmiddle(numbers,low,high);
            quicksort(numbers,0,middle-1);
            quicksort(numbers,middle+1,high);
        }
    }

    private int getmiddle(int[] numbers, int low, int high) {
        int key = numbers[low];//基准元素，排序中会空出来一个位置
        while(low<high){
            while (low<high && numbers[high]>=key){//从high中找比基准元素小的数字
                high--;
            }
            numbers[low] = numbers[high];//放到空出的那个位置
            while(low<high && numbers[low]<=key){//从low中找比基准元素大的数字
                low++;
            }
            numbers[high] = numbers[low];//放到空出的那个位置
        }
        numbers[low] = key;//此时low=high，这个位置是基准元素的位置，也是空出的位置
        return low;//返回这个位置，此时比基准元素小的全部在左边，大的全部在右边。美滋滋~
    }
}
