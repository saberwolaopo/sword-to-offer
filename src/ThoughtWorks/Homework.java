package ThoughtWorks;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework {
    public static void main(String []args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> commandlist = new ArrayList<>();
        ArrayList<Integer> datalist = new ArrayList<>();
        if(in.hasNextLine()) {
            String firstdata = in.nextLine();
            String lastdata = in.nextLine();
            commandlist = (ArrayList<Integer>) Intercept(firstdata);//迷宫list
            datalist = (ArrayList<Integer>) Intercept(lastdata);//通道list
        }
        int length = 2 * commandlist.get(0) + 1;//长度
        int width = 2 * commandlist.get(1) + 1;//宽度
        String [][]result = new String[length][width];//初始化一个二维字符串数组
        int value = datalist.size()/4;//四个数字组成1组
        List<int[]> reardatalist = new ArrayList<>();
        for(int i = 0;i<value;i++){
            int []a = new int[2];
            int []b = new int[2];
            //把拿出来的数据每次都转化为正确的下标值
            a[0] = Transform(datalist.get(4*i));
            a[1] = Transform(datalist.get(4*i + 1));
            b[0] = Transform(datalist.get(4*i + 2));
            b[1] = Transform(datalist.get(4*i + 3));
            int []middle = getmiddle(a,b);
            reardatalist.add(a);
            reardatalist.add(b);
            reardatalist.add(middle);
        }
        for(int i = 0;i<length;i++){
            for(int j = 0;j<width;j++){
                result[i][j] = "[W] ";
            }
        }
        for(int i = 0;i<reardatalist.size();i++){
            int singlerealdata[] = reardatalist.get(i);
            System.out.println(Arrays.toString(singlerealdata));
            int x = singlerealdata[0];
            int y = singlerealdata[1];
            result[x][y] = "[R] ";
        }
        for(int i = 0;i<length;i++){
            for(int j = 0;j<width;j++){
                System.out.print(result[i][j]);
            }
            System.out.println("");
        }
    }
    public static List<Integer> Intercept(String str) throws Exception{
        ArrayList<Integer> list = new ArrayList<>();
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(str);
        String result = m.replaceAll("");
        for (int i = 0; i < result.length(); i++) {
            list.add(Integer.valueOf(result.substring(i, i+1)));
        }
        if(list.size() == 0){
            throw new Exception("Invalid number format.");
        }
        for (int i = 0;i<list.size();i++){
            if(list.get(i)<0){
                throw new Exception("Number out of range.");
            }
        }
        return list;
    }
    public static int Transform(int i){
        return 2 * i+1;
    }
    public static int[] getmiddle(int []a,int []b) throws Exception {
        int result[] = new int[2];
        if((a[0]!=b[0] && a[1]!=b[1]) || (a[0]==b[0] && a[1]==b[1])){
            throw new Exception("Maze format error.");
        }
        if(a[0] == b[0]){
            result[0] = a[0];
            result[1] = Math.max(a[1],b[1])-1;
        }else{
            result[0] = Math.max(a[0],b[0])-1;
            result[1] = a[1];
        }
        return result;
    }
}
