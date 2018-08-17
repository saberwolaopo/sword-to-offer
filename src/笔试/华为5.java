package 笔试;

import java.util.ArrayList;
import java.util.Scanner;

public class 华为5 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        for(int i = 0;i<list.size();i++) {
            System.out.println(lastnumber(list.get(i)));
        }
    }

    private static int lastnumber(int len) {
        int []number = new int[len];
        for(int i = 0;i<len;i++){
            number[i] = i;
        }
        final int DELFLAG = -1;
        int currentSize = len;
        final int step = 2;//步长
        int count = 0;//当前走的步数
        int lastDelIndex = 0;
        int i = 0;
        while(currentSize!=0){//当当前长度不为0时
            if(number[i]!=DELFLAG){//如果此时的值不为-1
                if(count++ == step){//如果此时走了2步==step
                    number[i] = DELFLAG;//设为 DELFLAG
                    lastDelIndex = i;//删除下标
                    currentSize--;//size--
                    count = 0;//归零
                }
            }
            i = (i+1) % len;//循环
        }
        return lastDelIndex;
    }
}
