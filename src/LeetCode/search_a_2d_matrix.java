package LeetCode;

public class search_a_2d_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int low = 0;
        int high = col-1;
        while(low<row && high>=0){
            int key = matrix[low][high];
            if(target == key){
                return true;
            }
            //目标小于右上方的值，说明需要把列数降低
            if(target<key){
                high--;
            }
            //目标大于右上方的值，说明需要把行数增加
            if(target>key){
                low++;
            }
        }
        return false;
    }
    public static void main(String []args){
        int [][]matrix = new int[1][1];
        matrix[0][0] = 1;
        System.out.println(searchMatrix(matrix,1));
    }
}
