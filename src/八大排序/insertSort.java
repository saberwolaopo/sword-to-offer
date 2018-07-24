package 八大排序;
//插入排序
public class insertSort {
    public void insertsort(int []numbers){
        for(int i = 1;i<numbers.length;i++){//从头部第一个当做已经排好序的，把后面的一个一个的插到已经排好的列表中去。
            int j;
            int x = numbers[i];//x为待插入元素
            for(j=i;j>0 && x<numbers[j-1];j--){//通过循环，逐个后移一位找到要插入的位置。
                numbers[j] = numbers[j-1];
            }
            numbers[j] = x;//插入
        }
    }
}
