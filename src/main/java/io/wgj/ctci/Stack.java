package io.wgj.ctci;

public class Stack {
    int[] stack;
    int position;

    public Stack() {
        stack = new int[10];
        position = 0;
    }

    public void push(int i) {
        stack[position] = i;
        position++;
    }

    public int pop() {
        position--;
        return stack[position];
    }
}
