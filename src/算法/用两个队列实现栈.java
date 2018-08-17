package 算法;

import java.util.LinkedList;
import java.util.Queue;

public class 用两个队列实现栈 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node){
        if(queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(node);
        }
        if(queue1.isEmpty()){
            queue2.add(node);
        }
        if(queue2.isEmpty()){
            queue1.add(node);
        }
    }

    public int pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            try{
                throw new Exception("stack is Empty!!!");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        if(queue2.isEmpty()){
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return Integer.parseInt(null);
    }
    public static void main(String []args){
        用两个队列实现栈 stack = new 用两个队列实现栈();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
    }
}
