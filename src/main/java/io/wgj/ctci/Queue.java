package io.wgj.ctci;

public class Queue<E> {
  Object[] queue;
  int head;
  int tail;
  int length;
  int capacity;
  static final int STARTING_CAPACITY = 10;

  public Queue() {
    queue = new Object[STARTING_CAPACITY];
    head = 0;
    tail = 0;
    length = 0;
    capacity = STARTING_CAPACITY;
  }

  public void add(E e) {
    if (length == capacity) {
      grow();
    }
    queue[tail] = e;
    tail++;
    length++;
  }

  public E remove() {
    if (length == 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    @SuppressWarnings("unchecked")
    E e = (E) queue[head];
    head++;
    length--;
    return e;
  }

  public E peek() {
    if (length == 0) {
      return null;
    }
    @SuppressWarnings("unchecked")
    E e = (E) queue[head];
    return e;
  }

  private void grow() {
    int newCap = capacity * 2;
    Object[] newQueue = new Object[newCap];
    // Loop from head to cap
    int copyPointer = 0;
    for (int i = head; i < capacity - 1; i++) {
      newQueue[i] = queue[i];
      copyPointer++;
    }
    // Loop from 0 to tail
    for (int i = 0; i <= tail; i++) {
      newQueue[copyPointer + i] = queue[i];
    }
    queue = newQueue;
    capacity = newCap;
    head = 0;
    tail = length;
  }

  public int getLength() {
    return length;
  }
}
