package cn.alessa0.lc.offer.java;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author Alessa0
 * @version 0.0.1
 * @since 2021/1/20 15:01
 */
public class Solution09 {
    public void doSomething() {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.deleteHead();
    }
}

class CQueue {

    private final Deque<Integer> in;
    private final Deque<Integer> out;

    public CQueue() {
        this.in = new ArrayDeque<>();
        this.out = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (in.isEmpty()) {
                return -1;
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}