package 算法;
/*
题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
              1 2 8 9
              2 4 9 12
              4 7 10 13
              6 7 11 15
 */
public class 二维数组的查找 {
    public static boolean Find(int target, int[][] array) {
        int rows  = array.length; // 行数
        int columns = array[0].length; // 列数

        if(rows > 0 || columns > 0){
            int row = 0;
            int column = columns-1;
            while(row<rows && column>=0){
                if(array[row][column] == target){
                    return true;
                }
                else if(array[row][column] <target){
                    row++;
                }
                else{
                    column--;
                }
            }
        }
        return false;
    }
    public static void main(String []argv){
        int target = 5;
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,7,11,15}};
        System.out.println(Find(target,array));
    }
}
