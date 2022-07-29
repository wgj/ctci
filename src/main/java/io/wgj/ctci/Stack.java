package io.wgj.ctci;

/**
 * Stack is a stack data structure backed by a dynamic array. It's written to
 * develop familiarity with the stack data structure.
 *
 */
public class Stack<E> {
    ArrayList<E> al;

    public Stack() {
        al = new ArrayList<>();
    }

    public void push(E e) {
        al.add(e);
    }

    public E pop() {
        // This shouldn't been costly, since we're always removing from the top of the stack.
        return al.remove(al.size()-1);
    }

    public E peek() {
        return al.get(al.size()-1);
    }

    public int size() {
        return al.size();
    }
}
