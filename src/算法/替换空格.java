package 算法;
/*
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        char[] strchar = string.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<strchar.length;i++){
            if(strchar[i] == ' '){
                sb.append("%20");
            }else {
                sb.append(strchar[i]);
            }
        }
        return sb.toString();
    }
}
