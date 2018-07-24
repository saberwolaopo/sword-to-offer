package mysort;

public class Simpleselectionsort {
    public void simpleselectionsort(int []numbers){
        int length = numbers.length;
        for(int i = 0;i<length;i++){
            int k = i;
            for(int j=i+1;j<length;j++){
                if(numbers[k]>numbers[j]){
                    k = j;
                }
            }
            swap(numbers,k,i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
