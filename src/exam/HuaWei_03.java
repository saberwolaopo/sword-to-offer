package exam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class HuaWei_03 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String []array = sc.nextLine().split(" ");
        int leftkuohao = 0;
        int rightkuohao = 0;
        String regex = "[0-9]*";
        Stack<Integer> stack = new Stack<>();
        if(!array[0].equals("(")){
            System.out.println(-1);
        }else{
            for(int i = 0;i<array.length;i++){
                if(array[i].equals("(")){
                    leftkuohao+=1;
                }
                if(array[i].equals(")")){
                    rightkuohao+=1;
                }
            }
            if(leftkuohao!=rightkuohao){
                System.out.println(-1);
            }else {
                String str = Arrays.toString(array);
                str = str.replace("("," ");
                str = str.replace(")"," ");
                String []middlearray = str.split(" ");
                String []clean = middlearray;
                for(int i = clean.length-1;i>=0;i--){
                    try{
                        if(clean[i].matches(regex)){
                            stack.push(Integer.valueOf(clean[i]));
                        }else if(clean[i].equals("^")){
                            int m = stack.pop();
                            int zizengresult = zizeng(m);
                            stack.push(zizengresult);
                        }else{
                            String string = clean[i];
                            int a = stack.pop();
                            int b = stack.pop();
                            int jiachengresult = jisuan(a,b,string);
                            stack.push(jiachengresult);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(stack.pop());
            }
        }
    }

    private static int jisuan(int a, int b, String string) {
        switch (string){
            case "+":
                return a+b;
            case "*":
                return a*b;
        }
        return 0;
    }

    private static int zizeng(int m) {
        int result = 1;
        for(int i = 0;i<m;i++){
            result+=1;
        }
        return result;
    }
}
