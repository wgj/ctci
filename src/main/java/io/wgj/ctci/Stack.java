package io.wgj.ctci;

import static java.util.Arrays.copyOf;

/**
 * Stack is a stack data structure backed by a dynamic array. Stack can be
 * initialized with a starting array size. It's written to develop familiarity
 * with the stack data structure, and should otherwise not be used.
 * Maximum allowed array is 1024. If you set a starting capacity larger than
 * this, the maximum allowed array size is used as the starting capacity. An
 * UnsupportedOperationException will be thrown when more the maximum allowed
 * amount of elements are added.
 */
public class Stack<E> {
    static final int DEFAULT_CAPACITY = 2;
    Object[] stack;
    int capacity;
    int size;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        stack = new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public void push(E e) {
        if (capacity == size) {
            this.grow();
        }
        stack[size] = e;
        size++;
    }

    public E pop() {
        size--;
        @SuppressWarnings("unchecked")
        E e = (E) stack[size];
        return e;
    }

    private void grow() {
        int newCap = capacity * 2;
        Object[] newStack = copyOf(stack, newCap);
        capacity = newCap;
        stack = newStack;
    }

    public E peek() {
        @SuppressWarnings("unchecked")
        E e = (E) stack[size - 1];
        return e;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}
