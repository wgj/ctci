package io.wgj.ctci;

/**
 * Stack is a stack data structure backed by a dynamic array. It's written to
 * develop familiarity with the stack data structure.
 *
 */
public class Stack<E> {
    ArrayList<E> list;

    public Stack() {
        list =  new ArrayList<>();
    }

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        // This shouldn't been costly, since we're always removing from the top of the stack.
        return list.remove(list.size()-1);
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public int size() {
        return list.size();
    }
}
