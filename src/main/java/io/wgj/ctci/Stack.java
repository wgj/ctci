package io.wgj.ctci;

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
    static final int MAX_ARRAY_SIZE = 1024;
    static final int DEFAULT_CAPACITY = 10;
    Object[] stack;
    int size;
    int position;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int size) {
        stack = new Object[size];
        if (size > MAX_ARRAY_SIZE) {
            size = MAX_ARRAY_SIZE;
        }
        this.size = size;
        position = 0;
    }

    public void push(E e) {
        if (size == position) {
            this.grow();
        }
        stack[position] = e;
        position++;
    }

    public E pop() {
        position--;
        @SuppressWarnings("unchecked")
        E e = (E) stack[position];
        return e;
    }

    private void grow() {
        int newSize = size << 2;
        if (newSize > MAX_ARRAY_SIZE) {
            int leftOver = MAX_ARRAY_SIZE - size;
            // Squeeze out the remaining space we'd lose.
            if (leftOver > 0) {
                newSize = leftOver + size;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        Object[] newStack = new Object[newSize];
        size = newSize;
        stack = newStack;
    }

    public E peek() {
        @SuppressWarnings("unchecked")
        E e = (E) stack[position - 1];
        return e;
    }

    public int size() {
        return position;
    }

    public int capacity() {
        return size;
    }

    public int maxSize() {
        return MAX_ARRAY_SIZE;
    }
}
