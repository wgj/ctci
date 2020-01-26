package io.wgj.ctci;

public class Queue<E> {

  Object[] queue;
  int head;
  int tail;
  int length;
  int capacity;
  final static int STARTING_CAPACITY = 1;

  public Queue() {
    queue = new Object[STARTING_CAPACITY];
    head = 0;
    tail = 0;
    length = 0;
    capacity = STARTING_CAPACITY;
  }

  public void add(E e) {
    queue[tail] = e;
    tail++;
    length++;
    if (length == capacity) {
      grow();
    }
  }

  public E remove() {
    E e = (E) queue[head];

    return e;
  }

  public E peek() {
    Object o = queue[head];
    return (E) o;
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
}
