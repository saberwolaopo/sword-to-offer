package 算法;
import java.util.Stack;
/*
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class 包含min函数的栈 {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Integer temp = null;//存一个变量用于保存最小数
    //入栈
    public void push(int node) {
        if(temp!=null){
            if(node<temp){
                temp = node;
                min.push(node);
            }
            data.push(node);
        }else{
            temp = node;
            data.push(node);
            min.push(node);
        }
    }
    //出栈
    public void pop() {
        int num1 = data.pop();
        int num2 = min.pop();
        //先把2个数字都出栈，再比较如果不相等的话，就把num2入栈，因为min栈始终保存最小值
        if(num1!=num2){
            min.push(num2);
        }
    }
    //获得栈顶元素
    public int top() {
        int num = data.peek();
        return num;
    }
    //获得最小的元素，因为min栈的栈顶始终保存最小的元素
    public int min() {
        int num = min.peek();
        return num;

    }

}
